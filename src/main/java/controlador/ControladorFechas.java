package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
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
    			if (e.getPropertyName() == "date" && miVentana.fechas.dateIda.getDate() != null) {
    				actualizarFechaVuelta();
    				calcularPrecioBillete();
    			}
            }
        });
		//miVentana.fechas.add(miVentana.fechas.dateIda);
		miVentana.fechas.dateVuelta.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
	    	@Override
	        public void propertyChange(PropertyChangeEvent e1) {
    			if (e1.getPropertyName() == "date" && miVentana.fechas.dateVuelta.getDate() != null) {
    				calcularPrecioBillete();
    			}
            }
        });
	}
		
	/**
	 * Metodo para resetear los valores de la ventana fechas
	 */
	public void resetear() {
		miVentana.fechas.btnRadioButton.setSelected(false);
		miModelo.billeteVuelta = null;
		miVentana.fechas.dateVuelta.setEnabled(false);
		miVentana.fechas.textPrecio.setText("");
		miVentana.fechas.btnSiguiente.setEnabled(false);
	}
	
	/**
	 * Definicion de la accion de cada boton del panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Si la accion viene del radio button
		if(e.getSource()==miVentana.fechas.btnRadioButton)
		{	
			if (miVentana.fechas.dateIda.getDate() != null) {
				if(miVentana.fechas.btnRadioButton.isSelected()) 
				{
					miVentana.fechas.dateVuelta.setEnabled(true);
					//Crear el billete de vuelta para la compra actual
					String codLinea = miModelo.billeteIda.getCodLinea();
					miModelo.billeteVuelta = miModelo.misFuncionesModelo.crearBilleteActual(miModelo, codLinea);
				}
				else {
					//Borramos el billete de vuelta
					miModelo.billeteVuelta = null;
					calcularPrecioBillete();
					miVentana.fechas.dateVuelta.setEnabled(false);
					miVentana.fechas.dateVuelta.setDate(null);
				}
			} else {
				JOptionPane.showMessageDialog(miVentana, "Debe elegir una fecha de ida primero", "¡Atención!", JOptionPane.WARNING_MESSAGE);
				miVentana.fechas.btnRadioButton.setSelected(false);
			}
		//si la accion viene de algun boton
		} else {	
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasFechas": funciones.cambiarDePanel(miVentana.fechas, miVentana.paradas);
					resetear();
					break;
									   
				case "btnSiguienteFechas": 
					if (miVentana.fechas.btnRadioButton.isSelected() && miVentana.fechas.dateVuelta.getDate() == null) {
						JOptionPane.showMessageDialog(miVentana, "Falta la fecha de vuelta. Elija una o elija solo ida.", "¡Atención!", JOptionPane.WARNING_MESSAGE);
					} else {
						funciones.cambiarDePanel(miVentana.fechas, miVentana.billeteComprado);
						miModelo.misFuncionesBilleteComprado.resumenBilleteComprado(miModelo.billeteIda, miModelo.billeteVuelta, miVentana);
					}
					break;
				
				case "btnCancelarFechas": funciones.cambiarDePanel(miVentana.fechas, miVentana.billetes);
					//resetear();
					break;
			}
		}	
	}

	/**
	 * Metodo que actualiza el rango de la fecha de vuelta al seleccionar la fecha de ida
	 */
	public void actualizarFechaVuelta() {
		fechaIda = miVentana.fechas.dateIda.getDate();
		if (fechaIda != null) { 
			miVentana.fechas.dateVuelta.setDate(null);
			fechaLimite = miModelo.misFuncionesFechas.setFechasDisponibles(fechaIda);
			miVentana.fechas.dateVuelta.setSelectableDateRange(fechaIda, fechaLimite);
		}
		
	}
	
	/**
	 * Metdodo que calcula el precio del billete con los datos de la compra y actualiza los datos del billete
	 */
	public void calcularPrecioBillete() {
		//Declaración e inicialización de variables
		double distancia = 0;
		int codAutobus = 0;
		double precio = 0;
		
		//Inicio del programa
		//calcular la distancia del recorrido del billete
		miModelo.billeteIda.setFecha(sdf.format(miVentana.fechas.dateIda.getDate()));
		distancia = miModelo.misFuncionesFechas.distanciaRecorrido(miVentana.paradas.paradaDeOrigen.getSelectedItem().toString(), miVentana.paradas.paradaDeDestino.getSelectedItem().toString());
		
		//Seleccionar autobus disponible para la ida
		codAutobus = miModelo.misFuncionesFechas.buscarAutobus(miModelo.billeteIda.getCodLinea(), miModelo.billeteIda.getFecha());
		miModelo.billeteIda.setCodAutobus(codAutobus);
		
		//Calcular el precio del billete según distancia y autobus
		precio = miModelo.misFuncionesFechas.calcularPrecioBillete(codAutobus, distancia);
		miModelo.billeteIda.setPrecioTrayecto(precio);
		if (miModelo.billeteVuelta != null) {
			miModelo.billeteVuelta.setPrecioTrayecto(precio);
			miModelo.billeteVuelta.setFecha(sdf.format(miVentana.fechas.dateVuelta.getDate()));
			miModelo.billeteVuelta.setCodAutobus(codAutobus);
			miModelo.billeteVuelta.setOrigen(miModelo.billeteIda.getDestino());
			miModelo.billeteVuelta.setDestino(miModelo.billeteIda.getOrigen());
			miVentana.fechas.textPrecio.setText(formatoMoneda.format(miModelo.billeteIda.getPrecioTrayecto() + miModelo.billeteVuelta.getPrecioTrayecto()));
		} else {
			miVentana.fechas.textPrecio.setText(formatoMoneda.format(miModelo.billeteIda.getPrecioTrayecto()));
		}
		
		//Activar el botón siguiente
		miVentana.fechas.btnSiguiente.setEnabled(true);
	}
}