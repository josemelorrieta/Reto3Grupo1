package modelo;

import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Locale;

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
		this.setMiModelo(miModelo);
	}
	
	/**
	 * Metodo para realizar los cambios en las menores monedas y billetes posibles.	
	 * @param dinero cantidad a devolver para calcular las monedas y billetes de la devolucion
	 * @return array con la cantidad de cada billete o moneda, segun su posicion en el array
	 */
	public int[] cambios(double dinero) {
		
		// Declaracion e inicializacion de variables
		int euros = (int) Math.floor(dinero);
		int decimales = (int) Math.round((dinero - euros) * 100);
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
	 * Metodo que guarda el billete en la base de datos
	 * @param billete Billete a guardar en la base de datos
	 * @return true si se guarda con exito, false si hay un error
	 */
	public boolean guardarBilleteBD(Billete billete, Modelo miModelo, int numTrayecto) {
		//Declaración e inicializacion de variables		
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		int codOrigen = Integer.parseInt(miModelo.misFuncionesFechas.nombreParadaACodParada(billete.getOrigen()));
		int codDestino = Integer.parseInt(miModelo.misFuncionesFechas.nombreParadaACodParada(billete.getDestino()));
		
		String query = "INSERT INTO billete (Cod_Billete, Cod_Bus, Cod_Linea, Cod_Parada_Fin, Cod_Parada_Inicio, DNI, Fecha, Hora, NTrayecto, Precio) VALUES (" + billete.getNumBillete() + ", " + billete.getCodAutobus() + ", '" + billete.getCodLinea() + "', " + codDestino + ", " + codOrigen + ", '" + billete.getDni() + "', '" + billete.getFecha() + "', '12:00', " + numTrayecto + ", " + billete.getPrecioTrayecto() + ")";
		
		//Inicio del programa
		if(miConsulta.insertarDatosBD(con, query)) {
			return true;
		} else {
			return false;
		}
	}

	//Getters and setters
	public Modelo getMiModelo() {
		return miModelo;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}	 


	
