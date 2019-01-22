package modelo;

public class Municipio {
	
	private String nombre;
	private int codPostal;
	private int paradas;
	
	public Municipio(String nombre, int codPostal, int paradas) {
		this.nombre = nombre;
		this.codPostal = codPostal;
		this.paradas = paradas;
	}

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

	public int getParadas() {
		return paradas;
	}

	public void setParadas(int paradas) {
		this.paradas = paradas;
	}
}
