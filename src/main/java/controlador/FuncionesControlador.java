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
	
<<<<<<< HEAD
=======
	public void irDesdeSaludoALogin(Ventana miVentana) {
		
		miVentana.saludo.setVisible(false);
		miVentana.login.setVisible(true);		   
		
	}
	
	public void irDesdeLoginASaludo(Ventana miVentana) {
		
		miVentana.saludo.setVisible(true);
		miVentana.login.setVisible(false); 
		
	}
	
	public void irDesdeLoginARegistro (Ventana miVentana) {
		
		miVentana.registro.setVisible(true);
		miVentana.login.setVisible(false);
		
	}
	
	public void irDesdeLoginABilletes (Ventana miVentana) {
		
		miVentana.billetes.setVisible(true);
		miVentana.login.setVisible(false);
	}
	
	public void irDesdeRegistroALogin (Ventana miVentana) {
		
		miVentana.registro.setVisible(false);
		miVentana.login.setVisible(true);
		
		
	}
	
	public void irDesdeBilletesALineas (Ventana miVentana) {
		
		miVentana.billetes.setVisible(false);
		miVentana.lineas.setVisible(true);
		
	}
	
	public void irDesdeLineasAParadas (Ventana miVentana) {
		
		miVentana.paradas.setVisible(true);
		miVentana.lineas.setVisible(false);
		
	}
	
	public void irDesdeLineasABilletes (Ventana miVentana) {
		
		miVentana.billetes.setVisible(true);
		miVentana.lineas.setVisible(false);
		
	}
	
	public void irDesdeParadasALineas (Ventana miVentana) {
		
		miVentana.paradas.setVisible(false);
		miVentana.lineas.setVisible(true);
		
	}
	
	public void irDesdeParadasAFechas (Ventana miVentana) {
		
		miVentana.paradas.setVisible(false);
		miVentana.fechas.setVisible(true);
		
	}
	
	public void irDesdeFechasAParadas (Ventana miVentana) {
		
		miVentana.paradas.setVisible(true);
		miVentana.fechas.setVisible(false);
		
	}

	public void irDesdeFechasABilleteComprado (Ventana miVentana) {
	
		miVentana.billeteComprado.setVisible(true);
		miVentana.fechas.setVisible(false);
	
	}
	
	public void irDesdeParadasABilletes (Ventana miVentana) {
		
		miVentana.billetes.setVisible(true);
		miVentana.paradas.setVisible(false);
		
	}
	
	public void irDesdeFechasABilletes (Ventana miVentana) {
		
		miVentana.billetes.setVisible(true);
		miVentana.fechas.setVisible(false);
		
	}
	
	public void irDesdeBilleteCompradoAFechas (Ventana miVentana) {
		
		miVentana.billeteComprado.setVisible(false);
		miVentana.fechas.setVisible(true);
		
	}
	
	public void irDesdeBilleteCompradoAPago (Ventana miVentana) {
		
		miVentana.billeteComprado.setVisible(false);
		miVentana.pago.setVisible(true);
	}
	
	public void irDesdeBilleteCompradoABilletes (Ventana miVentana) {
		
		miVentana.billeteComprado.setVisible(false);
		miVentana.billetes.setVisible(true);
		
	}
	
	public void irDesdePagoABilleteComprado (Ventana miVentana) {
		
		miVentana.billeteComprado.setVisible(true);
		miVentana.pago.setVisible(false);
		
	}
	
	public void irDesdePagoADevolucion (Ventana miVentana) {
		
		miVentana.devolucion.setVisible(true);
		miVentana.pago.setVisible(false);
		
	}
	
	public void irDesdePagoABilletes (Ventana miVentana) {
		
		miVentana.billetes.setVisible(true);
		miVentana.pago.setVisible(false);
	
	}
	
	public void irDesdeDevolucionADespedida (Ventana miVentana) {
		
		miVentana.devolucion.setVisible(false);
		miVentana.despedida.setVisible(true);
		
	}
	
	public void irDesdeBilletesALogin(Ventana miVentana) {
		
		miVentana.billetes.setVisible(false);
		miVentana.login.setVisible(true);
		
	}
>>>>>>> 8805004b2ef86a95025cb76d414e6cea7dad47af
	
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
