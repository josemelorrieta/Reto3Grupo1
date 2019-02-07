package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import modelo.Billete;
import modelo.Modelo;
import vista.Ventana;

/**
 * Clase ControladorBilletes. Muestra un resumen de los billetes del cliente que ha iniciado la sesion
 *
 */
public class ControladorBilletes implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();

	private Ventana miVentana;
	private Modelo miModelo;
	
	
	/**
	 * Constructor de  la clase ControladorBilletes
	 * @param miVentana instancia de la ventana principal del programa
	 * @param miModelo instacia del modelo donde se encuentran las funciones para el panel
	 */
	public ControladorBilletes (Ventana miVentana, Modelo miModelo) {  
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		//Define los listeners de los botones del panel
		miVentana.billetes.btnComprarBillete.addActionListener(this);
		miVentana.billetes.btnCerrarSesion.addActionListener(this);	 		

	}
	
	/**
	 * Metodo para resetear los valores de la ventana todos los billetes comprados 
	 */
		public void resetear() {
			miVentana.billetes.modeloMostrarBilletes.removeAllElements();
		}
	
	/**
	 * Metodo para actualizar y añadir los billetes comprados en la ventana de todos los billetes comprados
	 * @param billetes array de los billetes del cliente actual
	 */
		public void actualizarBilletes(Billete[] billetes) { 
			//Declaración e inicialización de variables
			
			//Inicio del programa
			//Borrar el panel de billetes para refrescarlo
			miVentana.billetes.modeloMostrarBilletes.removeAllElements();
			//En el caso de que no existan billetes ponemos un mensaje, si existen se muestran los billetes 
			if (billetes == null) {
				miVentana.billetes.modeloMostrarBilletes.addElement("No hay billetes");
			} else {
				for (int i=0;i<billetes.length;i++) {
					miVentana.billetes.modeloMostrarBilletes.addElement(String.format("%-30s%-30s%15s", billetes[i].getOrigen(), billetes[i].getDestino(), billetes[i].getFecha()));
				}
			}
			//Se le pasa el modelo a la lista para que los muestre
			miVentana.billetes.MostrarBilletes.setModel(miVentana.billetes.modeloMostrarBilletes);
		}
		
	/**
	 * Metodo para las llamadas a los botones de la ventana todos los billetes comprados	
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Dependiendo del boton del que venga la accion hacemos lo que corresponda
		switch (((JButton) e.getSource()).getName()) {
			case "btnComprarBilleteBilletes": funciones.cambiarDePanel(miVentana.billetes, miVentana.lineas);
				break;
										 	  
			case "btnCerrarSesionBilletes": funciones.cambiarDePanel(miVentana.billetes, miVentana.login);
				resetear();
				break;

		}
		
	}	

}