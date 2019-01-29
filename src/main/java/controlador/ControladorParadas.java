package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import modelo.LineaAutobus;
import modelo.Parada;
import vista.Ventana;

public class ControladorParadas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	ArrayList<Parada> paradas;
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorParadas (Ventana miVentana,  ArrayList<Parada> paradas) { 
			
			this.miVentana = miVentana;
			this.paradas = paradas;
			
			miVentana.paradas.btnAtras.addActionListener(this);
			miVentana.paradas.btnSiguiente.addActionListener(this);
			miVentana.paradas.btnCancelar.addActionListener(this);
			
		} 

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasParadas": funciones.irDesdeParadasALineas(miVentana); 
					miVentana.paradas.textFieldMostrarLinea.setText("");
					break;
				case "btnSiguienteParadas": funciones.irDesdeParadasAFechas(miVentana);  
					break;
				case "btnCancelarParadas": funciones.irDesdeParadasABilletes(miVentana); 
					miVentana.paradas.textFieldMostrarLinea.setText("");
					break;
	
			}			
		}

}
