/**
 * 
 */
package Alumnos;

import java.util.ArrayList;

/**
 * @author Jose
 *
 */
public class Alumno {

	private String nombre;
	private String apellido;
	private String dni;
	private int edad;
	private ArrayList <String> modulos = new ArrayList<>();
	private String empresa;
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param empresa
	 */
	public Alumno(String nombre, String apellido, String dni, String empresa) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.empresa = empresa;
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param edad
	 * @param modulos
	 * @param empresa
	 */
	
	public Alumno(String nombre, String apellido, String dni, int edad, ArrayList<String> modulos,String empresa) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.empresa = empresa;
		this.modulos = modulos;
		
	}

	public void setModulos(ArrayList<String> modulos) {
		this.modulos = modulos;
	}

	public ArrayList<String> getModulos() {
		return modulos;
	}
	

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " -Apellido: " + apellido + " -DNI: " + dni + " -Edad: " + edad + " -Modulos: " + modulos.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
