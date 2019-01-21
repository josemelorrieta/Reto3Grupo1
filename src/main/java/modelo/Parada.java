package modelo;

public class Parada {

	private int codParada;
	private String calle;
	private String nombre;
	private int coordX;
	private int coordY;
	
	public Parada(int codParada, String calle, String nombre, int coordX, int coordY) {
		this.codParada = codParada;
		this.calle = calle;
		this.nombre = nombre;
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public int getCodParada() {
		return codParada;
	}

	public void setCodParada(int codParada) {
		this.codParada = codParada;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
}
