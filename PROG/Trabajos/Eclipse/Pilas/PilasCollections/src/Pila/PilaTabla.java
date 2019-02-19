/**
 * 
 */
package Pila;

import Interfaces.IPilaTabla;

/**
 * @author Jose
 *
 */
public class PilaTabla implements IPilaTabla{

	private int nElementos;
	private int pilaTabla[] = new int[nElementos];
	int aux = pilaTabla.length;
	
	
	public PilaTabla() {
	
		nElementos = 0;
		pilaTabla = new int[nElementos];
	}
	
	@Override
	public void apilar(int numero) {
		
		nElementos = nElementos + 1;
		
		int[] pilaAux = new int[nElementos];
		
		for(int i = 0; i < pilaTabla.length; i++) {
			
			pilaAux[i] = pilaTabla[i];
		}
		
		pilaAux[nElementos - 1] = numero;
		pilaTabla = pilaAux;
	}
	
	
	public  int[] invertir() {
		for(int i = 0; i<pilaTabla.length/2; i++) {
			aux = pilaTabla[i];
			pilaTabla[i] = pilaTabla[pilaTabla.length-1-i];
			pilaTabla[pilaTabla.length-1-i] = aux;
			
		}
		return pilaTabla;
		
	}
	
	@Override
	public void desapilar() {
		
		int[] pilaAux = new int[pilaTabla.length-1];
		
		for(int i = 1; i<pilaTabla.length; i++) {
			pilaAux[i-1] = pilaTabla[i];
		}
		pilaTabla = pilaAux;
	}
	
	
	public int[] getPilaTabla() {
		return pilaTabla;
	}

}
