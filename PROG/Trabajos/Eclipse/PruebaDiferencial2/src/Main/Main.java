package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Clientes.Cliente;

/**
 * @author Jose Antonio
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Cliente cliente;
		
		//Creamos la lista para los clientes
		ArrayList <Cliente> listaClientes = new ArrayList<>();
		
		Scanner x = new Scanner(System.in);
		Scanner y = new Scanner(System.in);
		
		String opcion;
		String nombre;
		String apellido;
		String tlfn;
		int buscar;
		try {
			//No pongo la condicion 'true' al final para que sobreescriba el fichero.
			BufferedWriter bw = new BufferedWriter(new FileWriter("Clientes.txt"));
			
			//MENU DO-WHILE
			do {
			
				System.out.println("Elija:\nOpcion 1: Añadir nuevo cliente.\nOpcion 2: Modificar datos.\nOpcion 3: Dar de baja a un cliente.\nOpcion 4: Listar los clientes.\nOpcion 5: Salir.");
			
				opcion = x.nextLine();
			//La opcion 1 nos permite añadir clientes mediante el .add()
				if(opcion.equals("1")) {
				
					System.out.print("Nombre: ");
					nombre = x.nextLine();
					System.out.print("Apellido: ");
					apellido = x.nextLine();
					System.out.print("Telefono: ");
					tlfn = x.nextLine();
				
					cliente = new Cliente(nombre, apellido, tlfn);

					listaClientes.add(cliente);
				
				//La opcion 2 nos permite modificar el cliente accediendo mediante
				//su ID y modificar sus atributos a traves de los setters.
				}else if(opcion.equals("2")) {
					System.out.print("Que cliente quiere modificar, introduza ID: ");
					buscar = y.nextInt();
					
					for(int i = 0; i < listaClientes.size(); i++) {
						if(buscar == listaClientes.get(i).getId()) {
							System.out.println("Introduzca nuevo nombre");
							nombre = x.nextLine();
							listaClientes.get(i).setNombre(nombre);
							
							System.out.println("Introduzca nuevo apellido");
							apellido = x.nextLine();
							listaClientes.get(i).setApellido(apellido);
							
							System.out.println("Introduzca nuevo telefono");
							tlfn = x.nextLine();
							listaClientes.get(i).setTelefono(tlfn);
						}
					}
				//La opcion 3 nos permite dar de baja al cliente mediante la busqueda
				//por ID y eliminandolo de la lista con .remove()
				}else if(opcion.equals("3")) {
					System.out.print("Que cliente quiere dar de baja, introduza ID: ");
					buscar = y.nextInt();
					
					for(int i = 0; i < listaClientes.size(); i++) {
						if(buscar == listaClientes.get(i).getId()) {
							System.out.println("Dando de baja...");
							listaClientes.remove(i);
						}
					}
				//La opcion 4 simplemente muestra los clientes de la lista 
				//con un .toString().
				}else if(opcion.equals("4")) {
					for(int i = 0; i < listaClientes.size(); i++) {
						System.out.println(listaClientes.get(i).toString());
					}
				}
			//La opcion 5 cierra la aplicacion.
			}while(!opcion.equals("5"));
			System.out.println("Saliendo...");
			
/*
 * En esta escritura por fichero lo que hacemos en recorrer toda la lista, 
 * llamar al metodo toString() el cual tiene todos los datos de cada cliente y
 * meterlos en el fichero uno a uno, sobreescribiendo los datos introducidos
 * anteriormente, de esta manera siempre tendremos toda la lista actualizada, 
 * ya se haya añadido, modificado o borrado algun cliente.
 */
			
			for(int i = 0; i < listaClientes.size(); i++) {
				bw.newLine();
				bw.write(listaClientes.get(i).toString());
				bw.newLine();
				
			}bw.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}

		x.close();
		y.close();
	}

}