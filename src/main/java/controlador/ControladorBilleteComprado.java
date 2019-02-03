package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

/**
 * Clase que contiene el controlador del panel que muestra el resumen del billete comprado por el cliente 
 * 
 *
 */
public class ControladorBilleteComprado implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	/**
	 * Constructor de la clase ControladorBilleteComprado
	 * Se definen todos lo listener de los botones del panel
	 * 
	 * @param miVentana Instancia de la ventana de la aplicacion
	 */
	public ControladorBilleteComprado (Ventana miVentana) { 
		
		this.miVentana = miVentana;
		
		// Definicion de los listeners de los botones del panel
		miVentana.billeteComprado.btnAtras.addActionListener(this);
		miVentana.billeteComprado.btnSiguiente.addActionListener(this);
		miVentana.billeteComprado.btnCancelar.addActionListener(this); 
		
	}
		
	/**
	 * Metodo para resetear los valores de la ventana billetes comprados 
	 */
		public void resetear() {
			miVentana.billeteComprado.modeloMostrarBilletesComprado.removeAllElements();
		}
	/**
	 * Metodo para las llamadas a los botones de la ventana billetes comprados
	 * Sobreescribe al metodo original	
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Accion segun el boton que llama al listener
		switch (((JButton) e.getSource()).getName()) {
			case "btnAtrasBilleteComprado": funciones.cambiarDePanel(miVentana.billeteComprado, miVentana.fechas);
											resetear();
											break;
											
			case "btnSiguienteBilleteComprado": funciones.cambiarDePanel(miVentana.billeteComprado, miVentana.pago); 
												break;
			
			case "btnCancelarBilleteComprado":  funciones.cambiarDePanel(miVentana.billeteComprado, miVentana.billetes);
												resetear();
												break;
		}
	}
	
}
