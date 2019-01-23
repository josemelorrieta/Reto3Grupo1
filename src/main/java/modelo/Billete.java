package modelo;

public class Billete {
	
	private int numBillete;
	private String fecha;
	private String codLinea;
	private String origen;
	private String destino;
	private int codAutobus;
	private double precioTrayecto;
	private int dni;
	
	public Billete(int numBillete, String fecha, String codLinea, String origen, String destino, int codAutobus, double precioTrayecto, int dni) {
		this.numBillete = numBillete;
		this.fecha = fecha;
		this.codLinea = codLinea;
		this.origen = origen;
		this.destino = destino;
		this.codAutobus = codAutobus;
		this.precioTrayecto = precioTrayecto;
		this.codAutobus = codAutobus;
		this.dni = dni;
	}

	public int getNumBillete() {
		return numBillete;
	}

	public void setNumBillete(int numBillete) {
		this.numBillete = numBillete;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getCodAutobus() {
		return codAutobus;
	}

	public void setCodAutobus(int codAutobus) {
		this.codAutobus = codAutobus;
	}

	public double getPrecioTrayecto() {
		return precioTrayecto;
	}

	public void setPrecioTrayecto(double precioTrayecto) {
		this.precioTrayecto = precioTrayecto;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
}
