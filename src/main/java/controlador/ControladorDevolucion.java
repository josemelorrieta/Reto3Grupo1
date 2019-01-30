package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

public class ControladorDevolucion implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorDevolucion (Ventana miVentana) {
			
			this.miVentana = miVentana;
			
			
			miVentana.devolucion.btnSiguiente.addActionListener(this);

			
		}
		
	

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnSiguienteDevolucion": funciones.cambiarDePanel(miVentana.devolucion, miVentana.despedida); 
				break;
				
				
				
	
			}
			
		}

}
