/*
Modificar la tabla de alumnos añadiendo un campo en el que se almacenará el número de asignaturas que tiene.
Crear un procedimiento que actualice este campo de forma adecuada.
Crear el trigger o trigger necesarios para mantener todo el tiempo este campo almacenado de forma correcta
*/

ALTER TABLE ALUMNO
ADD numAsignaturas NUMBER(2);

SELECT COUNT(ALUMNO_ASIGNATURA.IDASIGNATURA) AS NUMEROASIG
FROM ALUMNO_ASIGNATURA
WHERE IDALUMNO = AUX
GROUP BY IDALUMNO;

CREATE OR REPLACE PROCEDURE añadirNumAsig
IS

SELECT COUNT(IDASIGNATURA) INTO numA FROM ALUMNO_ASIGNATURA WHERE IDALUMNO = aux;

numA NUMBER(2);
aux ALUMNO_ASIGNATURA.IDALUMNO%TYPE;
CURSOR añadirAsig IS 

BEGIN

FOR vAux IN añadirAsig LOOP
    UPDATE ALUMNO
    SET numAsignaturas = numA
    WHERE IDALUMNO = aux;
END LOOP;
END;
/

BEGIN
añadirNumAsig();
END;
/