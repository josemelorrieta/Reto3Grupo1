package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import modelo.LineaAutobus;
import vista.Ventana;

/**
 * Calse que controla el panel que muestra las lineas de autobus
 *
 */
public class ControladorLineas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	ArrayList<LineaAutobus> lineas;
	FuncionesVarias funcionesModelo = new FuncionesVarias();
	
	//private Controlador miControlador;
	private Ventana miVentana;
	
	
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventana principal
	 * @param lineas instancaia del array con las lineas disponibles
	 */
	public ControladorLineas (Ventana miVentana, ArrayList<LineaAutobus> lineas) {
		
		this.miVentana = miVentana;
		this.lineas = lineas;
		
		//Definicion de los listeners de los botones del panel
		miVentana.lineas.btnSiguiente.addActionListener(this);
		miVentana.lineas.btnCancelar.addActionListener(this);
		
	}
		
	/**
	 * Metodo para las llamadas a los botones de la ventana lineas
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Accion dependiendo de que boton venga la llamada
		switch (((JButton) e.getSource()).getName()) {
			case "btnSiguienteLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.paradas);
				String[] codLineas = funcionesModelo.consultaColumnaString("select distinct Cod_linea from `linea_autobus`;", "Cod_linea");	
				//lineas = funcionesModelo.cargarLineas(lineas, codLineas);
				
				break;
			case "btnCancelarLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.billetes); 
				break;
		}
	}

}
