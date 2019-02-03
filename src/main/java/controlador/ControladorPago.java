package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.FuncionesPago;
import modelo.Modelo;
import vista.Ventana;

/**
 * Clase que controla el panel de pago del billete
 *
 */
public class ControladorPago implements ActionListener {
	
	//FuncionesPago funciones = new FuncionesPago();
	FuncionesControlador controlar = new FuncionesControlador();
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
	private int[] arrayCambios=null;
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 */
	public ControladorPago (Ventana miVentana, Modelo miModelo) { 
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		//Definicion de los listeners de los botones del panel
		miVentana.pago.btnAtras.addActionListener(this);
		miVentana.pago.btnSiguiente.addActionListener(this); 
		miVentana.pago.btnCancelar.addActionListener(this); 
		miVentana.pago.btn500.addActionListener(this);
		miVentana.pago.btn200.addActionListener(this);
		miVentana.pago.btn100.addActionListener(this); 
		miVentana.pago.btn50.addActionListener(this);
		miVentana.pago.btn20.addActionListener(this);
		miVentana.pago.btn10.addActionListener(this);
		miVentana.pago.btn5.addActionListener(this);
		miVentana.pago.btn2.addActionListener(this);
		miVentana.pago.btn1.addActionListener(this);
		miVentana.pago.btn050.addActionListener(this);
		miVentana.pago.btn020.addActionListener(this);
		miVentana.pago.btn010.addActionListener(this);
		miVentana.pago.btn005.addActionListener(this);
		miVentana.pago.btn002.addActionListener(this);
		miVentana.pago.btn001.addActionListener(this);
		
		
	}
	/**
	 * Metodo para resetear los valores de la ventana pago	
	 */
	public void resetear() {
		miVentana.pago.total.setText("");
		miVentana.pago.pagado.setText("");
		miVentana.pago.restante.setText("");
		miModelo.misFuncionesPago.dineroPagado=0;
		miModelo.misFuncionesPago.ActBotones(miVentana.pago.arrayBtn);
				
	}
		
	/**
	 * Metodo para las llamadas a los botones de la ventana pago
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Accion dependiendo de que boton venga el evento
		switch (((JButton) e.getSource()).getName()) {
			case "btnAtrasPago": controlar.cambiarDePanel(miVentana.pago, miVentana.billeteComprado);
				resetear();
				break;
								 
			case "btnSiguientePago":  controlar.cambiarDePanel(miVentana.pago, miVentana.devolucion);
				//Calcular cambios despues del pago
				arrayCambios = miModelo.misFuncionesDevolucion.cambios(miModelo.misFuncionesPago.cambios);
			    miModelo.misFuncionesDevolucion.mostrarCambios(miVentana, arrayCambios);
				resetear();
				break;
			
			case "btnCancelarPago": controlar.cambiarDePanel(miVentana.pago, miVentana.billetes);
				resetear();
				break;

			case "btn500" :  miModelo.misFuncionesPago.SumarDineroPago(500, miVentana);
				break;
				
			case "btn200" :  miModelo.misFuncionesPago.SumarDineroPago(200, miVentana);
				break;
				
			case "btn100" :  miModelo.misFuncionesPago.SumarDineroPago(100, miVentana);
				break;
			
			case "btn50" :  miModelo.misFuncionesPago.SumarDineroPago(50, miVentana);
				break;
			
			case "btn20" :  miModelo.misFuncionesPago.SumarDineroPago(20, miVentana);
				break;
			
			case "btn10" :  miModelo.misFuncionesPago.SumarDineroPago(10, miVentana);
				break;
			
			case "btn5" :   miModelo.misFuncionesPago.SumarDineroPago(5, miVentana);
				break;
			
			case "btn2" :  miModelo.misFuncionesPago.SumarDineroPago(2, miVentana);
				break;
			
			case "btn1" :  miModelo.misFuncionesPago.SumarDineroPago(1, miVentana);
				break;
				
			case "btn050" :  miModelo.misFuncionesPago.SumarDineroPago(0.5f , miVentana);
				break;
			
			case "btn020" :  miModelo.misFuncionesPago.SumarDineroPago(0.2f, miVentana);
				break;
			
			case "btn010" :  miModelo.misFuncionesPago.SumarDineroPago(0.1f, miVentana);
				break;
			
			case "btn005" :  miModelo.misFuncionesPago.SumarDineroPago(0.05f, miVentana);
				break;
			
			case "btn002" :  miModelo.misFuncionesPago.SumarDineroPago(0.02f, miVentana);
				break;
				
			case "btn001" :  miModelo.misFuncionesPago.SumarDineroPago(0.01f, miVentana);
				break;

		}
		
	}
}
