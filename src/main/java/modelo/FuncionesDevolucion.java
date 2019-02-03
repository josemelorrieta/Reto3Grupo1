package modelo;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JButton;

import controlador.DatosPrecio;
import vista.Ventana;

/**
 * Calse con las funciones del panel de devolucion de cambios
 *
 */
public class FuncionesDevolucion {
	private Modelo miModelo;

	NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
	
//	DatosPrecio datos = new DatosPrecio();
	/**
	 * Contrustor de la clase
	 * @param miModelo instancia del modelo para acceder a las funciones
	 */
	public FuncionesDevolucion (Modelo miModelo) {
		this.miModelo=miModelo;
	}
	
	/**
	 * Metodo para realizar los cambios en las menores monedas y billetes posibles.	
	 * @param dinero cantidad a devolver para calcular las monedas y billetes de la devolucion
	 * @return array con la cantidad de cada billete o moneda, segun su posicion en el array
	 */
	public int[] cambios(float dinero) {
		
		// Declaracion e inicializacion de variables
		int euros = (int) dinero;
		int decimales = Math.round((dinero - euros) * 100);
		int[] billetesMonedas = {500, 200, 100, 50, 20, 10, 5, 2, 1};
		int[] cambios = new int[15];
		
		//Inicio del programa
		for (int i = 0, f = 0, fake = 1; i < billetesMonedas.length + fake; i++, f++) {
			//Mira si tiene que pasar a calcular los decimales
			if (f == 9) {
				i = 3;
				fake = 0;
			}
			//Calcula los euros
			if (euros >= billetesMonedas[i] && f < 9) {
				cambios[f] = (int) (euros / billetesMonedas[i]);
				euros = euros % billetesMonedas[i];
			}
			//Calcula los centimos si ha acabado con los euros
			else if (decimales >= billetesMonedas[i] && f >= 9) {
				cambios[f] = (int) ((billetesMonedas[i]/100f) + (decimales / billetesMonedas[i]));
				decimales = decimales % billetesMonedas[i];
			}
		}
		return cambios;
	}
	
	/**
	 * Metodo para mostrar los cambios en la ventana de devolucion 
	 * @param miVentana instancia de la ventana principal
	 * @param cambios array con el numero de cada moneda o billete a devolver segun su posicion en el array
	 */
	public void mostrarCambios(Ventana miVentana, int[] cambios) {
		
		String mensajeCambios = "";
		if (miModelo.misFuncionesPago.total < miModelo.misFuncionesPago.dineroPagado) { 
			for(int z=0 ; z < cambios.length ; z++) {
				
				if (cambios[z]>0) 
				{
					
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
					
					
					miVentana.devolucion.cambios.addElement(mensajeCambios + cambios[z]);
				}
			}
		}else { 
			miVentana.devolucion.cambios.addElement("No hay cambios");
		}
		miVentana.devolucion.devolucion.setModel(miVentana.devolucion.cambios);
		
	}
}	 


	
