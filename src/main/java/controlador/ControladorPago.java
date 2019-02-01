package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.FuncionesPago;
import modelo.Modelo;
import vista.Ventana;

public class ControladorPago implements ActionListener {
	
	//FuncionesPago funciones = new FuncionesPago();
	FuncionesControlador controlar = new FuncionesControlador();
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	//Constructor
		public ControladorPago (Ventana miVentana, Modelo miModelo) { 
			
			this.miVentana = miVentana;
			this.miModelo = miModelo;
			
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
			miModelo.misFuncionesPago.dineroPagado=0;
			miModelo.misFuncionesPago.ActBotones(miVentana.pago.arrayBtn);
					
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasPago": controlar.cambiarDePanel(miVentana.pago, miVentana.billeteComprado);
					resetear();
					break;
									 
				case "btnSiguientePago":  controlar.cambiarDePanel(miVentana.pago, miVentana.devolucion);
									      miModelo.misFuncionesDevolucion.Cambios(miModelo.misFuncionesPago.cambios, miVentana);
					resetear();
					break;
				
				case "btnCancelarPago": controlar.cambiarDePanel(miVentana.pago, miVentana.billetes);
					resetear();
					break;

				case "btn500" :  miModelo.misFuncionesPago.SumarDineroPago(500, miVentana);
					break;
					
				case "btn200" :  miModelo.misFuncionesPago.SumarDineroPago(200, miVentana);
					break;
					
				case "btn100" :  miModelo.misFuncionesPago.SumarDineroPago(100, miVentana);
					break;
				
				case "btn50" :  miModelo.misFuncionesPago.SumarDineroPago(50, miVentana);
					break;
				
				case "btn20" :  miModelo.misFuncionesPago.SumarDineroPago(20, miVentana);
					break;
				
				case "btn10" :  miModelo.misFuncionesPago.SumarDineroPago(10, miVentana);
					break;
				
				case "btn5" :   miModelo.misFuncionesPago.SumarDineroPago(5, miVentana);
					break;
				
				case "btn2" :  miModelo.misFuncionesPago.SumarDineroPago(2, miVentana);
					break;
				
				case "btn1" :  miModelo.misFuncionesPago.SumarDineroPago(1, miVentana);
					break;
					
				case "btn050" :  miModelo.misFuncionesPago.SumarDineroPago(0.5f , miVentana);
					break;
				
				case "btn020" :  miModelo.misFuncionesPago.SumarDineroPago(0.2f, miVentana);
					break;
				
				case "btn010" :  miModelo.misFuncionesPago.SumarDineroPago(0.1f, miVentana);
					break;
				
				case "btn005" :  miModelo.misFuncionesPago.SumarDineroPago(0.05f, miVentana);
					break;
				
				case "btn002" :  miModelo.misFuncionesPago.SumarDineroPago(0.02f, miVentana);
					break;
					
				case "btn001" :  miModelo.misFuncionesPago.SumarDineroPago(0.01f, miVentana);
					break;

			}
			
		}
}
