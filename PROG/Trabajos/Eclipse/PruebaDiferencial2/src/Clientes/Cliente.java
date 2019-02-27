/**
 * 
 */
package Clientes;

/**
 * @author Jose Antonio
 */
public class Cliente {

	private String nombre;
	private String apellido;
	private String telefono;
	private int id;
	private static int idStatic;
	
	/**
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 */
	public Cliente(String nombre, String apellido, String telefono) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.id = idStatic + 1;
		idStatic = this.id;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		
		return "\nID Cliente: " + id + "\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nTelefono: " + this.telefono;
	}

	public int getId() {
		return id;
	}

}