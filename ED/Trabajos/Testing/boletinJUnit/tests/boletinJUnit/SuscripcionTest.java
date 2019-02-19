package boletinJUnit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SuscripcionTest {
	
	private static Subscripcion subs;
	private int periodo;
	private int precio;
	private double precioMes;
	
	
	public SuscripcionTest(int precio, int periodo, double precioMes) {
		this.periodo = precio;
		this.precio = periodo;
		this.precioMes = precioMes;
	}
	
	@Parameters
	public static Collection<Object[]> parametros(){
		return Arrays.asList(new Object[][]{
			{100,10,10},{101,10,11},{151,10,16}
		});
	}
	
	
	@Test
	public void testPrecioPorMes() {
		subs = new Subscripcion(precio, periodo);
		assertEquals("Pasado Test" + precio, precioMes, subs.precioPorMes(),0);
		System.out.println("Precio: " + precio);
	}
	
	@Test
	public void testCancel() {
		Subscripcion s1 = new Subscripcion(100, 10);
		Subscripcion s2 = new Subscripcion(100, 0);
		s1.cancel();
		assertEquals(0,s1.precioPorMes(),0);
		System.out.println("Hola");
	}
	
//
//	@Test
//	public void precioMesTest() {
//		Subscripcion sp = new Subscripcion(0, 0);
//		Subscripcion sp1 = new Subscripcion(0, 1);
//		Subscripcion sp2 = new Subscripcion(1, 1);
//		Subscripcion sp3 = new Subscripcion(1, 2);
//		
//		assertEquals(0, sp.precioPorMes(),0);
//		assertEquals(0, sp1.precioPorMes(),0);
//		assertEquals(1, sp2.precioPorMes(),0);
//		assertEquals(1.5, sp3.precioPorMes(),0);
//		
//	}
//	
//	@Test 
//	public void cancelTest() {
//		Subscripcion sp = new Subscripcion(0,1);
//		sp.cancel();
//		assertEquals(0,sp.getPeriodo());
//	}
	
	
	

}
