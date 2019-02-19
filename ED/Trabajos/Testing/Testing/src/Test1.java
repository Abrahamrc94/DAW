import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class Test1 {

	@Test
	public void testSuma() {
		Aritmetica aritmetica = new Aritmetica();
	    assertEquals(1.2, aritmetica.suma(1, 1), 0.5);
	}

	@Test
	public void testResta() {
	    Aritmetica aritmetica = new Aritmetica();
	    assertEquals(3, aritmetica.resta(4, 1), 0);
	}
	
	@Test
	public void testMultiplicacion() {
	    Aritmetica aritmetica = new Aritmetica();
	    assertEquals(6, aritmetica.multiplicacion(2, 3), 0);
	}
	
	@Test
	public void testDivision() {
	    Aritmetica aritmetica = new Aritmetica();
	    assertEquals(5, aritmetica.division(10, 2), 0);
	}


}
