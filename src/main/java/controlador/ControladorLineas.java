package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
	 * @param miModelo Instancia del modelo de la aplicacion
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
				//Ordenar las paradas segun su distancia a la parada de origen
				miModelo.paradas = miModelo.misFuncionesParadas.ordenarParadas(miModelo.paradas);
				if(miModelo.paradas != null) {
					//Borramos las listas de paradas de origen y destino. La lista de paradas de destino se actualiza al cambiar las paradas de origen 
					miVentana.paradas.modeloOrigen.removeAllElements();
					miVentana.paradas.modeloDestino.removeAllElements();
				
					for (int i=0;i<miModelo.paradas.length;i++) {
						//Quitamos la ultima parada de la lista de paradas de origen
						if (i != miModelo.paradas.length - 1) {
							miVentana.paradas.modeloOrigen.addElement(miModelo.paradas[i].getNombre());
						}
						//Quitamos de lista de destinos la primera parada
						if (i != 0) {
							miVentana.paradas.modeloDestino.addElement(miModelo.paradas[i].getNombre());
						}
					}
					miVentana.paradas.paradaDeOrigen.setModel(miVentana.paradas.modeloOrigen);
					miVentana.paradas.paradaDeDestino.setModel(miVentana.paradas.modeloDestino);
				} else {
					JOptionPane.showMessageDialog(miVentana, "Hubo un error al cargar las paradas", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
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
