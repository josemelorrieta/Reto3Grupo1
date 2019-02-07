package modelo;

import java.text.NumberFormat;
import java.util.Locale;

import vista.Ventana;

/**
 * Clase que contiene los metodos del panel de billete comprado
 *
 */
public class FuncionesBilleteComprado {
	
	/**
	 * Metodo que muestra los billetes seleccionados en la pantalla de billetes comprados
	 * @param billeteIda Billete de ida
	 * @param billeteVuelta Billete de vuelta
	 * @param miVentana Instancia de la ventana principal
	 */
	public void resumenBilleteComprado(Billete billeteIda, Billete billeteVuelta, Ventana miVentana) {
		//Declaración e inicialización de variables
		String fechaIda = billeteIda.getFecha();
		String origenIda = billeteIda.getOrigen();
		String destinoIda = billeteIda.getDestino();
		double precioIda = billeteIda.getPrecioTrayecto();
		
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
		
		String infoBillete = String.format("%-40s%-40s%15s%10s", origenIda, destinoIda, fechaIda, formatoMoneda.format(precioIda));
		//Inicio del programa
		miVentana.billeteComprado.modeloMostrarBilletesComprado.addElement(infoBillete);
		miVentana.billeteComprado.listBilleteComprado.setModel(miVentana.billeteComprado.modeloMostrarBilletesComprado);
		
		
		if (billeteVuelta != null) {
			
		}
	}
	
	public boolean guardarBilleteBD(Billete billete) {
		//Declaración e inicializacion de variables
		
		//Inicio del programa
		
		return false;
	}

}
