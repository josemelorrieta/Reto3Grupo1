package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.Ventana;

public class ControladorSaludo implements ActionListener {
	
	public JPanel panelSaludo;
	public JPanel panelLogin;
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	//Constructor
		public ControladorSaludo(/*Controlador miControlador,*/ Ventana miVentana) {
			//This.miControlador = miControlador;
			this.miVentana = miVentana;
			
			miVentana.saludo.btnSaludo.addActionListener(this);
		
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (miVentana.saludo.btnSaludo.getName()) {
			case "btnSaludo":  FuncionesControlador.irDesdeSaludoALogin(panelSaludo, panelLogin);  break;
		
		}
			
		}

}
