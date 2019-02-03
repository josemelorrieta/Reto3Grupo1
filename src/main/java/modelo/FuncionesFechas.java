package modelo;

import java.util.Calendar;
import java.util.Date;

/**
 * Clase con las funciones del panel de fechas del billete
 *
 */
public class FuncionesFechas {

	/**
	 * Suma tres dias a la fecha recibida por parametro y devuelve la fecha resultante
	 * @param fechaInicio fecha inicial a la que se le quieren sumar los tres dias 
	 * @return fechaLimite fecha inicial mas tres dias
	 */
	public Date setFechasDisponibles(Date fechaInicio) {
		// Definicion e inicializacion de variables
		Date fechaLimite;
		Calendar calendar = Calendar.getInstance();
		
		//Inicio del programa
		calendar.setTime(fechaInicio);
		//Añade tres dias a la fecha de hoy
		calendar.add(Calendar.DATE, 3);
		fechaLimite = calendar.getTime();
		
		return fechaLimite;
	}
}
