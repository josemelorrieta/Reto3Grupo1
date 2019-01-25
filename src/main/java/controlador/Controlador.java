package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controlador.Controlador.ControladorLogin;
import modelo.Modelo;
import vista.Ventana;

public class Controlador implements ActionListener {
	public class ControladorLogin {

	} 


	//Declaración e inicialización de variables;
	private Modelo miModelo;
	private Ventana miVentana;

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
	
	
	//Constructor
	public Controlador(Ventana miVentana, Modelo miModelo) {
		this.miVentana = miVentana;
		this.miModelo = miModelo;

		miVentana.login.btnLogin.addActionListener(this);

		
		this.miControladorSaludo = new ControladorSaludo(miVentana);
		this.miControladorLogin = new ControladorLogin();
		this.miControladorRegistro = new ControladorRegistro(miVentana);
		this.miControladorBilletes = new ControladorBilletes(miVentana);
		this.miControladorLineas = new ControladorLineas(miVentana);
		this.miControladorParadas = new ControladorParadas(miVentana);
		this.miControladorFechas = new ControladorFechas(miVentana);
		this.miControladorBilleteComprado = new ControladorBilleteComprado(miVentana);
		this.miControladorPago = new ControladorPago(miVentana);
		this.miControladorDevolucion = new ControladorDevolucion(miVentana);
	

		
	}
	

	//Inicio del programa


	@Override
	public void actionPerformed(ActionEvent e) {
//
//		if (e.getSource()==miVentana.login.btnLogin) {
//			try {
//				if(funciones.comprobarDBI(miVentana.login.TextDni.getText()))
//					JOptionPane.showMessageDialog(miVentana, "Existe el DNI", "Advertencia",  JOptionPane.INFORMATION_MESSAGE);
//				else
//					JOptionPane.showMessageDialog(miVentana, "No existe el DNI", "Advertencia",  JOptionPane.INFORMATION_MESSAGE);
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}

	}
	
}
