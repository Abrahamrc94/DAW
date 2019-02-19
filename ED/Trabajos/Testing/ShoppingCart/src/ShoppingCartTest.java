import static org.junit.Assert.*;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void testGetItemCount() {
		ShoppingCart sc = new ShoppingCart();
		assertEquals(0, sc.getItemCount());
	}
	@Test
	public void testGetItemCount2() {
		Product p = new Product("hola", 2.2);
		ShoppingCart sc = new ShoppingCart();
		sc.addItem(p);
		sc.empty();
		assertEquals(0, sc.getItemCount());
	}
	@Test
	public void testGetItemCount3() {
		Product p = new Product("hola", 2.2);
		ShoppingCart sc = new ShoppingCart();
		sc.addItem(p);
		assertEquals(1, sc.getItemCount());
	}
	
	@Test
	public void testGetBalance() {
		ShoppingCart sc = new ShoppingCart();
		Product p = new Product("hola", 2.2);
		sc.addItem(p);
		assertEquals(2.2, sc.getBalance(), 0);
	}
	
	@Test
	public void testGetItemCount4() throws ProductNotFoundException {
		Product p = new Product("hola", 2.2);
		Product c = new Product("hol", 2.0);
		ShoppingCart sc = new ShoppingCart();
		sc.addItem(p);
		assertEquals(1, sc.getItemCount());
		sc.addItem(c);
		assertEquals(2, sc.getItemCount());
		sc.removeItem(p);
		assertEquals(1, sc.getItemCount());
	}
	
	@Test(expected=ProductNotFoundException.class)
	public void testException () throws ProductNotFoundException {
		ShoppingCart sc = new ShoppingCart();
		Product p = new Product("hola", 2.2);
		sc.removeItem(p);
	}
	
}
