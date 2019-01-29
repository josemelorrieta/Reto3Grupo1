package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

public class ControladorRegistro implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorRegistro (Ventana miVentana) {
			 
			this.miVentana = miVentana;
			
			miVentana.registro.btnCancelar.addActionListener(this);
	
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasRegistro": funciones.irDesdeRegistroALogin(miVentana);
										 miVentana.registro.textFieldDni.setText(""); 
										 miVentana.registro.textFieldNombre.setText("");
										 miVentana.registro.textFieldApellidos.setText("");
										 miVentana.registro.textFieldNombre.setText(""); 
										 miVentana.registro.passwordField.setText("");
										 miVentana.registro.textFieldFechaNacimiento.setText("");
										 break;

			}
			
		}

}
 