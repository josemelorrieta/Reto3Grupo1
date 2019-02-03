package modelo;

/**
 * Clase objeto billete
 *
 */
public class Billete {
	
	private int numBillete;
	private String fecha;
	private String codLinea;
	private String origen;
	private String destino;
	private int codAutobus;
	private double precioTrayecto;
	private String dni;
	
	/**
	 * Constructor del objeto billete
	 * @param numBillete numero de orden del billete
	 * @param fecha fecha de compra del billete
	 * @param codLinea codigo de la linea a la que hace referencia el billete
	 * @param origen parada de origen del billete
	 * @param destino parada de destino del billete
	 * @param codAutobus codigo del autobus que hara el trayecto
	 * @param precioTrayecto precio del billete
	 * @param dni identificacion del cliente que ha comprado el billete
	 */
	public Billete(int numBillete, String fecha, String codLinea, String origen, String destino, int codAutobus, double precioTrayecto, String dni) {
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

	//Getters y setters
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
