/**
 * 
 */
package Colas;

import java.util.ArrayList;
import java.util.Collections;

import Interfaces.ICola;

/**
 * @author Jose
 *
 */
public class ColaLista implements ICola{

	public ColaLista() {
		
	}

	ArrayList<Integer> colaLista = new ArrayList<Integer>();
	
	@Override
	public void apilar(int numero){
		
		colaLista.add(numero);
	}
	@Override
	public void desapilar() {
		
		colaLista.remove(colaLista.size()-1);
	}
	
	public void voltear() {
		Collections.reverse(colaLista);
	}
	
	public ArrayList<Integer> getColaLista(){

		return colaLista;
	}
}
