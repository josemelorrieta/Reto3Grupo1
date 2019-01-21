package controlador;

import java.text.DecimalFormat;

public class DatosPrecio {

	/**
	 * Iva que se le aplica a los productos
	 */
	public final static float IVA = 1.21f;
	public final static float precioGasolina = 1.8f;
	public final static float beneficio = 1.2f;
	

	/**
	 * Indica al decimal format como se quiere formatear los numeros
	 * @param dosDec 	DecimalFormat para modificar su pattern
	 */
	public void dosDecFormato(DecimalFormat dosDec) {
		dosDec.setMinimumFractionDigits(2);
		dosDec.setGroupingSize(300);
	}
}
