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
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasPago": funciones.irDesdePagoABilleteComprado(miVentana);  break;
				case "btnSiguientePago": funciones.irDesdePagoADevolucion(miVentana);  break;
				case "btnCancelarPago": funciones.irDesdePagoABilletes(miVentana);  break;
	
			}
			
		}

}
