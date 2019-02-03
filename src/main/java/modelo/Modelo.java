package modelo;

import java.util.ArrayList;

import controlador.Controlador;

/**
 * Clase del modelo de la aplicacion. Tiene las instancias a las clases de las funciones que manejan los datos de cada panel
 *
 */
public class Modelo {
	// Declaración e inicialización de variables
	private Controlador miControlador;
	public FuncionesLogin misFuncionesLogin;
	public FuncionesRegistro misFuncionesRegistro;
	public FuncionesBilletes misFuncionesBilletes;
	public FuncionesFechas misFuncionesFechas;
	public FuncionesPago misFuncionesPago;
	public FuncionesDevolucion misFuncionesDevolucion;
	
	public Cliente cliente = null;
	public Billete[] billetes = null;
	public ArrayList<LineaAutobus> lineas = null;
	public ArrayList<Parada> paradas = null;
	
	/**
	 * Constructor de la clase
	 */
	public Modelo() {
		//Instacias de todas las clases de las funciones de cada panel
		this.misFuncionesLogin = new FuncionesLogin();
		this.misFuncionesRegistro = new FuncionesRegistro();
		this.misFuncionesBilletes = new FuncionesBilletes(); 
		this.misFuncionesPago = new FuncionesPago();
		this.misFuncionesDevolucion = new FuncionesDevolucion(this);
		this.misFuncionesFechas = new FuncionesFechas();
		
	}

	//Getters y setters
	public Controlador getControlador() {
		return miControlador;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	} 

}
 