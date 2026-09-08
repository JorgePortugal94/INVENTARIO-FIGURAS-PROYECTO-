package controlador;

import java.util.ArrayList;

import modelo.Especificaciones;
import modelo.Figuras;
import vista.Consola;

public class Main {
	
	/**
	 * Metodo principal en el cual llamaremos a todos los metodos de las distintas clases
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Figuras>listaFiguras = new ArrayList<Figuras>();
		ArrayList<Especificaciones>listaEsp = new ArrayList<Especificaciones>();
		
		Fichero f = new Fichero();
		f.leerYvolcarArray("inventario.txt", listaFiguras, listaEsp);
		
		System.out.println();
		System.out.println("MUESTRO EL INVENTARIO: \n");
		
		Consola c = new Consola();
		c.muestraInventario(listaFiguras, listaEsp);
		
		BBDD bd = new BBDD();
		System.out.println("GUARDO EN BASE DE DATOS");
		bd.guardarEnBBDD(listaFiguras, listaEsp);
	}

}
