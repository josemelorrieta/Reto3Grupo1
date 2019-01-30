package controlador;



import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Ventana;


public class FuncionesControlador {
	
	private static NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
	float dineroPagado = 0;
	float total = 2000;
	float restante = 0;
	float cambios = 0;
	
	public void cambiarDePanel(JPanel ocultar, JPanel mostrar) { 
		ocultar.setVisible(false);
		mostrar.setVisible(true);
	}
	
	
	public void SumarRestarDineroPago(float valor, Ventana miVentana ) {

		
		
		dineroPagado = dineroPagado + valor;
		
		restante = total - dineroPagado;
		

		miVentana.pago.pagado.setText(formatoMoneda.format(dineroPagado));
		miVentana.pago.restante.setText(formatoMoneda.format(restante));
		miVentana.pago.total.setText(formatoMoneda.format(total));
		
		if (restante<=0) {
			miVentana.pago.restante.setText(formatoMoneda.format(0));
			DesBotones(miVentana.pago.arrayBtn);
			ActBotones(miVentana.pago.btnSiguiente);
			
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
	
	public void ActBotones(JButton boton) {   
			boton.setEnabled(true);
		
	}
	
	public int[] Cambios(float dinero) {
		int euros = (int) dinero;
		int decimales = Math.round((dinero - euros) * 100);
		int[] billetesMonedas = {500, 200, 100, 50, 20, 10, 5, 2, 1};
		int[] cambios = new int[15];
		
		for (int i = 0, f = 0, fake = 1; i < billetesMonedas.length + fake; i++, f++) {
			//Mira si tiene que pasar a calcular los decimales
			if (f == 9) {
				i = 3;
				fake = 0;
			}
			//Calcula los euros
			if (euros >= billetesMonedas[i] && f < 9) {
				cambios[f] = (int) (euros / billetesMonedas[i]);
				euros = euros % billetesMonedas[i];
			}
			//Calcula los centimos si ha acabado con los euros
			else if (decimales >= billetesMonedas[i] && f >= 9) {
				cambios[f] = (int) ((billetesMonedas[i]/100f) + (decimales / billetesMonedas[i]));
				decimales = decimales % billetesMonedas[i];
			}
		}
		
		return cambios;
	}

}
