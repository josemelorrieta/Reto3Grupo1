package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
	ArrayList<LineaAutobus> lineas;
	FuncionesVarias funcionesModelo = new FuncionesVarias();
	FuncionesBilletes funcionesBillete = new FuncionesBilletes();
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventana principal
	 * @param lineas instancaia del array con las lineas disponibles
	 */

	public ControladorLineas (Ventana miVentana, ArrayList<LineaAutobus> lineas, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.lineas = lineas;
		this.miModelo = miModelo;
		
	}

	public ControladorLineas (Ventana miVentana, ArrayList<LineaAutobus> lineas) {
		
		this.miVentana = miVentana;
		this.lineas = lineas;

		
		//Definicion de los listeners de los botones del panel
		miVentana.lineas.btnSiguiente.addActionListener(this);
		miVentana.lineas.btnCancelar.addActionListener(this);
		
	}

	
	//ESTO TIENE QUE IR EN EL MODELO, EN LAS FUNCIONES PARA ESTE PANEL --> REFACTORIZAR
		public void cargarBotones(String codLinea) {
			String[] nombreParadas = funcionesModelo.consultaColumnaString("select distinct parada.nombre from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '" + codLinea + "' ;", "nombre");
//			int indice = miVentana.paradas.ParadaDeOrigen.getSelectedIndex();
//			ArrayList<String> paradasAux;
//			while (nombreParadas[indice] && nombreParadas[indice + 1]) {
//				paradasAux.add(nombreParadas[indice + 1]);
//				indice++
//			}
			
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
				//Cargamos los objetos lineas y los llenamos
				String[] codLineas = funcionesModelo.consultaColumnaString("select distinct Cod_linea from `linea_autobus`;", "Cod_linea");	
				lineas = funcionesModelo.cargarLineas(lineas, codLineas);
				//Cargamos los botones de las paradas
				String nombreLinea = miVentana.lineas.SeleccionarLinea.getSelectedItem().toString();
				String codLinea = funcionesModelo.consultaColumnaUnString("select Cod_Linea from linea where Nombre = '" + nombreLinea +"';", "Cod_Linea");
				cargarBotones(codLinea);
				//Cargamos el codLinea en el objeto billete
				if (miModelo.billetes == null) {
					miModelo.billetes = new Billete[0]; 
				}
				miModelo.billetes = funcionesBillete.incrementarArrayBilletes(miModelo.billetes);
				miModelo.billetes[miModelo.billetes.length-1]= new Billete(1, null, codLinea, miVentana.paradas.ParadaDeOrigen.getSelectedItem().toString(), miVentana.paradas.ParadaDeDestino.getSelectedItem().toString(), 111, 0, null);
				break;
			case "btnCancelarLineas": funciones.cambiarDePanel(miVentana.lineas, miVentana.billetes); 
				break;
		}
	}

}
