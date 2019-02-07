package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Modelo;
import vista.Ventana;

/**
 * Clase que controla el panel de devolucion de cambios
 *
 */
public class ControladorDevolucion implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Controlador miControlador; 
	private Modelo miModelo;
	
	/**
	  * Constructor de la clase
	  * @param miVentana instancia de la ventana principal
	  * @param miControlador instancia del coontrolador principal para poder acceder a otros paneles
	  *
	  */
	public ControladorDevolucion (Ventana miVentana, Controlador miControlador, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miControlador = miControlador;
		this.miModelo = miModelo;
		
		//Definir los listeners para los botones del panel
		miVentana.devolucion.btnSiguiente.addActionListener(this);		
	}
	
	/**
	 * Metodo para resetear los valores de la ventana devolucion	
	 */
	public void  resetear() {		
		miVentana.devolucion.cambios.removeAllElements();
	}
		
	/**
	 * Metodo para las llamadas a los botones de la ventana devolucion	
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Dependiendo de que boton vienen la accion hacemos lo necesario 
		switch (((JButton) e.getSource()).getName()) {
			case "btnSiguienteDevolucion":
				if (miModelo.misFuncionesDevolucion.guardarBilleteBD(miModelo.billeteIda, miModelo)) {
					funciones.cambiarDePanel(miVentana.devolucion, miVentana.despedida);
					miControlador.miControladorDespedida.PasarDeDespedidaASaludo();
				} else {
					JOptionPane.showMessageDialog(miVentana, "Hubo un error al guardar el billete en la Base de Datos", "¡Atencion!", JOptionPane.WARNING_MESSAGE);
				};
				resetear();
				break;
		}
		
	}

}
