/**
 * 
 */
package Main;
import java.util.Arrays;

import Pila.PilaLista;
import Pila.PilaTabla;

/**
 * @author estudiante
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		PilaTabla pila = new PilaTabla();
		pila.apilar(1);
		pila.apilar(2);
		pila.apilar(3);
		pila.apilar(4);
		pila.apilar(5);
		System.out.println(Arrays.toString(pila.invertir()));
		pila.desapilar();
		System.out.println(Arrays.toString(pila.getPilaTabla()));
		
		
		PilaLista pila2 = new PilaLista();
		pila2.apilar(2);
		pila2.apilar(3);
		pila2.apilar(4);
		pila2.apilar(5);
		pila2.apilar(6);
		pila2.voltear();
		System.out.println(pila2.getPilaLista());
		pila2.desapilar();
		System.out.println(pila2.getPilaLista());
		
		
		
	}

}
