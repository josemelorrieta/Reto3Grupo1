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
			
<<<<<<< HEAD
		}
		
		public void resetear() {
			miVentana.paradas.textFieldMostrarLinea.setText("");
		}
=======
		} 
>>>>>>> 8805004b2ef86a95025cb76d414e6cea7dad47af

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
<<<<<<< HEAD
				case "btnAtrasParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.lineas);
										resetear();
										break;
										
				case "btnSiguienteParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.fechas); 
											break;
				
				case "btnCancelarParadas": funciones.cambiarDePanel(miVentana.paradas, miVentana.billetes);
										   resetear(); 
										   break;
=======
				case "btnAtrasParadas": funciones.irDesdeParadasALineas(miVentana); 
					miVentana.paradas.textFieldMostrarLinea.setText("");
					break;
				case "btnSiguienteParadas": funciones.irDesdeParadasAFechas(miVentana);  
					break;
				case "btnCancelarParadas": funciones.irDesdeParadasABilletes(miVentana); 
					miVentana.paradas.textFieldMostrarLinea.setText("");
					break;
>>>>>>> 8805004b2ef86a95025cb76d414e6cea7dad47af
	
			}			
		}

}
