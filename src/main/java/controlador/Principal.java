package controlador;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Vista;

public class Principal {
	Modelo miModelo;
	Vista miVentana;
	Controlador miControlador;
	
	public static void main(String[] args) {
		// Declaraci�n e inicializaci�n de variables
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
//		miControlador.setMiModelo(miModelo);
//		miControlador.setMiVentana(miVentana);
		miVentana.setControlador(miControlador);
		miModelo.setControlador(miControlador);
		
		
		//Iniciar la ventana
		miVentana.setVisible(true);
		
	}

}
