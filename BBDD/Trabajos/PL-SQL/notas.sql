CREATE OR REPLACE PROCEDURE EJ2(vNombre ASIGNATURAS.NOMBRE%TYPE)
IS

CURSOR uno IS SELECT ALUMNOS.APENOM, NOTAS.NOTA FROM ALUMNOS, NOTAS, ASIGNATURAS WHERE ALUMNOS.DNI = NOTAS.DNI AND ASIGNATURAs.COD = NOTAS.COD AND ASIGNATURAS.NOMBRE = vNombre;

suspensos NUMBER(2) := 0;
aprobados NUMBER(2) := 0;
notables NUMBER(2) := 0;
sobresalientes NUMBER(2) := 0;
maximo NUMBER(2) := 0;
minimo NUMBER(2) := 0;

CURSOR dos IS SELECT NOTA FROM NOTAS;

CURSOR tres IS SELECT DISTINCT ALUMNOS.APENOM, NOTAS.NOTA FROM (SELECT MAX(NOTA) AS MAXIMO, MIN(NOTA) AS MINIMO FROM NOTAS),ALUMNOS, NOTAS WHERE ALUMNOS.DNI = NOTAS.DNI AND ((NOTAS.NOTA = MINIMO) OR (NOTAS.NOTA = MAXIMO));

BEGIN

FOR v_uno IN uno LOOP
    DBMS_OUTPUT.PUT_LINE(v_uno.APENOM || ' ' || v_uno.NOTA);
END LOOP;

FOR v_dos IN dos LOOP
    IF(v_dos.NOTA < 5) THEN
        suspensos := suspensos + 1;
    ELSIF (v_dos.NOTA >= 5 AND v_dos.NOTA < 7) THEN
        aprobados := aprobados + 1;
    ELSIF(v_dos.NOTA >= 7 AND v_dos.NOTA < 9) THEN
        notables := notables + 1;
    ELSE 
        sobresalientes := sobresalientes + 1;
    END IF;
END LOOP;

DBMS_OUTPUT.PUT_LINE('Suspensos: ' || suspensos);
DBMS_OUTPUT.PUT_LINE('Aprobados: ' || aprobados);
DBMS_OUTPUT.PUT_LINE('Notables: ' || notables);
DBMS_OUTPUT.PUT_LINE('Sobresalientes: ' || sobresalientes);
DBMS_OUTPUT.PUT_LINE('Maxima nota: ' || sobresalientes);
DBMS_OUTPUT.PUT_LINE('Minima nota: ' || sobresalientes);

FOR v_tres IN tres LOOP
    DBMS_OUTPUT.PUT_LINE(v_tres.APENOM || ' ' || v_tres.NOTA);
END LOOP;

EXCEPTION
WHEN no_data_found THEN
DBMS_OUTPUT.PUT_LINE('ERROR');
END;
/

SET SERVEROUTPUT ON
BEGIN EJ2('FOL');
END;
/

