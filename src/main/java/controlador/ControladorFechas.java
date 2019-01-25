package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import vista.Ventana;

public class ControladorFechas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorFechas (Ventana miVentana) {
			
			this.miVentana = miVentana;
			
			miVentana.fechas.btnCancelar.addActionListener(this);
			miVentana.fechas.btnSiguiente.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnCancelarFechas": funciones.irDesdeFechasAParadas(miVentana);  break;
				case "btnSiguienteFechas": funciones.irDesdeFechasABilleteComprado(miVentana);  break;
	
			}
			
		}

}
