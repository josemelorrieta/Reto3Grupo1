package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

public class ControladorBilletes implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorBilletes (Ventana miVentana) {
			
			this.miVentana = miVentana;
			
			miVentana.billetes.btnComprarBillete.addActionListener(this);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnComprarBilleteBilletes": funciones.irDesdeBilletesALineas(miVentana);  break;
	
			}
			
		}

}
