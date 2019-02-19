package boletinJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilaTest {

	
	
	@Test
	public void pushTest() {
		
		Pila p = new Pila();
		p.push(3);
		assertEquals(1, p.longitud());
		p.push(1);
		assertEquals(1, p.longitud());
	}
	
	@Test
	public void popTest() {
		
		Pila p = new Pila();
		assertEquals(null, p.pop());
		p.push(3);
		assertEquals(p.pop(), p.pop());
	}

}
