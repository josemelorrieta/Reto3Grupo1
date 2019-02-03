package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.LineaAutobus;
import modelo.Modelo;
import modelo.Parada;
import vista.Ventana;

/**
 * Clase controlador. Se encarga de conectar la clase Modelo de tratamiento de la informacion con la clase Vista que interaccciona con el usuario
 * Tiene las instancias de todos los controladores de cada uno de los paneles donde se añaden las acciones de cada boton y elemento del panel
 * 
 */

public class Controlador {
 
	//Declaración e inicialización de variables;
	//Instancias del Modelo y la Vista
	private Modelo miModelo;
	private Ventana miVentana;
	
	FuncionesVarias funciones = new FuncionesVarias();  
	
	//Instancias de los controladores de cada panel de la ventana
	private ControladorSaludo miControladorSaludo; 
	private ControladorLogin miControladorLogin;
	private ControladorRegistro miControladorRegistro; 
	public ControladorBilletes miControladorBilletes;
	private ControladorLineas miControladorLineas;
	private ControladorParadas miControladorParadas;
	public ControladorFechas miControladorFechas;
	private ControladorBilleteComprado miControladorBilleteComprado;
	private ControladorPago miControladorPago;
	private ControladorDevolucion miControladorDevolucion;
	public ControladorDespedida miControladorDespedida;
	
	private ArrayList<Parada> paradas = new ArrayList<Parada>();
	private ArrayList<LineaAutobus> lineas = new ArrayList<LineaAutobus>();

	//Constructor
	public Controlador(Ventana miVentana, Modelo miModelo) { 
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		this.miControladorSaludo = new ControladorSaludo(miVentana);	
		this.miControladorLogin = new ControladorLogin(this, miVentana, miModelo);
		this.miControladorRegistro = new ControladorRegistro(this, miVentana, miModelo);
		this.miControladorBilletes = new ControladorBilletes(miVentana, miModelo);
		this.miControladorLineas = new ControladorLineas(miVentana, lineas);
		this.miControladorParadas = new ControladorParadas(this, miVentana, miModelo, paradas, lineas);
		this.miControladorFechas = new ControladorFechas(miVentana, miModelo);
		this.miControladorBilleteComprado = new ControladorBilleteComprado(miVentana);
		this.miControladorPago = new ControladorPago(miVentana, miModelo);
		this.miControladorDevolucion = new ControladorDevolucion(miVentana, this);
		this.miControladorDespedida = new ControladorDespedida(miVentana);
		
	
	}
	

	//Inicio del programa

	
}
