package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;


import vista.Ventana;

public class ControladorFechas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	PropertyChangeListener changeListener;
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorFechas (Ventana miVentana) {  
			
			this.miVentana = miVentana;
			
			miVentana.fechas.btnAtras.addActionListener(this);
			miVentana.fechas.btnSiguiente.addActionListener(this);
			miVentana.fechas.btnCancelar.addActionListener(this);
			miVentana.fechas.btnRadioButton.addActionListener(this);
			miVentana.fechas.dateIda.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {	        
					@Override
					public void propertyChange(PropertyChangeEvent arg0) {
						// TODO Auto-generated method stub
						establecerFechasVuelta();
					}
					
				});
	
		}
		
		public void resetear() {
			miVentana.fechas.btnRadioButton.setSelected(false); 
			miVentana.fechas.textPrecio.setText("");
		}

		public void setFechasDisponibles() {
			// Definicion e inicializacion de variables
			//Añade tres dias a la fecha de hoy
			Date fechaHoy = new Date();
			Date fechaLimite;
			Calendar calendar = Calendar.getInstance();
			
			//Inicio del programa
			calendar.setTime(fechaHoy);
			calendar.add(Calendar.DATE, 3);
			fechaLimite = calendar.getTime();
			//Establece la fecha límite de tres días a partir de hoy
			miVentana.fechas.dateIda.setSelectableDateRange(fechaHoy, fechaLimite);
			
		}
		
		public void establecerFechasVuelta() {
			//Definicion e inicialización de variables
			
			//Inicio del programa
			System.out.println("Entró");
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==miVentana.fechas.btnRadioButton)
			{	
				if(miVentana.fechas.btnRadioButton.isSelected()) 
				{
					miVentana.fechas.dateVuelta.setEnabled(true);
				}
				else {
					miVentana.fechas.dateVuelta.setEnabled(false);
				}
				
			} else if (e.getSource()==miVentana.fechas.dateIda) {
				
			} else {	
				switch (((JButton) e.getSource()).getName()) {
					case "btnAtrasFechas": funciones.cambiarDePanel(miVentana.fechas, miVentana.paradas);
										   resetear();
										   break;
										   
					case "btnSiguienteFechas":  funciones.cambiarDePanel(miVentana.fechas, miVentana.billeteComprado);
												setFechasDisponibles();
												break;
					
					case "btnCancelarFechas": funciones.cambiarDePanel(miVentana.fechas, miVentana.billetes);
											  resetear();
											  break;
				}
			}	
		}

}