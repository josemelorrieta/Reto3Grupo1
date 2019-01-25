package controlador;

import javax.swing.JPanel;

import vista.Ventana;

public class FuncionesControlador {
	
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
	
	
}
