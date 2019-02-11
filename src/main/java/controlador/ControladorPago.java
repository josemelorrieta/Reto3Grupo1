package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;
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
	public double total;
	private double pagado = 0;
	
	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
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
		actBotones(miVentana.pago.arrayBtn);
				
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
				if (pagado > total) {
					arrayCambios = miModelo.misFuncionesDevolucion.cambios(Math.abs(total - pagado));
				} else {
					arrayCambios = null;
				}
			    mostrarCambios(arrayCambios);
				resetear();
				break;
			
			case "btnCancelarPago": controlar.cambiarDePanel(miVentana.pago, miVentana.billetes);
				resetear();
				break;

			case "btn500":  
				pagado = miModelo.misFuncionesPago.sumarDineroPago(500, pagado);
				break;
				
			case "btn200":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(200, pagado);
				break;
				
			case "btn100":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(100, pagado);
				break;
			
			case "btn50":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(50, pagado);
				break;
			
			case "btn20":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(20, pagado);
				break;
			
			case "btn10":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(10, pagado);
				break;
			
			case "btn5":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(5, pagado);
				break;
			
			case "btn2":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(2, pagado);
				break;
			
			case "btn1":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(1, pagado);
				break;
				
			case "btn050":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(0.5f, pagado);
				break;
			
			case "btn020":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(0.2f, pagado);
				break;
			
			case "btn010":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(0.1f, pagado);
				break;
			
			case "btn005":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(0.05f, pagado);
				break;
			
			case "btn002":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(0.02f, pagado);
				break;
				
			case "btn001":
				pagado = miModelo.misFuncionesPago.sumarDineroPago(0.01f, pagado);
				break;
		}
		
		if (pagado >= total) {
			miVentana.pago.restante.setText(formatoMoneda.format(0));
			miVentana.pago.pagado.setText(formatoMoneda.format(pagado));
			desBotones(miVentana.pago.arrayBtn);
			actBotones(miVentana.pago.btnSiguiente);
			desBotones(miVentana.pago.btnCancelar);
			desBotones(miVentana.pago.btnAtras);
		} else {
			miVentana.pago.restante.setText(formatoMoneda.format(total - pagado));
			miVentana.pago.pagado.setText(formatoMoneda.format(pagado));
		}
		
	}
	
    /**
     * Metodo que desactiva todos los botones de dinero de la ventana pago
     * @param array de botones a desactivar 
     */
	public void desBotones(JButton[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(false);
		}
	}

	/**
	 * Metodo que activa todos los botones de dinero de la ventana pago
	 * @param array array de botones a activar
	 */
	public void actBotones(JButton[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i].setEnabled(true);
		}
	}
	
	/**
	 * Metodo que activa el boton que se desee de las ventanas
	 * @param boton a activar
	 */
	public void actBotones(JButton boton) {   
			boton.setEnabled(true);
		 
	}
	
	/**
	 * Metodo que desactiva el boton que se desee de las ventanas
	 * @param boton a desactivar
	 */
	public void desBotones(JButton boton) {   
		boton.setEnabled(false);
	
	}
	
	/**
	 * Metodo para mostrar los cambios en la ventana de devolucion 
	 * @param miVentana instancia de la ventana principal
	 * @param cambios array con el numero de cada moneda o billete a devolver segun su posicion en el array
	 */
	public void mostrarCambios(int[] cambios) {
		//Declaracion e inicializacion de
		String mensajeCambios = "";
		
		//Inicio del programa
		if (arrayCambios != null) {
			//Recorremos el array de cambios. Cada posicion es una moneda o billete 500, 200, 100...
			for(int z=0 ; z < cambios.length ; z++) {
				//Si la posicion es distinta de cero hay cambios de esa moneda/billete 
				if (cambios[z]>0) {
					switch (z) {
					
						case 0 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(500)) + ": " ; break;
					
						case 1 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(200)) + ": " ; break;
						
						case 2 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(100)) + ": " ; break;
							
						case 3 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(50)) + ": " ; break;
							
						case 4 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(20)) + ": " ; break;
							
						case 5 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(10)) + ": " ; break;
							
						case 6 :  mensajeCambios= "Billetes de " + (formatoMoneda.format(5)) + ": " ; break;
						
						case 7 :  mensajeCambios= "Moneda de " + (formatoMoneda.format(2)) + ": " ; break;
							
						case 8 :  mensajeCambios= "Moneda de " + (formatoMoneda.format(1)) + ": " ; break;
							
						case 9 :  mensajeCambios= "Moneda de " + (formatoMoneda.format(0.5)) + ": " ; break;
						
						case 10 :  mensajeCambios= "Moneda de " + (formatoMoneda.format(0.2)) + ": " ; break;
						
						case 11 :  mensajeCambios= "Moneda de " + (formatoMoneda.format(0.1)) + ": " ; break;
						
						case 12 :  mensajeCambios= "Moneda de " + (formatoMoneda.format(0.05)) + ": " ; break;
						
						case 13 :  mensajeCambios= "Moneda de " + (formatoMoneda.format(0.02)) + ": " ; break;
						
						case 14 :  mensajeCambios= "Moneda de " + (formatoMoneda.format(0.01)) + ": " ; break;
					
					}
					//A�adimos la linea al modelo de la lista
					miVentana.devolucion.cambios.addElement(mensajeCambios + cambios[z]);
				}
			}
		}else {
			//Si no hay cambios
			miVentana.devolucion.cambios.addElement("No hay cambios");
		}
		//Actualizamos la lista con los datos del modelo
		miVentana.devolucion.devolucion.setModel(miVentana.devolucion.cambios);
		
	}

}
