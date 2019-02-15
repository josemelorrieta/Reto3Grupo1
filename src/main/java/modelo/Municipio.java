package modelo;

/**
 * Clase del objeto municipio
 *
 */
public class Municipio {
	
	private String nombre;
	private int codPostal;
	private int[] paradas;
	
	/**
	 * Constructor de la clase del objeto municipio
	 * @param nombre Nombre del municipio
	 * @param codPostal Codigo postal del municipio
	 * @param paradas Paradas que hay en el municipio
	 */
	public Municipio(String nombre, int codPostal, int[] paradas) {
		this.nombre = nombre;
		this.codPostal = codPostal;
		this.paradas = paradas;
	}

	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public int[] getParadas() {
		return paradas;
	}

	public void setParadas(int[] paradas) {
		this.paradas = paradas;
	}
}
