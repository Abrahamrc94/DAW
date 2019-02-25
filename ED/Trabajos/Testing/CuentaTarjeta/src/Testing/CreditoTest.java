package Testing;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import Clases.Credito;

class CreditoTest {

	@SuppressWarnings("deprecation")
	Date d = new Date(2010,5,6);

	Credito c = new Credito("5","Jose", d, 20.00);
	
	@Test
	void testRetirar() {
		
		try {
			c.retirar(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(14.25, c.getCreditoDisponible(),0);
	}

}
