package modelo;

import controlador.Controlador;

public class Modelo {
	// Declaraci�n e inicializaci�n de variables
	private Controlador miControlador;
	
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
