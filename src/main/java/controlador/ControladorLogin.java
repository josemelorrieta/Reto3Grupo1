package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Cliente;
import vista.Ventana;

public class ControladorLogin implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	FuncionesVarias funcionesVarias = new FuncionesVarias();
		
	//private Controlador miControlador;
	private Ventana miVentana;
	private Cliente cliente;
		
	//Constructor
		public ControladorLogin(Ventana miVentana, Cliente cliente) { 
			
			this.miVentana = miVentana; 
			this.cliente = cliente;
			
			miVentana.login.btnAtras.addActionListener(this);
			miVentana.login.btnRegistrarse.addActionListener(this);
			miVentana.login.btnLogin.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasLogin":   funciones.irDesdeLoginASaludo(miVentana);
					miVentana.login.TextDni.setText(""); 
					miVentana.login.passwordField.setText("");
					break;
				case "btnRegistrarseLogin": funciones.irDesdeLoginARegistro(miVentana); 
					miVentana.login.TextDni.setText(""); 
					miVentana.login.passwordField.setText("");
					break;
				case "btnLogin": try {
						cliente = funcionesVarias.comprobarDNI(miVentana.login.TextDni.getText(), miVentana.login.passwordField.getPassword(), cliente, miVentana);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(cliente != null) 
						funciones.irDesdeLoginABilletes(miVentana);
						break;
			}
		}

}