
package Main;

import Intrumento.Campana;
import Intrumento.Piano;

/**
 * @author Jose
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Piano piano = new Piano();
		piano.add(5);
		System.out.println(piano.interpretar(0));
		
		Campana campana = new Campana();
		campana.add(5);
		System.out.println(campana.interpretar(0));
	}

}
