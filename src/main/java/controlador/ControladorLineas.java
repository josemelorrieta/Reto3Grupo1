package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Billete;
import modelo.FuncionesBilletes;
import modelo.LineaAutobus;
import modelo.Modelo;
import vista.Ventana;

/**
 * Calse que controla el panel que muestra las lineas de autobus
 *
 */
public class ControladorLineas implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	
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

	
	/**
	 * Metodo para las llamadas a los botones de la ventana lineas
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Accion dependiendo de que boton venga la llamada
		switch (((JButton) e.getSource()).getName()) {
			case "btnSiguienteLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.paradas);
				//Cargar las paradas de la linea seleccionada
				miModelo.paradas = miModelo.misFuncionesParadas.cargarParadas(miModelo.paradas, miVentana.lineas.listaLineas.getSelectedItem().toString());
				if(miModelo.paradas != null) {
					miVentana.paradas.modeloOrigen.removeAllElements();
					miVentana.paradas.modeloDestino.removeAllElements();
					for (int i=0;i<miModelo.paradas.length;i++) {
						miVentana.paradas.modeloOrigen.addElement(miModelo.paradas[i].getNombre());
						//Quitamos la primera parada de la lista de destino
						if(i != 0) {
							miVentana.paradas.modeloDestino.addElement(miModelo.paradas[i].getNombre());
						}
					}
					miVentana.paradas.paradaDeOrigen.setModel(miVentana.paradas.modeloOrigen);
					miVentana.paradas.paradaDeDestino.setModel(miVentana.paradas.modeloDestino);
				} else {
					JOptionPane.showMessageDialog(miVentana, "Hubo un error al cargar las paradas", "¡Atención!", JOptionPane.WARNING_MESSAGE);
				}
				//Poner el nombre de la linea en el titulo del panel de paradas
				miVentana.paradas.lblMostrarLinea.setText(miVentana.lineas.listaLineas.getSelectedItem().toString());
				//Crear el billete para la compra actual
				String codLinea = miModelo.misFuncionesParadas.nombreLineaACodLinea(miVentana.lineas.listaLineas.getSelectedItem().toString());
				miModelo.billeteIda = miModelo.misFuncionesModelo.crearBilleteActual(miModelo, codLinea);
				break;
				
			case "btnCancelarLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.billetes); 
				break;
		}
	}

}
