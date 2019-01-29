package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import modelo.LineaAutobus;
import vista.Ventana;

public class ControladorLineas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	ArrayList<LineaAutobus> lineas;
	FuncionesVarias funcionesModelo = new FuncionesVarias();
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	
	
	//Constructor
		public ControladorLineas (Ventana miVentana, ArrayList<LineaAutobus> lineas) {
			
			this.miVentana = miVentana;
			this.lineas = lineas;
			
			miVentana.lineas.btnSiguiente.addActionListener(this);
			miVentana.lineas.btnCancelar.addActionListener(this);
			
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnSiguienteLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.paradas); 
										   break;
				case "btnCancelarLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.billetes); 
										  break;
	
			}
			
		}

}
