package controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Especificaciones;
import modelo.Figuras;

public class Fichero {
	/**
	 * metodo para leer de fichero dado y volcar todos los datos en dos ArrayList distintos.
	 * @param nombreFichero del que leeremos todos los datos
	 * @param listafiguras lista de la clase modelo figuras
	 * @param listaespecificaciones lista de la clase modelo figuras
	 */
	public void leerYvolcarArray(String nombreFichero, ArrayList<Figuras>listafiguras,ArrayList<Especificaciones>listaespecificaciones) {
		FileReader archivo = null;
		BufferedReader br = null;
		String linea;
		int contador = 0;
		
		Figuras.tipoMaterial tipo = null;
		String nombre = "";
		float tamaniocm = 0.0f;
		
		String vendido = "";
		int unidades = 0;
		
		try {
			archivo = new FileReader(nombreFichero);
			br = new BufferedReader(archivo);
			
			while((linea = br.readLine())!= null) {
				nombre = linea.trim();
				tipo = Figuras.tipoMaterial.valueOf(br.readLine().trim().toUpperCase());
				tamaniocm = Float.parseFloat(br.readLine().trim());
				
				Figuras f = new Figuras(nombre,tipo,tamaniocm);
				listafiguras.add(f);
				
				vendido = br.readLine().trim();
				unidades = Integer.parseInt(br.readLine().trim());
				
				if(vendido.equalsIgnoreCase("stock")) {
					Especificaciones e = new Especificaciones(false,unidades);
					listaespecificaciones.add(e);
				}else {
					Especificaciones e = new Especificaciones(true,unidades);
					listaespecificaciones.add(e);
				}
			}
			br.close();
			System.out.println("volcado correctamente");	
		} catch (FileNotFoundException ex) {
			System.out.println("no se encontro el fichero");
		} catch (IOException ex) {
			System.out.println("no se pudo leer el archivo");
		}
		
	}

}
