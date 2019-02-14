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
		
		String infoBilleteIda = String.format("%-40s%-40s%10s%10s", origenIda, destinoIda, fechaIda, formatoMoneda.format(precioIda));
		//Inicio del programa		
		miVentana.billeteComprado.txtIda.setText(infoBilleteIda);
		miVentana.billeteComprado.lblPrecioTotal.setText(formatoMoneda.format(precioIda));
		
		if (billeteVuelta != null) {
			//Decalracion e inicializacion de variables
			String fechaVuelta = billeteVuelta.getFecha();
			String origenVuelta = billeteVuelta.getOrigen();
			String destinoVuelta = billeteVuelta.getDestino();
			double precioVuelta = billeteVuelta.getPrecioTrayecto();
			
			//Inicio del programa
			String infoBilleteVuelta = String.format("%-40s%-40s%10s%10s", origenVuelta, destinoVuelta, fechaVuelta, formatoMoneda.format(precioVuelta));
			miVentana.billeteComprado.txtVuelta.setEnabled(true);
			miVentana.billeteComprado.txtVuelta.setText(infoBilleteVuelta);
			miVentana.billeteComprado.lblPrecioTotal.setText(formatoMoneda.format(precioIda + precioVuelta));
		}
	}

}
