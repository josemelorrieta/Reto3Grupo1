package controlador;

import modelo.Modelo;
import vista.Ventana;

/** 
 * Clase princnipal. Contiene el metodo main e instancia el Controlador, la Vista y el Modelo
 *
 */
public class Principal {
	// Instancias de Controlador, Vista y Modelo
	Modelo miModelo;
	Ventana miVentana;
	Controlador miControlador;
	
	/**
	 * Metodo main. Inicio del programa
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaración e inicialización de variables
		Principal miPrincipal = new Principal();
		
		//Inicio del programa
		miPrincipal.iniciar();
		
	}
	
	/**
	 * Metodo que inicia el programa instanciando el Controlador y anadiendole la Vista y el Modelo
	 * Tambien muestra la ventana por primera vez
	 */
	public void iniciar() {
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
