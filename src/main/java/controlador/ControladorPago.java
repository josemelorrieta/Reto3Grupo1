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

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasPago": funciones.irDesdePagoABilleteComprado(miVentana); 
					miVentana.pago.total.setText("");
					miVentana.pago.pagado.setText("");
					miVentana.pago.restante.setText("");
					break;
									 
				case "btnSiguientePago": funciones.irDesdePagoADevolucion(miVentana);  
					break;
				
				case "btnCancelarPago": funciones.irDesdePagoABilletes(miVentana);  
					miVentana.pago.total.setText("");
					miVentana.pago.pagado.setText("");
				    miVentana.pago.restante.setText("");
					break;

				case "btn500" : funciones.SumarRestarDineroPago(500, miVentana);
					break;
					
				case "btn200" : funciones.SumarRestarDineroPago(200, miVentana);
					break;
					
				case "btn100" : funciones.SumarRestarDineroPago(100, miVentana);
					break;
				
				case "btn50" : funciones.SumarRestarDineroPago(50, miVentana);
					break;
				
				case "btn20" : funciones.SumarRestarDineroPago(20, miVentana);
					break;
				
				case "btn10" : funciones.SumarRestarDineroPago(10, miVentana);
					break;
				
				case "btn5" :  funciones.SumarRestarDineroPago(5, miVentana);
					break;
				
				case "btn2" : funciones.SumarRestarDineroPago(2, miVentana);
					break;
				
				case "btn1" : funciones.SumarRestarDineroPago(1, miVentana);
					break;
					
				case "btn050" : funciones.SumarRestarDineroPago(0.5f , miVentana);
					break;
				
				case "btn020" : funciones.SumarRestarDineroPago(0.2f, miVentana);
					break;
				
				case "btn010" : funciones.SumarRestarDineroPago(0.1f, miVentana);
					break;
				
				case "btn005" : funciones.SumarRestarDineroPago(0.05f, miVentana);
					break;
				
				case "btn002" : funciones.SumarRestarDineroPago(0.02f, miVentana);
					break;
					
				case "btn001" : funciones.SumarRestarDineroPago(0.01f, miVentana);
					break;

			}
			
		}
}
