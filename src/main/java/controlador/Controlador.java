package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class Controlador implements ActionListener {
	//Declaración e inicialización de variables;
	private Modelo miModelo;
	private Ventana miVentana;
	private ControladorSaludo miControladorSaludo;
	//Constructor
	public Controlador(Ventana miVentana, Modelo miModelo) {
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		this.miControladorSaludo = new ControladorSaludo(miVentana);
	
		
	}
	
	
	//Inicio del programa


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
