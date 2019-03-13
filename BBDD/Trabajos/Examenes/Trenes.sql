--EJ1

ALTER TABLE ESTACION
ADD num_accesos NUMBER(3,0);

CREATE OR REPLACE PROCEDURE EJ1
IS

CURSOR c1 IS SELECT ESTACION, COUNT(ESTACION) Estaciones FROM ACCESO GROUP BY ESTACION;
aux NUMBER;

BEGIN

FOR v_c1 IN c1 LOOP
    UPDATE ESTACION SET NUM_ACCESOS = v_c1.Estaciones WHERE CODIGO = v_c1.ESTACION;
END LOOP;
END;
/

BEGIN
EJ1();
END;
/

--EJ2

CREATE OR REPLACE FUNCTION EJ2(modeloT TREN.MODELO%TYPE, vel TREN.VELOCIDAD_MAXIMA%TYPE, coch TREN.COCHERA%TYPE, entraSal IN OUT TREN.CODIGO%TYPE) RETURN NUMBER
IS

codEstacion NUMBER;

BEGIN

    SELECT ESTACION INTO codEstacion FROM COCHERA WHERE CODIGO = coch;
    BEGIN
        SELECT max(codigo)+1 INTO entraSal FROM TREN;
        INSERT INTO TREN(codigo, modelo, velocidad_maxima, fecha_entrada, cochera)
        VALUES(entraSal, modeloT, vel, sysdate, coch);
    END;
        RETURN 1;
    
    EXCEPTION
        WHEN no_data_found THEN
            RETURN 0;
END;
/

SET SERVEROUTPUT ON
DECLARE
entraSal NUMBER;
BEGIN
    IF ((EJ2('MODELO 888', 999, 16, entraSal)) = 1) THEN
        DBMS_OUTPUT.PUT_LINE('Introducido: ' || entraSal);
    ELSE
        DBMS_OUTPUT.PUT_LINE('No existe la cochera');
    END IF;
END;
/

--EJ3

SET SERVEROUTPUT ON
DECLARE
entraSal NUMBER;
BEGIN
    IF ((EJ2('MODELO 888', 999, 16, entraSal)) = 1) THEN
        DBMS_OUTPUT.PUT_LINE('Introducido: ' || entraSal);
    ELSE
        DBMS_OUTPUT.PUT_LINE('No existe la cochera');
    END IF;
END;
/
--EJ4

CREATE OR REPLACE PROCEDURE EJ4
IS


CURSOR nombreL IS SELECT DISTINCT * FROM LINEA ORDER BY CODIGO;

aux LINEA.CODIGO%TYPE;
CURSOR nombreE IS SELECT DISTINCT ESTACION.* FROM ESTACION, LINEA_ESTACION, LINEA WHERE ESTACION.CODIGO = LINEA_ESTACION.ESTACION AND LINEA_ESTACION.LINEA = LINEA.CODIGO AND LINEA.CODIGO = aux ORDER BY ESTACION.NOMBRE;

BEGIN

FOR v_nombreL IN nombreL LOOP
    DBMS_OUTPUT.PUT_LINE('Linea: ' || v_nombreL.NOMBRE || ' ' || 'Cobertura: ' || v_nombreL.COBERTURA);
    aux := v_nombreL.CODIGO;
    FOR v_nombreE in nombreE LOOP
        DBMS_OUTPUT.PUT_LINE('***** ' || v_nombreE.NOMBRE || ' ' || 'Distrito: ' || v_nombreE.DISTRITO);
    END LOOP;
END LOOP;

END;
/

BEGIN
EJ4();
END;
/

--EJ5

CREATE OR REPLACE FUNCTION EJ5(codL LINEA_ESTACION.LINEA%TYPE, codE LINEA_ESTACION.ESTACION%TYPE, numOrd LINEA_ESTACION.NUMERO_ORDEN%TYPE)RETURN NUMBER
IS

CURSOR linOrden IS SELECT * FROM LINEA_ESTACION;

encontradoL NUMBER := 0;
encontradoE NUMBER := 0;
insertadoS NUMBER := 0;

BEGIN

    FOR vlinOrden IN linOrden LOOP
        IF(vlinOrden.LINEA = codL) THEN
            encontradoL := 1;
        END IF;
        IF(vlinOrden.ESTACION = codE) THEN
            encontradoE := 1;
        END IF;
        IF(vlinOrden.NUMERO_ORDEN = numOrd) THEN
            insertadoS := 1;
        END IF;
    END LOOP;
    
    IF(encontradoL != 1 AND encontradoE = 1) THEN
        RETURN -10;
    ELSIF(encontradoL = 1 AND encontradoE != 1) THEN
        RETURN -20;
    ELSIF(encontradoL != 1 AND encontradoE != 1) THEN
        RETURN -40;
    ELSIF(encontradoL = 1 AND encontradoE = 1 AND insertadoS = 1) THEN
        RETURN -50;
    ELSE
        INSERT INTO LINEA_ESTACION(LINEA, ESTACION, NUMERO_ORDEN)
        VALUES(codL, codE, numOrd);
        RETURN 1;
    END IF;
    
    EXCEPTION
    WHEN no_data_found THEN
    DBMS_OUTPUT.PUT_LINE('ERROR');
    
END;
/

SET SERVEROUTPUT ON
BEGIN
DBMS_OUTPUT.PUT_LINE(EJ5(410, 40, 1));
END;
/

--TRIGGER 1

--TRIGGER 2
CREATE OR REPLACE TRIGGER EJ2
BEFORE INSERT ON LINEA
FOR EACH ROW
BEGIN
    :new.nombre := upper(:new.nombre);
    :new.cobertura := upper(:new.cobertura);
END;
/

--TRIGGER 3
CREATE TABLE USUARIOS (
usuario VARCHAR2(20),
fecha DATE
);

CREATE OR REPLACE TRIGGER EJ3
BEFORE INSERT OR UPDATE OR DELETE ON TREN
FOR EACH ROW
BEGIN
    INSERT INTO CONTROL (usuario, fecha)
    VALUES(USER,SYSDATE);
END;
/