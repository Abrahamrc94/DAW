/**
 * 
 */
package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Alumnos.Alumno;

/**
 * @author Jose
 *
 */
public class Main {

	public static void main(String[] args) throws Exception{
		
		Scanner x = new Scanner(System.in);
		Scanner y = new Scanner(System.in);
		
		String opcion;
		String nombre;
		String apellido;
		String dni;
		int edad;
		String empresa;
		String subopcion;
		int pos;
		String elegir;
		String modulo;
		int numeroModulos;
		
		ArrayList<Object> ListaAlumnos = new ArrayList<>();
		ArrayList<String> ListaModulos = new ArrayList<>();
		Alumno alumno;
		
		try {
			do {
				System.out.println("Elija la opcion adecuada\nOpcion 1 - anyadir alumnos\nOpcion 2 - mostrar alumnos\nOpcion 3 - eliminar alumnos\nOpcion 4 - mostrar todos los alumnos del ciclo\nOpcion 5 - escribir en fichero\nOpcion 6 - salir");
				opcion = x.nextLine();
				
				if(opcion.equals("1")) {
					System.out.println("Has elegido la opcion 1");
					do {
						System.out.println("Elija la opcion adecuada\nOpcion 1 - Dar de alta COMPLETO\nOpcion 2 - Dar de alta SIMPLE\nOpcion 3 - MODIFICAR\nOpcion 4 - SALIR");
						subopcion = x.nextLine();
						
						if(subopcion.equals("1")) {
							System.out.println("Has elegido la subopcion 1");
							System.out.print("Escriba el nombre del alumno: ");
							nombre = x.nextLine();
							System.out.print("Escriba el apellido del alumno: ");
							apellido = x.nextLine();
							System.out.print("Escriba el dni del alumno: ");
							dni = x.nextLine();
							System.out.print("Escriba la edad del alumno: ");
							edad = y.nextInt();
							System.out.print("Escriba su empresa: ");
							empresa = x.nextLine();
							System.out.print("Cuentas asignaturas tiene su alumno: ");
							numeroModulos = y.nextInt();
							for(int i = 0; i<numeroModulos; i++) {
								System.out.println("Que modulo añades.");
								modulo = x.nextLine();
								ListaModulos.add(modulo);
							}
							alumno = new Alumno(nombre, apellido, dni, edad, ListaModulos,empresa);
							ListaAlumnos.add(alumno);
							ListaModulos.clear();
							
						}else if(subopcion.equals("2")) {
							System.out.println("Has elegido la subopcion 2");
							System.out.print("Escriba el nombre del alumno: ");
							nombre = x.nextLine();
							System.out.print("Escriba el apellido del alumno: ");
							apellido = x.nextLine();
							System.out.print("Escriba el dni del alumno: ");
							dni = x.nextLine();
							System.out.println("Escriba la empresa del alumno");
							empresa = x.nextLine();
							
							ListaAlumnos.add(alumno = new Alumno(nombre, apellido, dni, empresa));
						}else if(subopcion.equals("3")) {
							System.out.println("Has elegido la subopcion 3");
							
							for(int i = 0; i < ListaAlumnos.size(); i++) {
								System.out.println( i + " - " + ListaAlumnos.get(i).toString());
							}
							
							System.out.print("Elija el alumno a modificar: ");
							pos = y.nextInt();
							do {
								System.out.println("Elija que quiere cambiar:\nnombre\napellido\ndni\nedad\nmodulos\nempresa\nsalir");
								elegir = x.nextLine();
								if(elegir.equals("nombre")){
									nombre = x.nextLine();
									((Alumno) ListaAlumnos.get(pos)).setNombre(nombre);
								}else if(elegir.equals("apellido")) {
									apellido = x.nextLine();
									((Alumno) ListaAlumnos.get(pos)).setApellido(apellido);
								}else if(elegir.equals("dni")) {
									dni = x.nextLine();
									((Alumno) ListaAlumnos.get(pos)).setDni(dni);
								}else if(elegir.equals("edad")) {
									edad = y.nextInt();
									((Alumno) ListaAlumnos.get(pos)).setEdad(edad);
								}else if(elegir.equals("modulos")) {
									System.out.print("Cuentas asignaturas tiene su alumno: ");
									numeroModulos = y.nextInt();
									for(int i = 0; i<numeroModulos; i++) {
										System.out.println("Que modulo añades.");
										modulo = x.nextLine();
										ListaModulos.add(modulo);
									}
									((Alumno) ListaAlumnos.get(pos)).setModulos(ListaModulos);
									ListaModulos.clear();
								}else if(elegir.equals("empresa")) {
									empresa = x.nextLine();
									((Alumno) ListaAlumnos.get(pos)).setEmpresa(empresa);
								}
							}while(!elegir.equals("salir"));
						}
					}while(!subopcion.equals("4"));
				}else if(opcion.equals("2")) {
					System.out.println("Has elegido la opcion 2");
					
					do {
						System.out.println("Elija la opcion adecuada\nOpcion 1 - Mostrar datos personales\nOpcion 2 - Mostrar nombre y modulos\nOpcion 3 - Alumnos de un modulo\nOpcion 4 - Salir");
						subopcion = x.nextLine();
						
						if(subopcion.equals("1")) {
							System.out.println("Has elegido la subopcion 1");
							for(int i = 0; i < ListaAlumnos.size(); i++) {
								System.out.println( i + " - " + ListaAlumnos.get(i).toString());
							}
							System.out.println("Elija la posicion del alumno a buscar");
							pos = y.nextInt();
							System.out.println(ListaAlumnos.get(pos).toString());
						}else if(subopcion.equals("2")) {
							System.out.println("Has elegido la subopcion 2");
							for(int i = 0; i < ListaAlumnos.size(); i++) {
								System.out.println( i + " - " + ListaAlumnos.get(i).toString());
							}
							System.out.println("Elija la posicion del alumno a buscar");
							pos = y.nextInt();
							System.out.println(((Alumno) ListaAlumnos.get(pos)).getNombre() + ((Alumno) ListaAlumnos.get(pos)).getModulos());
						}else if(subopcion.equals("3")) {
							System.out.println("Has elegido la subopcion 3");
							
						}
					}while(!subopcion.equals("4"));
				}else if(opcion.equals("3")) {
					System.out.println("Has elegido la opcion 3");
					System.out.println("Elija que alumno quiere eliminar: ");
					pos = x.nextInt();
					
					ListaAlumnos.remove(pos);
					do {
						System.out.println("Elija la opcion adecuada\nOpcion 1 - Elimina alumno por DNI\nOpcion 2 - Eliminar alumno por nombre\nOpcion 3 - Eliminar por modulos\nOpcion 4 - Salir");
						subopcion = x.nextLine();
						
						if(subopcion.equals("1")) {
							System.out.println("Has elegido la subopcion 1");
							System.out.println("Escriba el DNI del alumno a borrar: ");
							dni = x.nextLine();
							for(int i = 0; i<ListaAlumnos.size(); i++) {
								if(((Alumno) ListaAlumnos.get(i)).getDni().equals(dni)){
									ListaAlumnos.remove(i);
								}
							}
						}else if(subopcion.equals("2")) {
							System.out.println("Has elegido la subopcion 2");
							System.out.println("Escriba el nombre del alumno a eliminar: ");
							nombre = x.nextLine();
							for(int i = 0; i<ListaAlumnos.size(); i++) {
								if(((Alumno) ListaAlumnos.get(i)).getNombre().equals(nombre)){
									System.out.println( i + " - " + ListaAlumnos.get(i).toString());
								}
								
							}
							System.out.println("Que alumno queire eliminar");
							pos = x.nextInt();
							ListaAlumnos.remove(pos);
							
						}else if(subopcion.equals("3")) {
							System.out.println("Has elegido la subopcion 3");
						}
					}while(!subopcion.equals("fin"));
				}else if(opcion.equals("4")) {
					System.out.println("Has elegido la opcion 4");
					for(int i = 0; i < ListaAlumnos.size(); i++) {
						System.out.println( i + " - " + ListaAlumnos.get(i).toString());
					}
					
					do {
						System.out.println("Elija la opcion adecuada\nOpcion 1 - Mostrar todos\nOpcion 2 - Mostrar por modulos\nOpcion 3 - Mostrar por edad\nOpcion 4 - Salir");
						subopcion = x.nextLine();
						
						if(subopcion.equals("1")) {
							System.out.println("Has elegido la subopcion 1");
							for(int i = 0; i < ListaAlumnos.size(); i++) {
								System.out.println( i + " - " + ListaAlumnos.get(i).toString());
							}
						}else if(subopcion.equals("2")) {
							System.out.println("Has elegido la subopcion 2");
						}else if(subopcion.equals("3")) {
							System.out.println("Has elegido la subopcion 3");
							System.out.println("Elija la edad: ");
							edad = y.nextInt();
							for(int i = 0; i<ListaAlumnos.size(); i++) {
								if(((Alumno) ListaAlumnos.get(i)).getEdad() == edad){
									System.out.println( i + " - " + ListaAlumnos.get(i).toString());
								}
								
							}
						}
					}while(!subopcion.equals("fin"));
					
				}else if(opcion.equals("5")) {
					for(int i = 0; i < ListaAlumnos.size(); i++) {
						
						try {
							
							BufferedWriter bw = new BufferedWriter(new FileWriter("Alumnos.txt", true));
							bw.newLine();
							bw.write(ListaAlumnos.get(i).toString());
							bw.newLine();
							bw.close();
							
						}catch(Exception e2) {
							System.out.println("ERROR");
						}
						
					}
				}else if(opcion.equals("6")) {
					System.out.println("Saliendo...");
				}
			}while(!opcion.equals("6"));
			
			x.close();
		}catch(Exception e) {
			System.out.println("ERROR. ENTRADA DE DATOS ERRONEA");
		}
		
	}
	

}
