package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

/**
 * Clase que contiene el controlador del panel que muestra el resumen del billete comprado por el cliente 
 * 
 *
 */
public class ControladorBilleteComprado implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();	
	
	private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	/**
	 * Constructor de la clase ControladorBilleteComprado
	 * Se definen todos lo listener de los botones del panel
	 * 
	 * @param miVentana Instancia de la ventana de la aplicacion
	 */
	public ControladorBilleteComprado (Controlador miControlador, Ventana miVentana, Modelo miModelo) { 
		
		this.miControlador = miControlador;
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		// Definicion de los listeners de los botones del panel
		miVentana.billeteComprado.btnAtras.addActionListener(this);
		miVentana.billeteComprado.btnSiguiente.addActionListener(this);
		miVentana.billeteComprado.btnCancelar.addActionListener(this); 
		
	}
		
	/**
	 * Metodo para resetear los valores de la ventana billetes comprados 
	 */
		public void resetear() {
			miVentana.billeteComprado.txtIda.setText("");
			miVentana.billeteComprado.txtVuelta.setText("");
			miVentana.billeteComprado.txtVuelta.setEnabled(false);
			miVentana.billeteComprado.lblPrecioTotal.setText("");
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
											
			case "btnSiguienteBilleteComprado":
				if (miModelo.billeteVuelta != null) {
					miVentana.pago.total.setText(formatoMoneda.format(miModelo.billeteIda.getPrecioTrayecto() + miModelo.billeteVuelta.getPrecioTrayecto()));
					miControlador.miControladorPago.total = miModelo.billeteIda.getPrecioTrayecto() + miModelo.billeteVuelta.getPrecioTrayecto();
				} else {
					miVentana.pago.total.setText(formatoMoneda.format(miModelo.billeteIda.getPrecioTrayecto()));
					miControlador.miControladorPago.total = miModelo.billeteIda.getPrecioTrayecto();
				}
				funciones.cambiarDePanel(miVentana.billeteComprado, miVentana.pago);
				break;
			
			case "btnCancelarBilleteComprado":  funciones.cambiarDePanel(miVentana.billeteComprado, miVentana.billetes);
				resetear();
				break;
		}
	}
	
}
