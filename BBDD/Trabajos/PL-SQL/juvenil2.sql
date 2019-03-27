--1.1 ---------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE EJER1
IS

CURSOR uno IS SELECT NOMBRE, DIRECCION, DNI FROM SOCIOS;

vDni VARCHAR2(10);
vNum NUMBER(2) := 0;

CURSOR dos IS SELECT NOMBRE, AUTOR, EDITORIAL, FECHAPRESTAMO FROM LIBROS, PRESTAMOS WHERE LIBROS.REFLIBRO = PRESTAMOS.REFLIBRO AND PRESTAMOS.DNI = vDni ORDER BY FECHAPRESTAMO DESC;

BEGIN

FOR v_uno IN uno LOOP
    vNum := 0;
    DBMS_OUTPUT.PUT_LINE(v_uno.NOMBRE ||  ' ' || v_uno.DIRECCION);
    vDni := v_uno.DNI;
    FOR v_dos IN dos LOOP
        DBMS_OUTPUT.PUT_LINE('***** ' || v_dos.NOMBRE || ' ' || v_dos.AUTOR || ' ' || v_dos.EDITORIAL);
        vNum := vNum + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('********** Libros prestados: ' || vNum);
END LOOP;

END;
/

SET SERVEROUTPUT ON
BEGIN
EJER1();
END;
/

--1.2 ---------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE SOCIOS
ADD LIBROS_PRESTADOS NUMBER(2) DEFAULT 0;

CREATE OR REPLACE PROCEDURE EJER2
IS

CURSOR uno IS SELECT DNI, NOMBRE FROM SOCIOS;

vDni VARCHAR2(10);
vNum NUMBER(2) := 0;

CURSOR dos IS SELECT NOMBRE FROM LIBROS, PRESTAMOS WHERE LIBROS.REFLIBRO = PRESTAMOS.REFLIBRO AND PRESTAMOS.DNI = vDni;

BEGIN

FOR v_uno IN uno LOOP
    vNum := 0;
    vDni := v_uno.DNI;
    FOR v_dos IN dos LOOP
        vNum := vNum + 1;
    END LOOP;
    UPDATE SOCIOS
    SET LIBROS_PRESTADOS = vNum
    WHERE DNI = vDni;
END LOOP;

END;
/

SET SERVEROUTPUT ON
BEGIN
EJER2();
END;
/

CREATE OR REPLACE TRIGGER EJER1
AFTER INSERT ON PRESTAMOS
    FOR EACH ROW
    BEGIN
        UPDATE SOCIOS
        SET LIBROS_PRESTADOS = LIBROS_PRESTADOS + 1
        WHERE SOCIOS.DNI = :new.DNI;
    END;
    
--PRUEBO QUE FUNCIONA:    
--INSERT INTO PRESTAMOS(DNI, REFLIBRO, FECHAPRESTAMO, DURACION)
--VALUES('111-A', 'C-1', '26/05/2018', 24);

--1.3 ---------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE FUNCTION EJER3(vDni SOCIOS.DNI%TYPE, vRef LIBROS.REFLIBRO%TYPE)RETURN NUMBER
IS

v_Dni VARCHAR2(10) := '';
v_Ref VARCHAR2(10) := '';
vErrorD NUMBER(2) := 0;
vErrorR NUMBER(2) := 0;

BEGIN

    BEGIN
        SELECT DNI INTO v_Dni FROM SOCIOS WHERE DNI = vDni;
        
        EXCEPTION
        WHEN no_data_found THEN
        vErrorD := 1;
    END;
    
    BEGIN
        SELECT REFLIBRO INTO v_Ref FROM LIBROS WHERE REFLIBRO = vRef;
        
        EXCEPTION
        WHEN no_data_found THEN
        vErrorR := 1;
    END;
    
    IF(vErrorD = 1 AND vErrorR = 0) THEN
        RETURN -10;
    ELSIF(vErrorD = 0 AND vErrorR = 1) THEN
        RETURN -10;
    ELSIF(vErrorD = 1 AND vErrorR = 1) THEN
        RETURN -50;
    ELSE
        INSERT INTO PRESTAMOS(DNI, REFLIBRO, FECHAPRESTAMO, DURACION)
        VALUES(vDni, vRef, SYSDATE, 10);
        RETURN 1;
    END IF;
    
END;
/

SET SERVEROUTPUT ON
BEGIN
DBMS_OUTPUT.PUT_LINE(EJER3('111-A', 'E-1'));
END;
/

--2.1 ---------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE ASIGNATURAS
ADD NALUMNOS NUMBER(2) DEFAULT 0;

CREATE OR REPLACE PROCEDURE EJER2_1
IS

vNum NUMBER (2) := 0;
vCod NUMBER (2) := 0;

CURSOR uno IS SELECT COD, COUNT(ALUMNOS.DNI) AS NALUMNOS FROM ALUMNOS, NOTAS WHERE ALUMNOS.DNI = NOTAS.DNI GROUP BY COD;

BEGIN

FOR v_uno IN uno LOOP
    vNum := v_uno.NALUMNOS;
    vCod := v_uno.COD;

    UPDATE ASIGNATURAS
    SET NALUMNOS = vNum
    WHERE COD = vCod;
END LOOP;

END;
/

SET SERVEROUTPUT ON
BEGIN
EJER2_1();
END;
/

CREATE OR REPLACE TRIGGER EJER2_1
AFTER INSERT OR DELETE OR UPDATE ON NOTAS
FOR EACH ROW
BEGIN

    IF INSERTING THEN
        UPDATE ASIGNATURAS
        SET NALUMNOS = NALUMNOS + 1
        WHERE COD = :new.COD;
    ELSIF DELETING THEN
        UPDATE ASIGNATURAS
        SET NALUMNOS = NALUMNOS - 1
        WHERE COD = :old.COD;
    ELSE
        UPDATE ASIGNATURAS
        SET NALUMNOS = NALUMNOS - 1
        WHERE COD = :old.COD;
        
        UPDATE ASIGNATURAS
        SET NALUMNOS = NALUMNOS + 1
        WHERE COD = :new.COD;
    END IF;
END;
/

--2.2 ---------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE ALUMNOS
ADD NOMBRE VARCHAR2(20);

ALTER TABLE ALUMNOS
ADD APELLIDO VARCHAR2(50);

CREATE OR REPLACE TRIGGER EJER2_2
AFTER INSERT OR DELETE OR UPDATE ON ALUMNOS
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        UPDATE ALUMNOS
        SET NOMBRE = :new.APENOM
        
--SELECT SUBSTR(APENOM, 1, CHARINDEX(',', APENOM, 1)) AS APELLIDO,
--SUBSTR(APENOM, CHARINDEX(',', APENOM, 1), 10) AS NOMBRE
--FROM ALUMNOS;
