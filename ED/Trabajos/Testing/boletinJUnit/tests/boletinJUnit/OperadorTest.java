package boletinJUnit;

import static org.junit.Assert.*;
import org.junit.Test;

public class OperadorTest {

	OperadorAritmetico op = new OperadorAritmetico();
	
	@Test
	public void sumaTest() {
		
		assertEquals(2, OperadorAritmetico.suma(1, 1));
	}
	
	@Test
	public void divisionTest() throws Exception {
		
		assertEquals(2, OperadorAritmetico.division(4, 2));
	}
	
	@Test(expected=Exception.class)
	public void divisionFail() throws Exception{
		
		OperadorAritmetico.division(4, 0);
	}

}
