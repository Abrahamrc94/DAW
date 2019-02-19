import static org.junit.Assert.*;
import org.junit.Test;

public class PersonaTest {
	
	@Test
	public void testPersona() {
		Persona persona = new Persona();
		
	}

	@Test
	public void testPersonaStringIntChar() {
		Persona personaParam = new Persona("Jose", 15, 'H');
		
	}

	@Test
	public void testPersonaStringIntCharDoubleDouble() {
		Persona personaParam2 = new Persona("Jose", 15, 'H', 58.8, 1.8);
		
	}
//2.56
	@Test
	public void testCalcularIMC() {
		//Persona personaParam2 = new Persona("Jose", 15, 'H', 40, 1.60);
		//personaParam2.calcularIMC();
		//assertEquals(-1, personaParam2.calcularIMC());
		
		Persona personaParam2 = new Persona("Jose", 15, 'H',20 , 1);
		
		assertEquals(0, personaParam2.calcularIMC());
		
		//Persona personaParam2 = new Persona("Jose", 15, 'H', 60, 1.60);
		//personaParam2.calcularIMC();
		//assertEquals(0, personaParam2.calcularIMC());
		//Persona personaParam2 = new Persona("Jose", 15, 'H', 64, 1.60);
		//personaParam2.calcularIMC();
		//assertEquals(0, personaParam2.calcularIMC());
		//Persona personaParam2 = new Persona("Jose", 15, 'H', 80, 1.60);
		//personaParam2.calcularIMC();
		//assertEquals(1, personaParam2.calcularIMC());
	}

	@Test
	public void testEsMayorDeEdad() {
		//Persona personaParam = new Persona("Jose", 15, 'H');
		//assertFalse(false);
		//Persona personaParam2 = new Persona("Jose", 18, 'H', 58.8, 1.8);
		//assertTrue(true);
		//Persona personaParam = new Persona("Jose", 19, 'H');
		//assertTrue(true);
		
	}

	@Test
	public void testToString() {

		Persona personaParam2 = new Persona("Jose", 15, 'H', 58.8, 1.8);
		String esperado = "Informacion de la persona:\n"
		        + "Nombre: " + "Jose" + "\n"
		        + "Sexo: " + "hombre" + "\n"
		        + "Edad: " + "15" + " años\n"
		        + "DNI: " + "[0-9]{8}[A-Z]" + "\n"
		        + "Peso: " + "58.8" + " kg\n"
		        + "Altura: " + "1.8" + " metros\n";
		assertTrue(personaParam2.toString().matches(esperado));
	}

}
