package modelo;

import controlador.Controlador;

public class Modelo {
	// Declaraci�n e inicializaci�n de variables
	private Controlador miControlador;
	
	private String servidor = "";
	private String baseDatos = "";
	private String user = "";
	private String password = "";
	
	public Controlador getControlador() {
		return miControlador;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
	
	public void inicializarDatosBD() {
		ConexionBD con = new ConexionBD();
		
		
	}

}
