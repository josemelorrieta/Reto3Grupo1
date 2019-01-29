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
					
				case "btn500" : funciones.SumarRestarDineroPago((JButton) e.getSource(), miVentana);
					break;
	
			}
			
		}

}
