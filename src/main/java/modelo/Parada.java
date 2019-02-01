package modelo;

public class Parada {

	private int codParada;
	private String calle;
	private String nombre;
	private float coordX;
	private float coordY;
	
	public Parada(int codParada, String calle, String nombre, float coordX, float coordY) {
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

	public float getCoordX() {
		return coordX;
	}

	public void setCoordX(float coordX) {
		this.coordX = coordX;
	}

	public float getCoordY() {
		return coordY;
	}

	public void setCoordY(float coordY) {
		this.coordY = coordY;
	}
	
}
