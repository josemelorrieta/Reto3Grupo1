package controlador;

import modelo.Modelo;
import vista.Ventana;

/**
 * Clase controlador. Se encarga de conectar la clase Modelo de tratamiento de la informacion con la clase Vista que interaccciona con el usuario
 * Tiene las instancias de todos los controladores de cada uno de los paneles donde se añaden las acciones de cada boton y elemento del panel
 * 
 */

public class Controlador {
 
	//Declaración e inicialización de variables;
	//Instancias del Modelo y la Vista
	public Modelo miModelo;
	public Ventana miVentana;
	
	//Instancias de los controladores de cada panel de la ventana
	private ControladorSaludo miControladorSaludo; 
	private ControladorLogin miControladorLogin;
	private ControladorRegistro miControladorRegistro; 
	public ControladorBilletes miControladorBilletes;
	private ControladorLineas miControladorLineas;
	private ControladorParadas miControladorParadas;
	public ControladorFechas miControladorFechas;
	private ControladorBilleteComprado miControladorBilleteComprado;
	public ControladorPago miControladorPago;
	private ControladorDevolucion miControladorDevolucion;
	public ControladorDespedida miControladorDespedida;

	//Constructor
	public Controlador(Ventana miVentana, Modelo miModelo) { 
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		this.miControladorSaludo = new ControladorSaludo(miVentana);	
		this.miControladorLogin = new ControladorLogin(this, miVentana, miModelo);
		this.miControladorRegistro = new ControladorRegistro(this, miVentana, miModelo);
		this.miControladorBilletes = new ControladorBilletes(miVentana, miModelo);
		this.miControladorLineas = new ControladorLineas(miVentana, miModelo);
		this.miControladorParadas = new ControladorParadas(this, miVentana, miModelo);
		this.miControladorFechas = new ControladorFechas(miVentana, miModelo);
		this.miControladorBilleteComprado = new ControladorBilleteComprado(this, miVentana, miModelo);
		this.miControladorPago = new ControladorPago(miVentana, miModelo);
		this.miControladorDevolucion = new ControladorDevolucion(miVentana, this, miModelo);
		this.miControladorDespedida = new ControladorDespedida(miVentana);
		
	
	}
	

	//Inicio del programa

	
}
