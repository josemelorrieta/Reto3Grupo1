package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import modelo.LineaAutobus;
import modelo.Modelo;
import vista.Ventana;

/**
 * Calse que controla el panel que muestra las lineas de autobus
 *
 */
public class ControladorLineas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	FuncionesVarias funcionesModelo = new FuncionesVarias();
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventana principal
	 * @param lineas instancaia del array con las lineas disponibles
	 */
	public ControladorLineas (Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		//Definicion de los listeners de los botones del panel
		miVentana.lineas.btnSiguiente.addActionListener(this);
		miVentana.lineas.btnCancelar.addActionListener(this);
		
	}
	
	//ESTO TIENE QUE IR EN EL MODELO, EN LAS FUNCIONES PARA ESTE PANEL --> REFACTORIZAR
		public void cargarBotones() {
			String[] nombreParadas = funcionesModelo.consultaColumnaString("select distinct parada.nombre from parada, `linea-parada` where parada.Cod_Parada = `linea-parada`.`Cod_Parada` and Cod_Linea like 'L1' ;", "nombre");
			miVentana.paradas.ParadaDeOrigen.setModel(new DefaultComboBoxModel(nombreParadas));
			miVentana.paradas.ParadaDeDestino.setModel(new DefaultComboBoxModel(nombreParadas));
			
		}
		
	/**
	 * Metodo para las llamadas a los botones de la ventana lineas
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Accion dependiendo de que boton venga la llamada
		switch (((JButton) e.getSource()).getName()) {
			case "btnSiguienteLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.paradas);
				cargarBotones();
				// meter esto en un metodo? y va en el panel anterior
				String[] codLineas = funcionesModelo.consultaColumnaString("select distinct Cod_linea from `linea_autobus`;", "Cod_linea");	
				//lineas = funcionesModelo.cargarLineas(lineas, codLineas);
				
				break;
			case "btnCancelarLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.billetes); 
				break;
		}
	}

}
