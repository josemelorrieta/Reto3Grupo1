package modelo;

/**
 * Clase con las funciones del panel de pago
 *
 */
public class FuncionesPago {
	/**
	 * Metodo para sumar la cantidad de dinero de los botones de la ventana pago y muestra el total de dinero metido
	 * @param valor String con la cantidad del billete o moneda selecionado por el usuario
	 * @param pagado Double dinero pagado por el cliente
	 * 
	 * @return pagado Double con el dinero pagado actualizado
	 */
	public double sumarDineroPago(String valor, double pagado) {
		//Declaracion e inicializacion de variables

		//Inicio del programa
		pagado = pagado + Double.parseDouble(valor);

		return pagado;
			
	}
}
 