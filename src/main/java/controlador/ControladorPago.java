package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

public class ControladorPago implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorPago (Ventana miVentana) { 
			
			this.miVentana = miVentana;
			
			miVentana.pago.btnAtras.addActionListener(this);
			miVentana.pago.btnSiguiente.addActionListener(this); 
			miVentana.pago.btnCancelar.addActionListener(this);
			miVentana.pago.btn500.addActionListener(this);
			miVentana.pago.btn200.addActionListener(this);
			miVentana.pago.btn100.addActionListener(this); 
			miVentana.pago.btn50.addActionListener(this);
			miVentana.pago.btn20.addActionListener(this);
			miVentana.pago.btn10.addActionListener(this);
			miVentana.pago.btn5.addActionListener(this);
			miVentana.pago.btn2.addActionListener(this);
			miVentana.pago.btn1.addActionListener(this);
			miVentana.pago.btn050.addActionListener(this);
			miVentana.pago.btn020.addActionListener(this);
			miVentana.pago.btn010.addActionListener(this);
			miVentana.pago.btn005.addActionListener(this);
			miVentana.pago.btn002.addActionListener(this);
			miVentana.pago.btn001.addActionListener(this);
			
			
		}
		
		public void resetear() {
			miVentana.pago.total.setText("");
			miVentana.pago.pagado.setText("");
			miVentana.pago.restante.setText("");
			funciones.dineroPagado=0;
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasPago": funciones.cambiarDePanel(miVentana.pago, miVentana.billeteComprado);
					resetear();
					break;
									 
				case "btnSiguientePago": funciones.cambiarDePanel(miVentana.pago, miVentana.devolucion);
										 funciones.Cambios(funciones.cambios, miVentana);
					resetear();
					break;
				
				case "btnCancelarPago": funciones.cambiarDePanel(miVentana.pago, miVentana.billetes);
					resetear();
					break;

				case "btn500" : funciones.SumarDineroPago(500, miVentana);
					break;
					
				case "btn200" : funciones.SumarDineroPago(200, miVentana);
					break;
					
				case "btn100" : funciones.SumarDineroPago(100, miVentana);
					break;
				
				case "btn50" : funciones.SumarDineroPago(50, miVentana);
					break;
				
				case "btn20" : funciones.SumarDineroPago(20, miVentana);
					break;
				
				case "btn10" : funciones.SumarDineroPago(10, miVentana);
					break;
				
				case "btn5" :  funciones.SumarDineroPago(5, miVentana);
					break;
				
				case "btn2" : funciones.SumarDineroPago(2, miVentana);
					break;
				
				case "btn1" : funciones.SumarDineroPago(1, miVentana);
					break;
					
				case "btn050" : funciones.SumarDineroPago(0.5f , miVentana);
					break;
				
				case "btn020" : funciones.SumarDineroPago(0.2f, miVentana);
					break;
				
				case "btn010" : funciones.SumarDineroPago(0.1f, miVentana);
					break;
				
				case "btn005" : funciones.SumarDineroPago(0.05f, miVentana);
					break;
				
				case "btn002" : funciones.SumarDineroPago(0.02f, miVentana);
					break;
					
				case "btn001" : funciones.SumarDineroPago(0.01f, miVentana);
					break;

			}
			
		}
}
