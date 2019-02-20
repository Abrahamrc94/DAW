/**
 * Mediamarkt est� en ofertas! Tiene muchos clientes y se est� quedando sin articulos. Por cada cliente se crear� un objeto que ser� el que va a comprar.
 * Estos objetos hay que almacenarlos en una Lista. Cada vez que un objeto sea comprado, es decir, creado, ser� a�adido por entrada de fichero a un 
 * archivo de .txt con sus especificaciones junto con su cliente. Cada cliente se crear� por par�metros(Nombre, Apellidos, DNI) y se almacenaran en una lista y en el fichero mencionado anteriormente. 
 * Cuando finalice la cola de compra (X clientes), se mostrar� por pantalla los articulos comprados por salida de fichero junto con el cliente que lo ha comprado.
 * 
 * Los par�metros de los objetos ser�n: Precio base y descuento,  El descuento, �ste ser� uno random hasta 50% que se aplicar� al precio base y se asignar� al precio final.
 * 
 * Los atributos de los articulos seran: Precio final, secci�n del articulo (Videojuego, Televisores, Aspiradoras u Ordenadores) e ID del articulo.
 * 
 * Los par�metros del cliente ser�n: Nombre, Apellido, dni.
 * 
 * Crea el Javadoc
 */
package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import Articulos.Articulo;
import Clientes.Cliente;

/**
 * @author Jose
 *
 */
public class Main {
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Cliente cliente;
		Articulo articulo;
		String seccion;
		String nombre;
		String apellido;
		String dni;
		double precioBase;
		double descuento;
		boolean correcto;
		
		Scanner x = new Scanner(System.in);
		Scanner y = new Scanner(System.in);
		
		HashSet <Object> ListaArticulos = new HashSet<>();
		HashSet <Object> ListaClientes = new HashSet<>();
		
		for(int i = 0; i < 2; i++) {
			
			correcto = false;
			
			System.out.print("Introduce nombre: ");
			nombre = x.nextLine();
			System.out.print("Introduce apellido: ");
			apellido = x.nextLine();
			System.out.print("Introduce dni: ");
			dni = x.nextLine();
			
			System.out.print("Introduce precio base del articulo: ");
			precioBase = (double)y.nextInt();
			
			descuento = (int)(Math.random()*50);
			
			cliente = new Cliente(nombre, apellido, dni);
			ListaClientes.add(cliente);
			articulo = new Articulo(precioBase, descuento);
			
			do {
				System.out.print("Introduzca la seccion a la que pertenece el articulo (ordenador, videojuego, televisor, aspiradora): ");
				seccion = x.nextLine();
				
				if(seccion.equals("ordenador")) {
					articulo.setSeccion(Articulo.seccionArt.ORDENADOR);
					correcto = true;
				}else if(seccion.equals("videojuego")) {
					articulo.setSeccion(Articulo.seccionArt.VIDEOJUEGO);
					correcto = true;
				}else if(seccion.equals("televisor")) {
					articulo.setSeccion(Articulo.seccionArt.TELEVISOR);
					correcto = true;
				}else if(seccion.equals("aspiradora")) {
					articulo.setSeccion(Articulo.seccionArt.ASPIRADORA);
					correcto = true;
				}else {
					System.out.println("Seccion no introducida correctamente");
				}
			}while(correcto == false);
			ListaArticulos.add(articulo);
			
			try {
				
				BufferedWriter bw = new BufferedWriter(new FileWriter("Mediamarkt.txt", true));
				bw.newLine();
				bw.write("Cliente " + i);
				bw.newLine();
				bw.write(cliente.toString());
				bw.newLine();
				bw.write(articulo.toString());
				bw.newLine();
				bw.close();
				
			}catch(Exception e2) {
				System.out.println("ERROR");
			}
			
		}
		
		cliente = new Cliente();
		
		String cadena;
		
		try {
	    FileReader f = new FileReader("Mediamarkt.txt");
	    BufferedReader b = new BufferedReader(f);
	    while((cadena = b.readLine())!=null) {
	        System.out.println(cadena);
	    }
	    b.close();
		}catch(Exception e) {
			System.out.println("Error");
		}
		
		x.close();
		y.close();
		
	}

}
