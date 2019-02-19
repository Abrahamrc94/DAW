# Ejercicios Checkout y Reset

Los siguientes ejercicios los debes realizar en tu máquina real, no es necesario que los subas a un repositorio en github. Indica los pasos seguidos para realizar cada ejercicio en este mismo fichero.

1. Crea un directorio llamado _**destruction**_

mkdir destruction

2. Cámbiate a dicho directorio

cd destruction

3. Inicializa un repositorio git vacío.

git init

4. Crea un fichero llamado **stage_me.txt**

touch stage_me.txt

5. Añade el fichero stage_me.txt al área de preparación (staging area).

git add stage_me.txt 

6. Mueve el fichero stage.txt del área de preparación al directorio de trabajo.

git rm --cached stage_me.txt 

7. Añade el fichero stage_me.txt al área de preparación.

git add stage_me.txt

8. Elimina el fichero stage_me.txt del área de preparación y del directorio de trabajo.

git rm -f stage_me.txt 

9. Crea un fichero nuevo llamado commit_me.txt.

touch commit_me.txt

10. Añade el fichero commit_me.txt al área de preparación.

git add commit_me.txt

11. Haz un commit con el mensaje "adding commit_me.txt"

git commit -m "adding commit_me.txt"

12. Crea otro fichero llamado second.txt.

touch second.txt

13. Añade el fichero second.txt al área de preparación.

git add second.txt

14. Haz commit con el mensaje "adding second.txt".

git commit -m "adding second.txt"

15. Muestra los commits previos uno por línea mostrando el identificador únicao (SHA) y el comentario asociado.

git log --oneline
6ce6f34 (HEAD -> master) adding second.txt
bbe7a31 adding commit_me.txt


Para realizar los siguientes ejercicios debes investigar sobre los parámetros --soft --mixed y --hard del comando git reset.

16. Utilizando git reset, deshaz el commit previo y devuelve los cambios al directorio de trabajo.

git reset --mixed 6ce6f34

17. Añade el fichero second.txt otra vez al área de preparación.

git add second.txt

18. Haz un commit con el mensaje "Trying to commit again".

git commit -m "Trying to commit again"

19. Utilizando git reset deshaz el commit previo y devuelve los cambios al área de preparación.

git reset --soft 6ce6f34

20. Haz commit con el mensaje "Trying to commit again and again".

git commit -m "Trying to commit again and again"

21. Utilizando git reset deshaz el commit previo para que ningún cambio aparezca en el directorio de trabajo.

git reset --hard 6ce6f34

22. ¡Date una palmadita en la espalda! ¡Acabas de realizar un flujo de trabajo bastante complejo de git!
    
