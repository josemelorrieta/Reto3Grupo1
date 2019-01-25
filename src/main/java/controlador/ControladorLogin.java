package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

public class ControladorLogin implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorLogin (Ventana miVentana) {
			
			this.miVentana = miVentana;
			
			miVentana.login.btnAtras.addActionListener(this);
			miVentana.login.btnRegistrarse.addActionListener(this);
					
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasLogin":  funciones.irDesdeLoginASaludo(miVentana);  break;
				case "btnRegistrarseLogin": funciones.irDesdeLoginARegistro(miVentana);  break;	

			}
			
		}

}
