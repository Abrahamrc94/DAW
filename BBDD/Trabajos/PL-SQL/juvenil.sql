CREATE OR REPLACE PROCEDURE listadocuatromasprestados
IS

v_ref VARCHAR2(10);

CURSOR v1 IS select * from (select prestamos.reflibro as ref, nombre, genero, count(*) as numprestamos from prestamos, libros
where prestamos.reflibro=libros.reflibro
group by prestamos.reflibro, nombre, genero
order by numprestamos desc) where rownum <= 4;

CURSOR v2 IS SELECT DNI, FECHAPRESTAMO FROM PRESTAMOS WHERE reflibro = v_ref;

BEGIN

FOR v_v1 IN v1 LOOP
    DBMS_OUTPUT.PUT_LINE(v_v1.ref || ' ' || v_v1.nombre || ' ' || v_v1.genero || ' ' || v_v1.numprestamos);
    v_ref := v_v1.ref;
    FOR v_v2 IN v2 LOOP
        DBMS_OUTPUT.PUT_LINE(v_v2.dni || ' ' || v_v2.fechaprestamo);
    end loop;
end loop;

EXCEPTION 
WHEN no_data_found THEN
DBMS_OUTPUT.PUT_LINE('ERROR');

END;
/

SET SERVEROUTPUT ON
BEGIN
listadocuatromasprestados();
END;
/

CREATE OR REPLACE TRIGGER EJ1
    AFTER INSERT ON PRESTAMOS
    FOR EACH ROW
    BEGIN
        IF(:new.fechaprestamo > SYSDATE) THEN
            DBMS_OUTPUT.PUT_LINE('LA FECHA ES SUPERIOR AL DIA ACTUAL');
        END IF;
    END;
/