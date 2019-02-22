package boletinJUnit;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FridgeTest {

	private String item1;
	private String item2;
	private Fridge frigo;
	
	public FridgeTest(String item1, String item2) {
		this.item1 = item1;
		this.item2 = item2;
		this.frigo = new Fridge();
	}
	
	@Parameters
	public static Collection<Object[]> parametros(){
		return Arrays.asList(new Object[][]{
			{"tomate","Platano"},{"Leche","Huevos"}
		});
	}
	
	@Test
	public void testPut() {
		frigo.put(item1);
		assertThat(frigo.contains(item1), is(true));
	}

	@Test
	public void testConstains() {
		frigo.put(item1);
		assertThat(frigo.contains(item1), is(true));
		assertThat(frigo.contains(item2), is(false));
	}
	
	@Test
	public void testTake() throws NoSuchItemException{
		frigo.put(item1);
		assertThat(frigo.contains(item1), is(true));
	}
	
	@Test(expected = NoSuchItemException.class)
	public void testTakeException() throws NoSuchItemException{
		frigo.take(item2);
	}
	
	@Test
	public void testTakeException2() {
		try {
			frigo.take(item2);
		}catch(NoSuchItemException e) {
			System.out.println("ERROR");
		}
	}
}
