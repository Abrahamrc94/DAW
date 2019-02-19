/**
 * 
 */
package Intrumento;

/**
 * @author Jose
 *
 */
abstract public class Instrumento {

	int[] notas = new int[100];
	
	public Instrumento() {
		
	}

	abstract void add(int numero);
	
	abstract int interpretar(int notaMusical);
	
}
