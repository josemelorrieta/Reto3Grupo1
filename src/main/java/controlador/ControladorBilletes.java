package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.JButton;
import modelo.Billete;
import vista.Ventana;


/**
 * Clase ControladorBilletes. Muestra un resumen de los billetes del cliente que ha iniciado la sesion
 *
 */
public class ControladorBilletes implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();

	private Ventana miVentana;
	
	
	/**
	 * Constructor de  la clase ControladorBilletes
	 * @param miVentana instancia de la ventana principal del programa
	 * @param miModelo instacia del modelo donde se encuentran las funciones para el panel
	 */
	public ControladorBilletes (Ventana miVentana) {   
		
		this.miVentana = miVentana;
		
		
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
			Date fechaHoy = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfOut = new SimpleDateFormat("dd/MM/yyyy");
			int cont = 0;
			
			//Inicio del programa
			//Borrar el panel de billetes para refrescarlo
			miVentana.billetes.modeloMostrarBilletes.removeAllElements();
			miVentana.billetes.modeloMostrarBilletes.addElement(String.format("%5s%2s%-55s%-10s", "NUM", " ", "TRAYECTO", "FECHA"));
			miVentana.billetes.modeloMostrarBilletes.addElement(String.format("%5s%2s%-55s%-10s", "---", " ", "--------", "-----"));
			//En el caso de que no existan billetes ponemos un mensaje, si existen se muestran los billetes 
			if (billetes != null) {
				cont = 0;
				for (int i=0;i<billetes.length;i++) {
					//Filtrar billetes de fecha posterior a hoy
					try {
						if (sdf.parse(billetes[i].getFecha()).compareTo(fechaHoy) >= 0 ) {
							miVentana.billetes.modeloMostrarBilletes.addElement(String.format("%2s%03d%2s%-55s%10s", " ", billetes[i].getNumBillete(), " ", billetes[i].getOrigen() + " - " + billetes[i].getDestino(), sdfOut.format(sdf.parse(billetes[i].getFecha()))));
							cont++;
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			if (billetes == null || cont == 0) {
				miVentana.billetes.modeloMostrarBilletes.addElement("   No hay billetes");
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