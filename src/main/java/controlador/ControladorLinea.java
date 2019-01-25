package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.Ventana;

public class ControladorLinea implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorLinea(/*Controlador miControlador,*/ Ventana miVentana) {
			//This.miControlador = miControlador;
			this.miVentana = miVentana;
			
			miVentana.lineas.SeleccionarLinea.addActionListener(this);
			miVentana.login.btnAtras.addActionListener(this);
		
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (miVentana.saludo.btnSaludo.getName()) {
			case "btnSaludo":  funciones.irDesdeSaludoALogin(miVentana);  break;
		
		}
			
		}

}

