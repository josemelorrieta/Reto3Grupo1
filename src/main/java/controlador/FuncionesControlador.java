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
	
	public void cambiarDePanel(JPanel ocultar, JPanel mostrar) { 
		ocultar.setVisible(false);
		mostrar.setVisible(true);
	}
	
	
	public void SumarRestarDineroPago(float valor, Ventana miVentana ) {
	
		float restar;
		
		
		dineroPagado = dineroPagado + valor;
		
		total = total-dineroPagado;

		miVentana.pago.pagado.setText(formatoMoneda.format(dineroPagado));
		miVentana.pago.total.setText(formatoMoneda.format(total));
		
		if (total<=0) {
			DesBotones(miVentana.pago.arrayBtn);
			ActBotones(miVentana.pago.btnSiguiente);
			
		}
		else {
			miVentana.pago.total.setText(formatoMoneda.format(total));
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

}
