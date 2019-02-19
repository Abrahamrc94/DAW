/**
 * 
 */
package Pila;

import java.util.ArrayList;
import java.util.Collections;

import Interfaces.IPilaTabla;

/**
 * @author Jose
 *
 */
public class PilaLista implements IPilaTabla{

	/**
	 * 
	 */
	public PilaLista() {
		
	}
	
	ArrayList<Integer> pilaLista = new ArrayList<Integer>();
	
	@Override
	public void apilar(int numero){
		
		pilaLista.add(numero);
	}
	@Override
	public void desapilar() {
		
		pilaLista.remove(0);
	}
	
	public void voltear() {
		Collections.reverse(pilaLista);
	}
	
	public ArrayList<Integer> getPilaLista(){

		return pilaLista;
	}
	
	

}
