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

}
