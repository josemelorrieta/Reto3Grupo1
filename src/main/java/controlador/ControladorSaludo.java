package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.Ventana;

/**
 * Clase que controla el panel de saludo
 *
 */
public class ControladorSaludo implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	
	private Ventana miVentana;
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventana principal
	 */
	public ControladorSaludo( Ventana miVentana) {
		
		this.miVentana = miVentana;
		
		//Defininicion del listener del boton del panel saludo
		miVentana.saludo.btnSaludo.addActionListener(this);
		 
	} 
		
	/**
	 * Metodo de las llamadas a los botones de la ventana saludo
	 */
	@Override
	public void actionPerformed(ActionEvent e) { 
		//Accion del boton del panel saludo
		switch (((JButton) e.getSource()).getName()) {
			case "btnSaludo": funciones.cambiarDePanel(miVentana.saludo, miVentana.login);
			break;
		
		}
		
	}

}
