package controlador;

import java.util.Timer;
import java.util.TimerTask;

import vista.Ventana;

public class ControladorDespedida {
	private Ventana miVentana;
	
    
 //Constructor
	public ControladorDespedida(Ventana miVentana) {
		this.miVentana=miVentana;
	}
	
 //Metodo para pasar del la ventana despedida a la de saludo automaticamente (en milisegundos)
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
