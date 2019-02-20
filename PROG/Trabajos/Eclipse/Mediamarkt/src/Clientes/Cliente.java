package Clientes;

/**
 * @author Jose
 *
 */
public class Cliente {
	
	private String nombre;
	private String apellido;
	private String dni;
	
	public Cliente() {
		
	}
	
	/**
	 * @param nombre
	 * @param apellido
	 * @param dni
	 */
	
	public Cliente(String nombre, String apellido, String dni) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public String toString() {
		
		return "\nNombre: " + nombre + " - Apellido: " + apellido + " - DNI: " + dni;
	}

}
