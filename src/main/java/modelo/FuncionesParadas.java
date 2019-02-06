package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesParadas {
	private Modelo miModelo;
	
	/**
	 * Constructor de la clase
	 * @param miModelo Clase Modelo general
	 */
	public FuncionesParadas(Modelo miModelo) {
		this.miModelo = miModelo;
	}
	
	/**
	 * Metodo para cargar las paradas de la linea seleccionada
	 * @param paradas Array de paradas a cargar
	 * @param linea String con el nombre de la linea seleccionada
	 * @return paradas Array rellanado con las paradas de la lineas seleccionada
	 */
	public Parada[] cargarParadas(Parada[] paradas, String linea) {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		String codLinea = nombreLineaACodLinea(linea);
		
		//miModelo.billeteActual = miModelo.misFuncionesModelo.crearBilleteActual(miModelo, codLinea);
		
		String query = "SELECT parada.Cod_Parada, Calle, Nombre, Latitud, Longitud FROM parada, `linea-parada` WHERE parada.Cod_Parada=`linea-parada`.Cod_Parada and Cod_Linea='" + codLinea + "'" ;
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		paradas = null;
		paradas = new Parada[0];
		
		int codParada =  0;
		String calle = "";
		String nombre = "";
		float latitud = 0;
		float longitud = 0;
		
		try {
			while(rs.next()) {
				codParada = rs.getInt("Cod_Parada");
				calle = rs.getString("Calle");
				nombre = rs.getString("Nombre");
				latitud = rs.getFloat("Latitud");
				longitud = rs.getFloat("Longitud");
				
				//Incrementamos el array para meter el nuevo objeto
				paradas = incrementarArrayParada(paradas);
				paradas[paradas.length - 1] = new Parada(codParada, calle, nombre, latitud, longitud);
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
		
		return paradas;
	}
	
	/**
	 * Metodo para incrementar el array de paradas
	 * @param lineas Array de paradas a incrementar
	 * @return aux Array de paradas incrementado
	 */
	public Parada[] incrementarArrayParada(Parada[] paradas) {
		//Declaracion e inicializacion de variables
		Parada[] aux = new Parada[paradas.length + 1];
		
		//Inicio del programa
		for (int i=0;i<paradas.length;i++) {
			aux[i] = paradas[i];
		}
		
		return aux;
	}
	
	public String nombreLineaACodLinea(String linea) {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		String codLinea = "";
		
		String query = "SELECT Cod_Linea FROM linea WHERE Nombre='" + linea + "'" ;
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		try {
			while(rs.next()) {
				codLinea = rs.getString("Cod_Linea");
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
		
		return codLinea;
		
	}
}
