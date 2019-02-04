package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

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
	ArrayList<Parada> paradas;
	FuncionesVarias funcionesModelo = new FuncionesVarias();
	
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
	public ControladorParadas (Controlador miControlador, Ventana miVentana, Modelo miModelo,  ArrayList<Parada> paradas, ArrayList<LineaAutobus> lineas) { 
		this.miControlador = miControlador;
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		this.paradas = paradas;
		
		//Definicion de los listeners de los botones del panel
		miVentana.paradas.btnAtras.addActionListener(this);
		miVentana.paradas.btnSiguiente.addActionListener(this);
		miVentana.paradas.btnCancelar.addActionListener(this);
		
	}

	
	//ESTO TIENE QUE IR EN EL MODELO, EN LAS FUNCIONES PARA ESTE PANEL --> REFACTORIZAR
	public void cargarBotones() {
		String[] nombreParadas = funcionesModelo.consultaColumnaString("select distinct parada.nombre from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like 'L1' ;", "nombre");
		miVentana.paradas.ParadaDeOrigen.setModel(new DefaultComboBoxModel(nombreParadas));
		miVentana.paradas.ParadaDeDestino.setModel(new DefaultComboBoxModel(nombreParadas));
		
	}

		
	/**
	 * Metodo para resetear los valores de la ventana paradas
	 */
	public void resetear() {
		miVentana.paradas.textFieldMostrarLinea.setText("");
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
									
			case "btnSiguienteParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.fechas);
				//borrar las fechas del panel siguiente (nuevo billete)
				miVentana.fechas.dateIda.setDate(null);
				miVentana.fechas.dateVuelta.setDate(null);
				//Establecer fechas posibles de compra en tres dias a partir de hoy 
				fechaLimite = miModelo.misFuncionesFechas.setFechasDisponibles(fechaHoy);
				miVentana.fechas.dateIda.setSelectableDateRange(fechaHoy, fechaLimite);
				//Cargamos el origen y el destino en el billete
				String parada1 = miVentana.paradas.ParadaDeOrigen.getSelectedItem().toString();
				String parada2 = miVentana.paradas.ParadaDeDestino.getSelectedItem().toString();
				miModelo.billetes[0].setOrigen(parada1);
				miModelo.billetes[0].setDestino(parada2);
				break;
			
			case "btnCancelarParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.billetes);
				miModelo.paradas = funcionesModelo.cargarParadas(paradas, "L1");
				resetear(); 
				break;
		}			
	}

}
