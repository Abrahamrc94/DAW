**ENLACE**

[Enlace a repositorio](https://svn.riouxsvn.com/ejex)

**1**.
- mkdir SVN
- cd SVN/
- svn co https://svn.riouxsvn.com/ejex
- cd ejex/trunk/
- svn add *
- svn commit -m "Añadiendo todos los ficheros"
- nano scene-5.txt (Modifico el archivo)

**2**
- svn add scene-5.txt

**3**
- svn commit -m "Subiendo escena 5 modificada"

**4**
- nano scene-5.txt (Añado la sugerencia al final)

**5**
- svn log https://svn.riouxsvn.com/ejex
- svn revert scene-5.txt

**6**
- nano scene-3.txt
- CONTROL+W
- CONTROL+R (Introduzco el nombre a reemplazar y el nuevo nombre)
- A (Cambiar todos)
- nano scene-7.txt
- CONTROL+W
- CONTROL+R (Introduzco el nombre a reemplazar y el nuevo nombre)
- A (Cambiar todos)

**7**
- svn add scene-3.txt scene-7.txt

**8**
- nano scene-2.txt (borro la primera linea)

**9**
- svn add scene-2.txt

**10**
- svn status

**11**
- svn delete --keep-local scene-2.txt

**12**
- svn commit -m "Añadiendo los cambios del nombre" scene-3.txt scene-7.txt 

**13**
- No se puede, los commit suben los cambios y no se puede volver a dicho commit a diferencia de Git

**14**
- mkdir reinventando_hamlet/
- svn cp https://svn.riouxsvn.com/ejex/trunk/ https://svn.riouxsvn.com/ejex/branches/reinventando_hamlet
-svn co https://svn.riouxsvn.com/ejex/trunk/ https://svn.riouxsvn.com/ejex/branches/reinventando_hamlet

**15**
- cd ..
- cd branches/reinventando_hamlet

**16**
- nano scene-2.txt (Elimino una linea)

**17**
- svn commit -m "Subiendo escena 2 modificada" scene-2.txt 

**18**
- cd ../../trunk/

**19**