package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class Controlador  implements ActionListener {
	//Declaración e inicialización de variables;
	private Modelo miModelo;
	private Ventana miVentana;

	//Constructor
	public Controlador(Ventana miVentana, Modelo miModelo) {
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
	}
	
	//Inicio del programa


	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource()==miVentana.btnPincha) {
//			miVentana.textField.setText("Hola");
//		}
	}
	
}
