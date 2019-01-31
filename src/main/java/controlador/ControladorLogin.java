package controlador;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import modelo.Billete;
import modelo.Cliente;
import modelo.FuncionesBilletes;
import modelo.FuncionesLogin;
import modelo.Modelo;
import vista.Ventana;

public class ControladorLogin implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	FuncionesVarias funcionesVarias = new FuncionesVarias();
	FuncionesLogin funcionesLogin = new FuncionesLogin();
		
	private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
//	private Cliente cliente;
//	private Billete[] billetes;
		
	//Constructor
		public ControladorLogin(Controlador miControlador, Ventana miVentana, Modelo miModelo) { 
			
			this.miControlador = miControlador;
			this.miVentana = miVentana;
			this.miModelo = miModelo;
//			this.cliente = miModelo.cliente;
//			this.billetes = miModelo.billetes;
			
			miVentana.login.btnAtras.addActionListener(this);
			miVentana.login.btnRegistrarse.addActionListener(this);
			miVentana.login.btnLogin.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {

				case "btnAtrasLogin":   funciones.cambiarDePanel(miVentana.login, miVentana.saludo);
					resetValoresLogin();  
					break;
				case "btnRegistrarseLogin":	funciones.cambiarDePanel(miVentana.login, miVentana.registro);
					resetValoresLogin();
					break;
				case "btnLogin":
					try {
						miModelo.cliente = funcionesLogin.comprobarDNI(miVentana.login.TextDni.getText(), miVentana.login.passwordField.getPassword(), miModelo.cliente, miVentana);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(miModelo.cliente != null) 
						funciones.cambiarDePanel(miVentana.login, miVentana.billetes);
						try {
							miModelo.billetes = miModelo.misFuncionesBilletes.billetesCliente(miModelo.cliente, miModelo.billetes);
							miControlador.miControladorBilletes.actualizarBilletes(miModelo.billetes);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
			}
		}
		
		public void resetValoresLogin() {
			miVentana.login.TextDni.setText(""); 
			miVentana.login.passwordField.setText("");
		}

}