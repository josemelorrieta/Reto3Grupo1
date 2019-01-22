package controlador;

import modelo.Modelo;
import vista.Ventana;

public class Principal {
	Modelo miModelo;
	Ventana miVentana;
	Controlador miControlador;
	
	public static void main(String[] args) {
		// Declaraci�n e inicializaci�n de variables
		Principal miPrincipal = new Principal();		
		
		//Inicio del programa
		miPrincipal.inicar();
		
	}
	
	public void inicar() {
		// Instanciar clases
		miVentana = new Ventana();
		miModelo = new Modelo();
		miControlador = new Controlador(miVentana, miModelo);
		
		// Asociaciones entre clases
		miModelo.setControlador(miControlador);
		
		
		//Iniciar la ventana
		miVentana.setVisible(true);
		
	}

}
