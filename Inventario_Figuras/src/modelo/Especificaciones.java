package modelo;

public class Especificaciones {
	private boolean vendido;
	private int unidades;
	
	/**
	 * Constructor por defecto
	 */
	public Especificaciones() {
		vendido=false;
		unidades=0;
	}
	/**
	 * Constructor por parametros
	 * @param vendido
	 * @param unidades
	 */
	public Especificaciones(boolean vendido, int unidades) {
		this.vendido=vendido;
		this.unidades=unidades;
	}
	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

}
