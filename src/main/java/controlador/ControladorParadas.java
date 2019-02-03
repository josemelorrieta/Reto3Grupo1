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

public class ControladorParadas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	ArrayList<Parada> paradas;
	FuncionesVarias funcionesModelo = new FuncionesVarias();
	
	private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	Date fechaHoy = new Date();
	Date fechaLimite = new Date();
	
	//Constructor
		public ControladorParadas (Controlador miControlador, Ventana miVentana, Modelo miModelo,  ArrayList<Parada> paradas, ArrayList<LineaAutobus> lineas) { 
			this.miControlador = miControlador;
			this.miVentana = miVentana;
			this.miModelo = miModelo;
			this.paradas = paradas;
			
			miVentana.paradas.btnAtras.addActionListener(this);
			miVentana.paradas.btnSiguiente.addActionListener(this);
			miVentana.paradas.btnCancelar.addActionListener(this);
			
			
			
		}
		
		public void cargarBotones() {
			String[] nombreParadas = funcionesModelo.consultaColumnaString("select distinct parada.nombre from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like 'L1' ;", "nombre");
			miVentana.paradas.ParadaDeOrigen.setModel(new DefaultComboBoxModel(nombreParadas));
			miVentana.paradas.ParadaDeDestino.setModel(new DefaultComboBoxModel(nombreParadas));
			
		}
		
	//Metodo para resetear los valores de la ventana paradas
		public void resetear() {
			miVentana.paradas.textFieldMostrarLinea.setText("");
		}

	//Metodo para las llamadas a los botones de la ventana paradas
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.lineas);
					resetear();
					break;
										
				case "btnSiguienteParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.fechas);
					miVentana.fechas.dateIda.setDate(null);
					miVentana.fechas.dateVuelta.setDate(null);
					fechaLimite = miModelo.misFuncionesFechas.setFechasDisponibles(fechaHoy);
					miVentana.fechas.dateIda.setSelectableDateRange(fechaHoy, fechaLimite);
					break;
				
				case "btnCancelarParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.billetes);
					miModelo.paradas = funcionesModelo.cargarParadas(paradas, "L1");
					resetear(); 
					break;
										   
	
			}			
		}

}
