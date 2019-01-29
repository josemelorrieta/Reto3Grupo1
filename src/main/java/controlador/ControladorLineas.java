package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.Modelo;
import modelo.LineaAutobus;
import vista.Ventana;

public class ControladorLineas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	
	
	//Constructor
		public ControladorLineas (Ventana miVentana, ArrayList<LineaAutobus> lineas) {
			
			this.miVentana = miVentana; 
			
			miVentana.lineas.btnSiguiente.addActionListener(this);
			miVentana.lineas.btnCancelar.addActionListener(this);
	
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnSiguienteLineas": funciones.irDesdeLineasAParadas(miVentana);  break;
				case "btnCancelarLineas": funciones.irDesdeLineasABilletes(miVentana);  break;
	
			}
			
		}

}
