package modelo;

import java.util.ArrayList;

import controlador.Controlador;

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
	
	public Modelo() {
		this.misFuncionesLogin = new FuncionesLogin();
		this.misFuncionesRegistro = new FuncionesRegistro();
		this.misFuncionesBilletes = new FuncionesBilletes(); 
		this.misFuncionesPago = new FuncionesPago();
		this.misFuncionesDevolucion = new FuncionesDevolucion(this);
		this.misFuncionesFechas = new FuncionesFechas();
		
	}

	
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
 