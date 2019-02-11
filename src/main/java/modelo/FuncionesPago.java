package modelo;

/**
 * Clase con las funciones del panel de pago
 *
 */
public class FuncionesPago {
	/**
	 * Metodo para sumar la cantidad de dinero de los botones de la ventana pago y muestra el total de dinero metido
	 * @param valor cantidad del billete o moneda selecionado por el usuario
	 * @param miVentana instancia de la ventana principal
	 */
	public double sumarDineroPago(/*double valor*/ String valor, double pagado) {
		//Declaracion e inicializacion de variables

		//Inicio del programa
		pagado = pagado + Double.parseDouble(valor);

		return pagado;
			
	}
}
