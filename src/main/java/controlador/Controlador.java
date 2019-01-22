package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Vista;

public class Controlador  implements ActionListener {
	//Declaración e inicialización de variables;
	private Modelo miModelo;
	private Vista miVentana;

	//Constructor
	public Controlador(Vista miVentana, Modelo miModelo) {
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		this.miVentana.btnPincha.addActionListener(this);
	}
	
	//Inicio del programa


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==miVentana.btnPincha) {
			miVentana.textField.setText("Hola");
		}
	}
	
}
