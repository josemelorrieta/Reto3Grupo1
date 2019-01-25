package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

public class ControladorParadas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorParadas (Ventana miVentana) {
			
			this.miVentana = miVentana;
			
			miVentana.paradas.btnCancelar.addActionListener(this);
			miVentana.paradas.btnSiguiente.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnCancelarParadas": funciones.irDesdeParadasALineas(miVentana);  break;
				case "btnSiguienteParadas": funciones.irDesdeParadasAFechas(miVentana);  break;
	
			}
			
		}

}
