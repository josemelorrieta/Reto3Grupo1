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
	 */
	public double distanciaRecorrido(String origen, String destino) {
		//Declaración e inicialización de variables
		double distancia = 0;
		//Km por cada grado de latitud/longitud
		final double kmPorGrado  = 111.195;
		
		String codOrigen = nombreParadaACodParada(origen);
		String codDestino = nombreParadaACodParada(destino);
	
		float[] coordenadasOrigen = coordenadasParada(codOrigen);
		float[] coordenadasDestino = coordenadasParada(codDestino);
		//Inicio del programa
		distancia = distanciaEntreParadas(coordenadasOrigen, coordenadasDestino) * kmPorGrado;
		
		return distancia;
	}
	
	public String nombreParadaACodParada(String parada) {
		//Declaración e inicialización de variables
		int codParada = 0;
		
		//Creamos la conexion
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		
		Connection con = miConexion.conectarBD();
		String query= "SELECT Cod_Parada FROM parada WHERE Nombre='" + parada +"'";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		//Inicio del programa
		try {
			while(rs.next()) {
				codParada = rs.getInt("Cod_Parada");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return Integer.toString(codParada);
	}
	
	/**
	 * Metodo que devuelve las coordenadas de una parada
	 * @param codParada Codigo de la parada de la que se quieren obtener sus coordenadas
	 * @return coordenadas Array con la latitud y la longitud de las coordenadas de la parada
	 */
	public float[] coordenadasParada(String codParada) {
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
		try {
			while(rs.next()) {
				//Guardamos en el array la latitud y la longitud
				coordenadas[0] = rs.getFloat("Latitud");
				coordenadas[1] = rs.getFloat("Longitud");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	/**
	 * Metodo que calcula el precio del billete
	 * @param codAutobus Codigo del autobus asociado al billete
	 * @param distancia Distancia entre las paradas de origen y destino
	 * @return precioBillete precio final del billete
	 */
	public double calcularPrecioBillete(int codAutobus, double distancia) {
		//Declaración e inicialización de variables
		double precioBillete = 0;
		float consumo = 0;
		final float beneficio = 20;
		
		consumo = consumoAutobus(codAutobus);
		
		//Calculamos el precio sin beneficio
		precioBillete = distancia * consumo;
		//Calculamos el precio con beneficio
		precioBillete = precioBillete + precioBillete * beneficio / 100;
		
		return precioBillete;
	}
	
	/**
	 * Metodo que devuelve el consumo de un autobus 
	 * @param codAutobus Codigo del autobus del que se quiere saber su consumo
	 * @return consumo Consumo del autobus consultado
	 */
	public float consumoAutobus(int codAutobus) {
		//Declaración e inicialización de variables
		float consumo = 0;
		
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		//Consulta a la base de datos
		String query = "SELECT Consumo_km FROM autobus WHERE Cod_bus = " + codAutobus;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		//Inicio del programa
		try {
			while(rs.next()) {
				consumo = rs.getFloat("Consumo_km");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return consumo;
	}
	
	/**
	 * Metodo que calcula el primer autobus de la linea con plazas libres para ese dia
	 * @param codLinea String linea asociada al billete
	 * @param fechaBillete fecha del billete
	 * @return codAutobus primer autobus asociado a esa linea con plazas libres
	 */
	public int buscarAutobus(String codLinea, String fechaBillete ) {
		//Declaración e inicialización de variables
		int codAutobus = 0;
		int plazasBus = 0;
		
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		//Consulta a la base de datos buscar autobuses por linea
		String query = "SELECT l.Cod_bus, N_plazas from linea_autobus l, autobus a WHERE Cod_Linea='" + codLinea + "' AND l.Cod_bus=a.Cod_bus ORDER BY l.Cod_bus ASC";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		ResultSet rs2;
				
		//Inicio del programa
		try {
			bucleprimario:
			while(rs.next()) {
				codAutobus = rs.getInt("Cod_bus");
				plazasBus = rs.getInt("N_plazas");
				//Buscar los billetes existentes para la fecha del billete y cada codigo de autobus
				query = "SELECT COUNT(*) 'plazasOcupadas' FROM billete WHERE Cod_bus=" + codAutobus + " AND Fecha='" + fechaBillete + "'";
				rs2 = miConsulta.hacerConsultaBD(con, query);
				//Comprobar si tiene plazas libres
				while(rs2.next()) {
					if(rs2.getInt("plazasOcupadas") < plazasBus) {
						break bucleprimario;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return codAutobus;
	}
}
