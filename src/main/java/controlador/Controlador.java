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

public class Controlador {
  
	//Declaración e inicialización de variables;
	private Modelo miModelo;
	private Ventana miVentana;

	private Cliente cliente = null;
	
	FuncionesVarias funciones = new FuncionesVarias();  

	private ControladorSaludo miControladorSaludo;
	private ControladorLogin miControladorLogin;
	private ControladorRegistro miControladorRegistro;
	private ControladorBilletes miControladorBilletes;
	private ControladorLineas miControladorLineas;
	private ControladorParadas miControladorParadas;
	private ControladorFechas miControladorFechas;
	private ControladorBilleteComprado miControladorBilleteComprado;
	private ControladorPago miControladorPago;
	private ControladorDevolucion miControladorDevolucion;
	private ArrayList<Parada> paradas = new ArrayList<Parada>();
	private ArrayList<LineaAutobus> lineas = new ArrayList<LineaAutobus>();

	//Constructor
	public Controlador(Ventana miVentana, Modelo miModelo) { 
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		this.miControladorSaludo = new ControladorSaludo(miVentana);
		this.miControladorRegistro = new ControladorRegistro(miVentana, cliente);
		this.miControladorBilletes = new ControladorBilletes(miVentana);
		this.miControladorLineas = new ControladorLineas(miVentana, lineas);
		this.miControladorParadas = new ControladorParadas(miVentana);
		this.miControladorFechas = new ControladorFechas(miVentana);
		this.miControladorBilleteComprado = new ControladorBilleteComprado(miVentana);
		this.miControladorPago = new ControladorPago(miVentana);
		this.miControladorDevolucion = new ControladorDevolucion(miVentana);	
		this.miControladorLogin = new ControladorLogin(miVentana, cliente);
	
	}
	

	//Inicio del programa

	
}
