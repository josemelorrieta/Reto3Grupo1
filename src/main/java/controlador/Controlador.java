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
		
		this.setMiControladorSaludo(new ControladorSaludo(miVentana));	
		this.setMiControladorLogin(new ControladorLogin(this, miVentana, miModelo));
		this.setMiControladorRegistro(new ControladorRegistro(this, miVentana, miModelo));
		this.miControladorBilletes = new ControladorBilletes(miVentana);
		this.setMiControladorLineas(new ControladorLineas(miVentana, miModelo));
		this.setMiControladorParadas(new ControladorParadas(miVentana, miModelo, this));
		this.miControladorFechas = new ControladorFechas(miVentana, miModelo);
		this.setMiControladorBilleteComprado(new ControladorBilleteComprado(this, miVentana, miModelo));
		this.miControladorPago = new ControladorPago(miVentana, miModelo);
		this.setMiControladorDevolucion(new ControladorDevolucion(miVentana, this, miModelo));
		this.miControladorDespedida = new ControladorDespedida(miVentana);
		
	}

	//Getters and setters
	public ControladorSaludo getMiControladorSaludo() {
		return miControladorSaludo;
	}

	public void setMiControladorSaludo(ControladorSaludo miControladorSaludo) {
		this.miControladorSaludo = miControladorSaludo;
	}

	public ControladorLogin getMiControladorLogin() {
		return miControladorLogin;
	}

	public void setMiControladorLogin(ControladorLogin miControladorLogin) {
		this.miControladorLogin = miControladorLogin;
	}

	public ControladorRegistro getMiControladorRegistro() {
		return miControladorRegistro;
	}

	public void setMiControladorRegistro(ControladorRegistro miControladorRegistro) {
		this.miControladorRegistro = miControladorRegistro;
	}

	public ControladorLineas getMiControladorLineas() {
		return miControladorLineas;
	}

	public void setMiControladorLineas(ControladorLineas miControladorLineas) {
		this.miControladorLineas = miControladorLineas;
	}

	public ControladorParadas getMiControladorParadas() {
		return miControladorParadas;
	}

	public void setMiControladorParadas(ControladorParadas miControladorParadas) {
		this.miControladorParadas = miControladorParadas;
	}

	public ControladorBilleteComprado getMiControladorBilleteComprado() {
		return miControladorBilleteComprado;
	}

	public void setMiControladorBilleteComprado(ControladorBilleteComprado miControladorBilleteComprado) {
		this.miControladorBilleteComprado = miControladorBilleteComprado;
	}

	public ControladorDevolucion getMiControladorDevolucion() {
		return miControladorDevolucion;
	}

	public void setMiControladorDevolucion(ControladorDevolucion miControladorDevolucion) {
		this.miControladorDevolucion = miControladorDevolucion;
	}
	

	//Inicio del programa

	
}
