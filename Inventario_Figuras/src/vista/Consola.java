package vista;

import java.util.ArrayList;

import modelo.Especificaciones;
import modelo.Figuras;

public class Consola {
	/**
	 * metodo para mostrar el inventario con toda la informacion
	 * @param listaFig lista con los datos de figuras
	 * @param listaEsp lista con los datos de especificaciones
	 */
	public void muestraInventario(ArrayList<Figuras> listaFig,ArrayList<Especificaciones> listaEsp) {
		for(int i=0;i<listaFig.size();i++) {
			Figuras fig = listaFig.get(i);
			System.out.println("Nombre Figura: " + fig.getNombre());
			System.out.println("Tipo de material: " + fig.getTipo());
			System.out.println("Tamanio en cm: " + fig.getTamaniocm());
			
			if(i < listaEsp.size()) {
				Especificaciones esp = listaEsp.get(i);
				if(esp.isVendido()) {
					System.out.println("Estado de venta: vendido");
				}else {
					System.out.println("Estado de venta: disponible");
				}
				System.out.println("Cantidad en stock: " + esp.getUnidades());
			}
		}
		
	}

}
