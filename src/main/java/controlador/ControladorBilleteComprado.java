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

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasBilleteComprado": funciones.irDesdeBilleteCompradoAFechas(miVentana);  
												miVentana.billeteComprado.modeloMostrarBilletesComprado.removeAllElements();
												break;
												
				case "btnSiguienteBilleteComprado": funciones.irDesdeBilleteCompradoAPago(miVentana);  break;
				
				case "btnCancelarBilleteComprado":  funciones.irDesdeBilleteCompradoABilletes(miVentana);  
													miVentana.billeteComprado.modeloMostrarBilletesComprado.removeAllElements();
													break;
	
			}
			
		}
}