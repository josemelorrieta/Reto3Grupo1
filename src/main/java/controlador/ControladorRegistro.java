package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Cliente;
import modelo.FuncionesRegistro;
import vista.Ventana;

public class ControladorRegistro implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	FuncionesRegistro funcionesRegistro = new FuncionesRegistro();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Cliente cliente; 	
	
	//Constructor
		public ControladorRegistro (Ventana miVentana, Cliente cliente) {

			this.miVentana = miVentana;
			this.cliente = cliente;
			
			miVentana.registro.btnCancelar.addActionListener(this);
			miVentana.registro.btnRegistrarse.addActionListener(this);
			
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
				case "btnRegistro": cliente = funcionesRegistro.registrarNuevoCliete();
			}
			
		}

}
 