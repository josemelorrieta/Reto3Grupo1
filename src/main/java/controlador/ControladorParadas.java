package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import modelo.LineaAutobus;
import modelo.Modelo;
import modelo.Parada;
import vista.Ventana;

/**
 * Clase que controla el panel de eleccion de origen y destino del billete
 *
 */
public class ControladorParadas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	Date fechaHoy = new Date();
	Date fechaLimite = new Date();
	
	
	/**
	 * Constructor de la clase
	 * @param miControlador instancia del controlador para acceder a otros paneles
	 * @param miVentana instancia de la ventana principal
	 * @param miModelo instancia del modelo para acceder a las funciones
	 * @param paradas instancia del array de paradas del modelo
	 * @param lineas instancia del array de lineas
	 */
	public ControladorParadas (Controlador miControlador, Ventana miVentana, Modelo miModelo) { 
		this.miControlador = miControlador;
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		//Definicion de los listeners de los botones del panel
		miVentana.paradas.btnAtras.addActionListener(this);
		miVentana.paradas.btnSiguiente.addActionListener(this);
		miVentana.paradas.btnCancelar.addActionListener(this);
		miVentana.paradas.paradaDeOrigen.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        cambioParadaOrigen();
		    }
		});
	}

	/**
	 * Metodo para resetear los valores de la ventana paradas
	 */
	public void resetear() {
		miVentana.paradas.lblMostrarLinea.setText("");
	}

	/**
	 * Metodo para las llamadas a los botones de la ventana paradas
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Accion dependiendo de que boton venga el evento
		switch (((JButton) e.getSource()).getName()) {
			case "btnAtrasParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.lineas);
				resetear();
				break;
									
			case "btnSiguienteParadas": 
				//Borrar las fechas del panel siguiente (nuevo billete)
				miVentana.fechas.dateIda.setDate(null);
				miVentana.fechas.dateVuelta.setDate(null);
				
				//Establecer fechas posibles de compra en tres dias a partir de hoy 
				fechaLimite = miModelo.misFuncionesFechas.setFechasDisponibles(fechaHoy);
				miVentana.fechas.dateIda.setSelectableDateRange(fechaHoy, fechaLimite);
				
				//Cargamos el origen y el destino en el billete
				miModelo.billeteIda.setOrigen(miVentana.paradas.paradaDeOrigen.getSelectedItem().toString());
				miModelo.billeteIda.setDestino(miVentana.paradas.paradaDeDestino.getSelectedItem().toString());		
				
				funciones.cambiarDePanel(miVentana.paradas, miVentana.fechas);
				break;
				
			case "btnCancelarParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.billetes);
				//miModelo.paradas = funcionesModelo.cargarParadas(paradas, "L1");
				resetear(); 
				break;
		}		
	}
	
	/**
	 * Metodo que filtra las paradas de destino al seleccionar una de origen
	 */
	public void cambioParadaOrigen() {
		//Declaracion e inicializacion de variables
		Parada[] paradasDestino = null;
		
		//Inicio del programa
		miVentana.paradas.modeloDestino.removeAllElements();
		paradasDestino = miModelo.misFuncionesParadas.filtrarParadasDestino(miModelo.paradas, miVentana.paradas.paradaDeOrigen.getSelectedIndex(), paradasDestino);
		for (int i=0;i<paradasDestino.length;i++) {
			miVentana.paradas.modeloDestino.addElement(paradasDestino[i].getNombre());
		}
		miVentana.paradas.paradaDeDestino.setModel(miVentana.paradas.modeloDestino);
		
	}
	
}
