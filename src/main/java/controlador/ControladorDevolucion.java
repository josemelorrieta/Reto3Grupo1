package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Ventana;

public class ControladorDevolucion implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Controlador miControlador;
	
	//Constructor
		public ControladorDevolucion (Ventana miVentana, Controlador miControlador) {
			
			this.miVentana = miVentana;
			this.miControlador =miControlador;
			
			miVentana.devolucion.btnSiguiente.addActionListener(this);

			
		}
		
		public void  resetear() {
			
			miVentana.devolucion.cambios.removeAllElements();
		
		}
		
		
	

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnSiguienteDevolucion": funciones.cambiarDePanel(miVentana.devolucion, miVentana.despedida);
											   miControlador.miControladorDespedida.PasarDeDespedidaASaludo();
											   resetear();
				break;
				
				
				
	
			}
			
		}

}
