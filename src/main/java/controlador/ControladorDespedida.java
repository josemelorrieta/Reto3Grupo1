package controlador;

import java.util.Timer;
import java.util.TimerTask;

import vista.Ventana;

public class ControladorDespedida {
	private Ventana miVentana;
	
	public ControladorDespedida(Ventana miVentana) {
		this.miVentana=miVentana;
	}

	public void PasarDeDespedidaASaludo() {
		Timer timer = new Timer();
		TimerTask esperar = new TimerTask() {
			@Override
			public void run() {
				miVentana.despedida.setVisible(false);
				miVentana.saludo.setVisible(true);
			}
		};
		timer.schedule(esperar, 3500);
	}
}
