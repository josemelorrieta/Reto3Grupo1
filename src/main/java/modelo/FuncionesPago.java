package modelo;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;

import controlador.DatosPrecio;
import vista.Ventana;

public class FuncionesPago {

	static DatosPrecio datos = new DatosPrecio();
	
	public float CalcularPrecio(float distancia) {
		float precio = 0;
		
		return precio = (distancia * datos.precioGasolina * datos.beneficio * datos.IVA);
	}
	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	public float dineroPagado = 0;
	public float total = 2000;
	public float restante = 0;
	public float cambios = 0;
	
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
	
	public void DesBotones(JButton[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(false);
		}
	}
	
	public void ActBotones(JButton[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(true);
		}
	}
	
	public void ActBotones(JButton boton) {   
			boton.setEnabled(true);
		
	}
	
	public void DesBotones(JButton boton) {   
		boton.setEnabled(false);
	
}
	
	
	

}
