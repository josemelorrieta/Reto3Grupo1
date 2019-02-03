package modelo;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;

import controlador.DatosPrecio;
import vista.Ventana;

/**
 * Clase con las funciones del panel de pago
 *
 */
public class FuncionesPago {

	static DatosPrecio datos = new DatosPrecio();
	
	/**
	 * Metodo que calcula el precio segun la distancia del billete
	 * @param distancia distancia en km entre origen y destino
	 * @return precio del billete
	 */
	public float CalcularPrecio(float distancia) {
		//Declaracion e inicializacion de variables
		float precio = 0;
		
		//Inicio del programa
		return precio = (distancia * datos.precioGasolina * datos.beneficio * datos.IVA);
	}
	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	public float dineroPagado = 0;
	public float total = 2000;
	public float restante = 0;
	public float cambios = 0;

	/**
	 * Metodo para sumar la cantidad de dinero de los botones de la ventana pago y muestra el total de dinero metido
	 * @param valor cantidad del billete o moneda selecionado por el usuario
	 * @param miVentana instancia de la ventana principal
	 */
	public void SumarDineroPago(float valor, Ventana miVentana ) {

		
		
		dineroPagado = dineroPagado + valor;
		
		restante = total - dineroPagado;
		

		miVentana.pago.pagado.setText(formatoMoneda.format(dineroPagado));
		miVentana.pago.restante.setText(formatoMoneda.format(restante));
		miVentana.pago.total.setText(formatoMoneda.format(total));
		
		if (restante<=0) {
			miVentana.pago.restante.setText(formatoMoneda.format(0));
			DesBotones(miVentana.pago.arrayBtn);
			ActBotones(miVentana.pago.btnSiguiente);
			DesBotones(miVentana.pago.btnCancelar);
			DesBotones(miVentana.pago.btnAtras);
					
			cambios = dineroPagado - total;
			
		}
		else {
			miVentana.pago.restante.setText(formatoMoneda.format(restante));
			
		}
	}
	
    /**
     * Metodo que desactiva todos los botones de dinero de la ventana pago
     * @param array de botones a desactivar 
     */
	public void DesBotones(JButton[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(false);
		}
	}

	/**
	 * Metodo que activa todos los botones de dinero de la ventana pago
	 * @param array array de botones a activar
	 */
	public void ActBotones(JButton[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(true);
		}
	}
	
	/**
	 * Metodo que activa el boton que se desee de las ventanas
	 * @param boton a activar
	 */
	public void ActBotones(JButton boton) {   
			boton.setEnabled(true);
		 
	}
	
	/**
	 * Metodo que desactiva el boton que se desee de las ventanas
	 * @param boton a desactivar
	 */
	public void DesBotones(JButton boton) {   
		boton.setEnabled(false);
	
	}

}
