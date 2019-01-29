package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

public class ControladorBilleteComprado implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorBilleteComprado (Ventana miVentana) { 
			
			this.miVentana = miVentana;
			
			miVentana.billeteComprado.btnAtras.addActionListener(this);
			miVentana.billeteComprado.btnSiguiente.addActionListener(this);
			miVentana.billeteComprado.btnCancelar.addActionListener(this); 
			
		}
		
		public void resetear() {
			miVentana.billeteComprado.modeloMostrarBilletesComprado.removeAllElements();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
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
