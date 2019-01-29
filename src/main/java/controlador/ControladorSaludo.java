package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Ventana;

public class ControladorSaludo implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	private Ventana miVentana;
	
	//Constructor
		public ControladorSaludo( Ventana miVentana) {
			
			this.miVentana = miVentana;
			
			miVentana.saludo.btnSaludo.addActionListener(this);
			 
		} 

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnSaludo": funciones.cambiarDePanel(miVentana.saludo, miVentana.login); break;
			
			}
			
		}

}
