package modelo;

public class Figuras {
	private String nombre;
	public enum tipoMaterial{
		PLOMO,PLASTICO,RESINA
	}
	private tipoMaterial tipo;
	private float tamaniocm;
	
	/**
	 * Constructor por defecto
	 */
	public Figuras() {
		nombre="Cualquiera";
		tipo=null;
		tamaniocm=0.0f;
	}
	/**
	 * Constructor por parametros
	 * @param nombre
	 * @param tipo
	 * @param tamaniocm
	 */
	public Figuras(String nombre, tipoMaterial tipo, float tamaniocm) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.tamaniocm = tamaniocm;
	}
	/**
	 * Constructor por parametros diferente
	 * @param nombre
	 * @param tamaniocm
	 */
	public Figuras(String nombre, float tamaniocm) {
		this.nombre=nombre;
		this.tamaniocm=tamaniocm;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public tipoMaterial getTipo() {
		return tipo;
	}

	public void setTipo(tipoMaterial tipo) {
		this.tipo = tipo;
	}

	public float getTamaniocm() {
		return tamaniocm;
	}

	public void setTamaniocm(float tamaniocm) {
		this.tamaniocm = tamaniocm;
	}
	
	
	
}
