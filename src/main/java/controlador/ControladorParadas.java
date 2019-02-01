package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	//Constructor
		public ControladorParadas (Ventana miVentana,  ArrayList<Parada> paradas, ArrayList<LineaAutobus> lineas) { 
			
			this.miVentana = miVentana;
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
		
		public void resetear() {
			miVentana.paradas.textFieldMostrarLinea.setText("");
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.lineas);
					resetear();
					break;
										
				case "btnSiguienteParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.fechas); 
					break;
				
				case "btnCancelarParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.billetes);
					miModelo.paradas = funcionesModelo.cargarParadas(paradas, "L1");
					resetear(); 
					break;
										   
	
			}			
		}

}
