package modelo;

/**
 * Clase objeto linea de autobus
 *
 */
public class LineaAutobus {

	private String codLinea;
	private int[] codAutobus;
	private String[] municipios;
	
	/**
	 * Constructor del objeto linea de autobus 
	 * @param codLinea Codigo de la linea
	 * @param codAutobus array con los codigos de los autobuses de esa linea 
	 * @param municipios array con los municipios por los que pasa esa linea
	 */
	public LineaAutobus(String codLinea, int[] codAutobus, String[] municipios) {
		this.codLinea = codLinea;
		this.codAutobus = codAutobus;
		this.municipios = municipios;
	}
	
	//Getters y setters
	public String getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}

	public int[] getCodAutobus() {
		return codAutobus;
	} 

	public void setCodAutobus(int[] codAutobus) {
		this.codAutobus = codAutobus;
	}

	public String[] getMunicipios() {
		return municipios;
	}

	public void setMunicipios(String[] municipios) {
		this.municipios = municipios;
	}
}
 