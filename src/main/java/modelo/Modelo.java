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
	public FuncionesModelo misFuncionesModelo;
	public FuncionesLogin misFuncionesLogin;
	public FuncionesRegistro misFuncionesRegistro;
	public FuncionesBilletes misFuncionesBilletes;
	public FuncionesLineas misFuncionesLineas;
	public FuncionesParadas misFuncionesParadas;
	public FuncionesFechas misFuncionesFechas;
	public FuncionesPago misFuncionesPago;
	public FuncionesDevolucion misFuncionesDevolucion;
	
	public Cliente cliente = null;
	public Billete[] billetes = null;
	public Billete billeteActual = null;
	public LineaAutobus[] lineas = null;
	public Parada[] paradas = null;
	public String[] nombreLineas = null;
	
	/**
	 * Constructor de la clase
	 */
	public Modelo() {
		//Instacia de la clase de funciones generales del modelo
		this.misFuncionesModelo = new FuncionesModelo();
		
		//Instacias de todas las clases de las funciones de cada panel
		this.misFuncionesLogin = new FuncionesLogin();
		this.misFuncionesRegistro = new FuncionesRegistro();
		this.misFuncionesBilletes = new FuncionesBilletes();
		this.misFuncionesLineas = new FuncionesLineas(this);
		this.misFuncionesParadas = new FuncionesParadas(this);
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
 