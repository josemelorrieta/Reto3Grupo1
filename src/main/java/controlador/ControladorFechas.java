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

/**
 * Clase que controla el panel de eleccion de fechas para el billete a comprar
 *
 */
public class ControladorFechas implements ActionListener {
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	FuncionesControlador funciones = new FuncionesControlador();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	Date fechaIda = null;
	Date fechaLimite = null;
	
	/**
	 * Constructor de la clase de eleccion de fechas
	 * @param miVentana instancia de la ventana principal
	 * @param miModelo instacia del modelo para poder acceder a las funciones
	 */
	public ControladorFechas (Ventana miVentana, Modelo miModelo) {  
		
		this.miVentana = miVentana; 
		this.miModelo = miModelo;
		
		//Definicion de listeners para los distintos elementos del panel
		miVentana.fechas.btnAtras.addActionListener(this);
		miVentana.fechas.btnSiguiente.addActionListener(this);
		miVentana.fechas.btnCancelar.addActionListener(this);
		miVentana.fechas.btnRadioButton.addActionListener(this);
		miVentana.fechas.dateIda.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
	    	@Override
	        public void propertyChange(PropertyChangeEvent e) {
	    		actualizarFechaVuelta();
            }
        });
		miVentana.fechas.add(miVentana.fechas.dateIda);
	}
		
	/**
	 * Metodo para resetear los valores de la ventana fechas
	 */
	public void resetear() {
		miVentana.fechas.btnRadioButton.setSelected(false); 
		miVentana.fechas.textPrecio.setText("");
	}
	
	/**
	 * Definicion de la accion de cada boton del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Si la accion viene del radio button
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
		//si la accion viene de algun boton
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

	public void actualizarFechaVuelta() {
		fechaIda = miVentana.fechas.dateIda.getDate();
		if (fechaIda != null) { 
			miVentana.fechas.dateVuelta.setDate(null);
			fechaLimite = miModelo.misFuncionesFechas.setFechasDisponibles(fechaIda);
			miVentana.fechas.dateVuelta.setSelectableDateRange(fechaIda, fechaLimite);
		}

		//Seleccionar autobus disponible para la ida
	}
}