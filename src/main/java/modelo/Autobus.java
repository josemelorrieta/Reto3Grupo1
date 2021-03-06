package modelo;

/**
 * Clase objeto autobus
 *
 */
public class Autobus {

	private int codAutobus;
	private int plazas;
	private float consumo;
	private String color;
	
	/** 
	 * Constructor del objeto autobus
	 * @param codAutobus codigo del autobus
	 * @param plazas plazas totales
	 * @param consumo consumo de gasoil por kilometro
	 * @param color color del autobus
	 */
	public Autobus(int codAutobus, int plazas, float consumo, String color) {
		this.codAutobus = codAutobus;
		this.plazas = plazas;
		this.consumo = consumo;
		this.color = color;
	}

	// Getters y setters
	public int getCodAutobus() {
		return codAutobus;
	}

	public void setCodAutobus(int codAutobus) {
		this.codAutobus = codAutobus;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
