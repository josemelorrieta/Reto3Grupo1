package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	/**
	 * Metodo que devuelve la distancia entre dos paradas
	 * @param origen Parada de origen
	 * @param destino Parada de destino
	 * @return distancia Distancia entre las paradas
	 * @throws SQLException Excepcion en caso de error al conectar a la base de datos
	 */
	public double distanciaRecorrido(String origen, String destino) throws SQLException {
		//Declaración e inicialización de variables
		double distancia = 0;
		//Km por cada grado de latitud/longitud
		final double kmPorGrado  = 111.195;
	
		float[] coordenadasOrigen = coordenadasParada(origen);
		float[] coordenadasDestino = coordenadasParada(destino);
		//Inicio del programa
		distancia = distanciaEntreParadas(coordenadasOrigen, coordenadasDestino) * kmPorGrado;
		
		return distancia;
	}
	
	/**
	 * Metodo que devuelve las coordenadas de una parada
	 * @param codParada Codigo de la parada de la que se quieren obtener sus coordenadas
	 * @return coordenadas Array con la latitud y la longitud de las coordenadas de la parada
	 * @throws SQLException Excepcion en caso de error al conectar a la base de datos
	 */
	public float[] coordenadasParada(String codParada) throws SQLException {
		//Declaración e inicialización de variables
		float[] coordenadas = {0,0};
		
		//Creamos la conexion
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		
		Connection con = miConexion.conectarBD();
		//Query a realizar contra la BD
		String query = "SELECT Latitud, Longitud FROM parada WHERE Cod_Parada = " + codParada;
		
		//Recibimos los resultadados de la buqueda
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		//Inicio del programa
		while(rs.next()) {
			//Guardamos en el array la latitud y la longitud
			coordenadas[0] = rs.getFloat("Latitud");
			coordenadas[1] = rs.getFloat("Longitud");
		}
		con.close();
		
		return coordenadas;
	}
	
	/**
	 * Metodo que devuelve la distanca euclidea 
	 * @param coordP1 Array con la latitud y longitud de la parada de origen
	 * @param coordP2 Array con la latitud y longitud de la parada de destino
	 * @return distancia Distancia en grados terrestres entre las dos paradas
	 */
	public double distanciaEntreParadas (float[] coordP1, float[] coordP2) {
		//Declaración e inicialización de variables
		double distancia = 0;
		
		//Inicio del programa
		//Calcular distancia euclidea RAIZ((x1-x2)^2 + (y1-y2)^2)
		distancia = Math.sqrt(Math.pow((coordP2[0] - coordP1[0]), 2) + Math.pow((coordP2[1] - coordP1[1]), 2));
		
		return distancia;
	}
}
