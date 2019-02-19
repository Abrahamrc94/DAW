/*
2. Primos de 1-1000/por parametros.

CREATE OR REPLACE FUNCTION primo (num1 NUMBER) RETURN BOOLEAN
is
i number;
vprimo boolean := true;
begin
i := 2;
loop
exit when i > num1 - 1;
if(mod(num1,i) = 0) then
    vprimo := false;
    end if;
    i := i + 1;
    end loop;
    return vprimo;
end;
/

CREATE OR REPLACE PROCEDURE EJER2
IS
i number;
begin
    i := 1;
    loop
        if(primo(i) = TRUE) then
            DBMS_OUTPUT.PUT_LINE('El numero '||i||' es primo');
        end if;
        exit when i >= 1000;
        i := i + 1;
    end loop;
END;
/

BEGIN
    EJER2;
END;
/
*/

--Ejercicio.1 y 2
CREATE OR REPLACE PROCEDURE sueldo
IS
s_Neto NUMBER(5):= (60*38);
impuesto NUMBER(5,2) := (s_Neto * 0.155);
s_impuesto NUMBER (7,2) := (s_Neto - impuesto);
BEGIN
DBMS_OUTPUT.PUT_LINE('SUELDO NETO: ' || s_Neto || '€');
DBMS_OUTPUT.PUT_LINE('IMPUESTO: ' || impuesto || '€');
DBMS_OUTPUT.PUT_LINE('SUELDO IMPUESTO: ' || s_impuesto || '€');
END;
/

BEGIN
sueldo;
END;
/

--Ejercicio.3
CREATE OR REPLACE PROCEDURE nota(nota1,nota2,nota3)
IS
nota1 NUMBER(2);
nota2 NUMBER(2);
nota3 NUMBER(2);
BEGIN
nota1 = nota1 * 0.5;
nota2 = nota2 * 0.3;
nota3 = nota3 * 0.2;
DBMS_OUTPUT.PUT_LINE('Nota 1: ' || nota1)
DBMS_OUTPUT.PUT_LINE('Nota 2: ' || nota2)
DBMS_OUTPUT.PUT_LINE('Nota 3: ' || nota3)
END;
/

BEGIN
nota;
END;
/