package controlador;

import modelo.Modelo;
import vista.Vista;

public class Principal {
	Modelo miModelo;
	Vista miVentana;
	Controlador miControlador;
	
	public static void main(String[] args) {
		// Declaración e inicialización de variables
		Principal miPrincipal = new Principal();		
		
		//Inicio del programa
		miPrincipal.inicar();
		
	}
	
	public void inicar() {
		// Instanciar clases
		miVentana = new Vista();
		miModelo = new Modelo();
		miControlador = new Controlador(miVentana, miModelo);
		
		// Asociaciones entre clases
		miVentana.setControlador(miControlador);
		miModelo.setControlador(miControlador);
		
		
		//Iniciar la ventana
		miVentana.setVisible(true);
		
	}

}
