package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Especificaciones;
import modelo.Figuras;

public class BBDD { 
	/**
	 * Metodo para validar tamanios de figuras y filtrar los valores
	 * @param tamanio se le pasa en cm de la figura
	 * @throws Excepciontamanio mediante la cual sacaremos el mensaje necesario
	 */
	public void validarTamanio (float tamanio)throws Excepciontamanio{
		if(tamanio < 100.0f) {
			throw new Excepciontamanio("no cumple con los requisitos");
		}
	}
	
	/**
	 * metodo para aniadir a la base de datos toda la informacion
	 * @param listFiguras informacion de las figuras que se incluira en su tabla correspondiente
	 * @param listEsp informacion de las especificaciones que se incluira en su tabla correspondiente
	 */
	public void guardarEnBBDD(ArrayList<Figuras>listFiguras,ArrayList<Especificaciones>listEsp) {
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/inventario_figuras","root","");
			
			String insertarFigura = "insert into figuras(nombre,tipomaterial,tamaniocm) values(?,?,?)";
			String insertarEspec = "insert into especificaciones(vendido,unidades) values(?,?)";
			
			PreparedStatement psIns = conexion.prepareStatement(insertarFigura);
			PreparedStatement psInsEs = conexion.prepareStatement(insertarEspec);
			
			for (int i = 0; i < listFiguras.size(); i++) {
				Figuras f = listFiguras.get(i);
				try {
					validarTamanio(f.getTamaniocm());
					psIns.setString(1, f.getNombre());
					psIns.setString(2, f.getTipo().toString());
					psIns.setFloat(3, f.getTamaniocm());
					
					psIns.executeUpdate();
					
					if(i < listEsp.size()) {
						Especificaciones e = listEsp.get(i);
						
						psInsEs.setBoolean(1, e.isVendido());
						psInsEs.setInt(2, e.getUnidades());
						
						psInsEs.executeUpdate();
					}
				}catch(Excepciontamanio ex) {
					System.out.println("La figura " + f.getNombre() + " " + ex.getMessage());
				}
			}
			System.out.println("Datos insertados de figuras con sus especificaciones");		
			
		} catch (SQLException e) {
			System.out.println("No se han podido insertar los datos");
		}
			
	}
	
	

}
