package modelo;

public class LineaAutobus {

	private int codLinea;
	private int codAutobus;
	private String municipios;
	
	public LineaAutobus(int codLinea, int codAutobus, String municipios) {
		this.codLinea = codLinea;
		this.codAutobus = codAutobus;
		this.municipios = municipios;
	}

	public int getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(int codLinea) {
		this.codLinea = codLinea;
	}

	public int getCodAutobus() {
		return codAutobus;
	}

	public void setCodAutobus(int codAutobus) {
		this.codAutobus = codAutobus;
	}

	public String getMunicipios() {
		return municipios;
	}

	public void setMunicipios(String municipios) {
		this.municipios = municipios;
	}
}
