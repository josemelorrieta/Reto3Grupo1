package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;

import modelo.Modelo;
import vista.Ventana;

public class ControladorFechas implements ActionListener {
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	FuncionesControlador funciones = new FuncionesControlador();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	Date fechaIda = null;
	Date fechaLimite = null;
	
	//Constructor
		public ControladorFechas (Ventana miVentana, Modelo miModelo) {  
			
			this.miVentana = miVentana; 
			this.miModelo = miModelo;
			
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
		    			fechaLimite = miModelo.misFuncionesFechas.setFechasDisponibles(fechaIda);
		    			miVentana.fechas.dateVuelta.setSelectableDateRange(fechaIda, fechaLimite);
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