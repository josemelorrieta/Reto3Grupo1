package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;


import vista.Ventana;

public class ControladorFechas implements ActionListener {
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	FuncionesControlador funciones = new FuncionesControlador();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	Date fechaIda = null;
	
	//Constructor
		public ControladorFechas (Ventana miVentana) {  
			
			this.miVentana = miVentana; 
			
			miVentana.fechas.btnAtras.addActionListener(this);
			miVentana.fechas.btnSiguiente.addActionListener(this);
			miVentana.fechas.btnCancelar.addActionListener(this);
			miVentana.fechas.btnRadioButton.addActionListener(this);
			miVentana.fechas.dateIda.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
		    	@Override
		        public void propertyChange(PropertyChangeEvent e) {
		    		fechaIda = miVentana.fechas.dateIda.getDate();
		    		if (fechaIda != null) { 
		    			miVentana.fechas.dateVuelta.setDate(null);
		    			establecerFechasVuelta(fechaIda);
		    		}
	            }
	        });
			miVentana.fechas.add(miVentana.fechas.dateIda);
		}
		
	//Metodo para resetear los valores de la ventana fechas
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
		
		public void establecerFechasVuelta(Date fechaIda) {
			//Definicion e inicialización de variables
			Calendar calendar = Calendar.getInstance();
			Date fechaLimiteVuelta;
			
			//Inicio del programa
			calendar.setTime(fechaIda);
			calendar.add(Calendar.DATE, 3);
			fechaLimiteVuelta = calendar.getTime();
			miVentana.fechas.dateVuelta.setSelectableDateRange(fechaIda, fechaLimiteVuelta);
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
					miVentana.fechas.dateVuelta.setDate(null);
				}
				
			} else {	
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