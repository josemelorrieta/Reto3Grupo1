package modelo;

public class LineaAutobus {

	private String codLinea;
	private int[] codAutobus;
	private String[] municipios;
	
	public LineaAutobus(String codLinea, int[] codAutobus, String[] municipios) {
		this.codLinea = codLinea;
		this.codAutobus = codAutobus;
		this.municipios = municipios;
	}

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
 