import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class VideojuegoTest {
	
     Videojuego juego;
     String titulo;
     int horasEstimadas;
     String genero;
     String compañia;
	
    public void VideojuegoParametrizadaTest(String titulo, int horasEstimadas, String genero, String compañia) {
        this.titulo=titulo;
        this.horasEstimadas=horasEstimadas;
        this.genero=genero;
        this.compañia=compañia;
    }
    
	@Parameters
	public static Collection<Object[]> parametros() {
	    return Arrays.asList(new Object[][]{
	            {"Pimpampum, placa placa", "85", "MOBA", "JOSE LA MEJOR EMPRESA DE JUEGOS SI O SI SIEMPRE.SL"},
	            {"Pimpampum, placa placa", 85, "MOBA", "JOSE LA MEJOR EMPRESA DE JUEGOS SI O SI SIEMPRE.SL"},
	    });
	
	}
    
	/*
	@BeforeClass
	public void constructor() {

		juego = new Videojuego ("Pimpampum, placa placa", 83, "MOBA", "JOSE LA MEJOR EMPRESA DE JUEGOS SI O SI.SL");
	}
	*/
	@Test
	public void testIsEntregado() {
		assertFalse(false);
	}
/*
	@Test
	public void testCompareTo() {
		
		//Videojuego a = new Videojuego("Pimpampum, placa placa, segundas partes", 84, "MOBA", "JOSE LA MEJOR EMPRESA DE JUEGOS SI O SI.SL"); 
		//assertEquals(1, a.compareTo(juego));
	
	}
*/
	@Test
	public void testToString() {
		
		String Ok = "Informacion del videojuego: \n" +
	               "\tTitulo: " + "Pimpampum, placa placa" + "\n" +
	               "\tHoras estimadas: " + 85 +"\n" +
	               "\tGenero: " + "MOBA" + "\n" +
	               "\tcompañia: " + "JOSE LA MEJOR EMPRESA DE JUEGOS SI O SI SIEMPRE.SL";
		
		assertTrue(juego.toString().matches(Ok));
		assertEquals(Ok,juego.toString());
	}

}
