/**
 * 
 */
package Colas;

import Interfaces.ICola;

/**
 * @author Jose
 *
 */
public class ColaTabla implements ICola{

	/**
	 * 
	 */
	private int nElementos;
	private int colaTabla[] = new int[nElementos];
	int aux = colaTabla.length;
	
	
	public ColaTabla() {
	
		nElementos = 0;
		colaTabla = new int[nElementos];
	}
	
	@Override
	public void apilar(int numero) {
		
		nElementos = nElementos + 1;
		
		int[] colaAux = new int[nElementos];
		
		for(int i = 0; i < colaTabla.length; i++) {
			
			colaAux[i] = colaTabla[i];
		}
		
		colaAux[nElementos - 1] = numero;
		colaTabla = colaAux;
	}
	
	
	public  int[] invertir() {
		for(int i = 0; i<colaTabla.length/2; i++) {
			aux = colaTabla[i];
			colaTabla[i] = colaTabla[colaTabla.length-1-i];
			colaTabla[colaTabla.length-1-i] = aux;
			
		}
		return colaTabla;
		
	}
	
	@Override
	public void desapilar() {
		
		int[] pilaAux = new int[colaTabla.length-1];
		
		for(int i = 0; i<colaTabla.length-1; i++) {
			pilaAux[i] = colaTabla[i];
		}
		colaTabla = pilaAux;
	}
	
	
	public int[] getColaTabla() {
		return colaTabla;
	}

}
