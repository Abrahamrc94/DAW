package Articulos;

import java.text.DecimalFormat;

/**
 * @author Jose
 *
 */
public class Articulo {

	DecimalFormat f = new DecimalFormat("##.00");
	int idArticulo;
	public static int id = 0;
	private double precioBase;
	private double precioFinal;
	public enum seccionArt {TELEVISOR, ORDENADOR, VIDEOJUEGO, ASPIRADORA};
	private seccionArt seccion;
	private double descuento;
	
	/**
	 * @param precioBase
	 * @param descuento
	 */
	
	public Articulo(double precioBase, double descuento) {
		idArticulo = Articulo.id++;
		this.precioBase = precioBase;
		precioFinal = precioBase - (precioBase * (descuento/100));
		this.descuento = descuento;
		seccion = null;
	}
	
	/**
     * @param seccion
     */
	public void setSeccion(seccionArt seccion) {
		
		this.seccion = seccion;
	}
	
	public String toString() {
		
		return "\nArticulo: " + idArticulo + " - Seccion: " + seccion + " - Precio base: " + precioBase +  "€ - Precio final: " + f.format(precioFinal) + "€ - Descuento: " + descuento + "%";
	}

}
