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
			
			miVentana.fechas.btnAtras.addActionListener(this);
			miVentana.fechas.btnSiguiente.addActionListener(this);
			miVentana.fechas.btnCancelar.addActionListener(this);
			miVentana.fechas.btnRadioButton.addActionListener(this); 
	
		}
		
		public void resetear() {
			miVentana.fechas.btnRadioButton.setSelected(false); 
			  miVentana.fechas.textPrecio.setText("");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==miVentana.fechas.btnRadioButton)
			{	
				if(miVentana.fechas.btnRadioButton.isSelected()) 
				{
				miVentana.fechas.FechaDeVuelta.setEnabled(true);
				}
				else {
				miVentana.fechas.FechaDeVuelta.setEnabled(false);
				}
				
			}
			else {	
				switch (((JButton) e.getSource()).getName()) {
					case "btnAtrasFechas": funciones.cambiarDePanel(miVentana.fechas, miVentana.paradas);
										   resetear();
										   break;
										   
					case "btnSiguienteFechas":  funciones.cambiarDePanel(miVentana.fechas, miVentana.billeteComprado);
												break;
					
					case "btnCancelarFechas": funciones.cambiarDePanel(miVentana.fechas, miVentana.billetes);
											  resetear();
											  break;
				}
			}	
		}

}