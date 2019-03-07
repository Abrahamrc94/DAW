ALTER TABLE ESTACION
ADD num_accesos NUMBER(3,0);

--EJ1

CREATE OR REPLACE PROCEDURE EJ1
IS

CURSOR c1 IS SELECT CODIGO FROM ESTACION;
aux NUMBER;

BEGIN

FOR v_c1 IN c1 LOOP
    SELECT COUNT(*) INTO aux FROM ACCESO WHERE ESTACION = v_c1.CODIGO;
    UPDATE ESTACION SET NUM_ACCESOS = aux WHERE CODIGO = v_c1.CODIGO;
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

aux TREN.CODIGO%TYPE;
fech TREN.FECHA_ENTRADA%TYPE;
BEGIN


SELECT max(codigo)+1 INTO aux FROM TREN;
SELECT SYSDATE INTO fech FROM DUAL;
IF coch <= 15 THEN
    INSERT INTO TREN(codigo, modelo, velocidad_maxima, fecha_entrada, cochera)
    VALUES(aux, modeloT, vel, fech, coch);
    DBMS_OUTPUT.PUT_LINE(aux);
    RETURN 1;
ELSE
    RETURN 0;
END IF;


END;
/

SET SERVEROUTPUT ON
DECLARE
aux TREN.CODIGO%TYPE;
BEGIN
DBMS_OUTPUT.PUT_LINE(EJ2('MODELO 888', 999, 16, aux));
END;
/

--EJ3

    
    DECLARE
    aux TREN.CODIGO%TYPE;
    BEGIN
    DBMS_OUTPUT.PUT_LINE(EJ2('MODELO 888', 999, 14, aux));
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

CURSOR linOrden IS SELECT NUMERO_ORDEN FROM LINEA_ESTACION;

BEGIN

IF ((codL < 1) OR (codL > 5)) THEN
    RETURN -10;
ELSIF((codE < 1) OR (codE > 16)) THEN
    RETURN -20;
ELSIF(((codL < 1) OR (codL > 5))AND((codE < 1) OR (codE > 16))) THEN
    RETURN -40;
ELSIF((codE > 0 AND codE < 17) AND linOrden) THEN
    RETURN -50;
ELSE
    INSERT INTO LINEA_ESTACION(LINEA, ESTACION, NUMERO_ORDEN)
    VALUES(codL, codE, numOrd);
    RETURN 1;
END IF;
END;
/

SET SERVEROUTPUT ON
BEGIN
DBMS_OUTPUT.PUT_LINE(EJ5(1, 5, 11));
END;
/

