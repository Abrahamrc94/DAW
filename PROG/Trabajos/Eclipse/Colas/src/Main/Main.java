/**
 * 
 */
package Main;

import java.util.Arrays;

import Colas.ColaLista;
import Colas.ColaTabla;

/**
 * @author Jose
 *Implementar la clase ColaTabla en la que los elementos Integer encolados se guardan en una tabla.
  Repetir la implementación anterior usando una Lista para guardar los elementos encolados. La clase a implementar es ColaLista.
  Implementar la interfaz Cola e implementarla en las clases ColaTabla y ColaLista. 
  Utilizando una referencia del tipo Cola y una de las implementaciones, encolar 10 números entre 1 y 100, generados aleatoriamente y desencolarlos para mostrarlos por pantalla.
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ColaTabla cola = new ColaTabla();
		for(int i = 0; i < 10; i++) {
			cola.apilar((int) (Math.random()*100));
		}
		System.out.println(Arrays.toString(cola.invertir()));
		cola.desapilar();
		System.out.println(Arrays.toString(cola.getColaTabla()));
		
		
		ColaLista cola2 = new ColaLista();
		for(int i = 0; i < 10; i++) {
			cola2.apilar((int) (Math.random()*100));
		}
		cola2.voltear();
		System.out.println(cola2.getColaLista());
		cola2.desapilar();
		System.out.println(cola2.getColaLista());
		

	}

}
