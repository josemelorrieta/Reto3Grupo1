package controlador;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ConexionBD; 
import modelo.ConsultaBD;
import modelo.LineaAutobus;
import modelo.Parada;

public class FuncionesVarias {

	/**
	 * Crea los objetos de linea y los llena
	 * @param lineas Un array de lineas que se ha de llenar con los datos 
	 * @param codsLinea Los codigos de la lineas cogidos de la BDD
	 * @return
	 */
	public ArrayList<LineaAutobus> cargarLineas(ArrayList<LineaAutobus> lineas, String[] codsLinea) {
		LineaAutobus linea;
		
		for (int i = 0; i < codsLinea.length; i++) {
			String codLinea = codsLinea[i];
			int[] codAutobus = consultaColumnaInt("select autobus.Cod_bus from autobus, `linea_autobus` where autobus.Cod_bus = `linea_autobus`.Cod_bus and Cod_Linea = '" + codLinea + "';", "Cod_bus");
			String[] municipios = consultaColumnaString("select poblacion.Nombre from poblacion, `poblacion_parada`, parada, `linea_parada` where `linea_parada`.Cod_Parada = parada.Cod_parada and parada.Cod_Parada = `poblacion_parada`.Cod_Parada and `poblacion_parada`.Cod_Postal = poblacion.Cod_Postal and `linea_parada`.Cod_Linea = '" + codLinea + "';", "Nombre");
			linea = new LineaAutobus(codLinea, codAutobus, municipios);
			lineas.add(linea);
		}
		
		return lineas;
	}
	
	/**
	 * Coge la info de la BDD para meterlas en los objetos
	 * @param paradas Un array de paradas que se ha de llenar con los datos 
	 * @param linea El nombre de la linea para hacer las consultas
	 * @return
	 */
	public ArrayList<Parada> cargarParadas(ArrayList<Parada> paradas, String linea) {
		int[] codParada = consultaColumnaInt("select distinct `linea_parada`.Cod_Parada from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "Cod_Parada");
		String[] calle = consultaColumnaString("select calle from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "calle");
		String[] nombre = consultaColumnaString("select distinct parada.nombre from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "nombre");
		float[] coordX = consultaColumnaFloat("select distinct Latitud from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "Latitud");
		float[] coordY = consultaColumnaFloat("select distinct Longitud from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "Longitud");
		
		paradas = crearObjetosParadas(paradas, codParada, calle, nombre, coordX, coordY);
		
		return paradas;
	}
	
	/**
	 * Crea un objeto parada para cada posición del array de paradas y los llena en el constructor
	 * @param paradas array de paradas
	 * @param codParada Los atributos del objeto v
	 * @param calle
	 * @param nombre
	 * @param coordX
	 * @param coordY
	 * @return
	 */
	public ArrayList<Parada> crearObjetosParadas(ArrayList<Parada> paradas, int[]codParada, String[] calle, String[] nombre, float[] coordX, float[] coordY) {
		Parada parada;
		
		for (int i = 0; i < codParada.length; i++) {
			parada = new Parada(codParada[i], calle[i], nombre[i], coordX[i], coordY[i]);
			paradas.add(parada);
		}
		
		return paradas;
	}
	
	/**
	 * Consulta a la BDD que devuelve un array de strings
	 * @param select La consulta en SQL
	 * @param nombreColumna El nombre de la columna del rs
	 * @return
	 */
	public String[] consultaColumnaString(String select, String nombreColumna) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD(); 
		String[] nombreLineas = new String[0];
		int cont = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, select);
		try {
			while (rs.next()) {
				nombreLineas = alargarArray(nombreLineas);
				nombreLineas[cont] = rs.getString(nombreColumna);
				cont++;
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		return nombreLineas;
	}
	
	/**
	 * Consulta a la BDD que devuelve un array de ints
	 * @param select La consulta en SQL
	 * @param nombreColumna El nombre de la columna del rs
	 * @return
	 */
	public int[] consultaColumnaInt(String select, String nombreColumna) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		
		Connection con = miConexion.conectarBD(); 
		int[] nombreLineas = new int[0];
		int cont = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, select);
		try {
			while (rs.next()) {
				nombreLineas = alargarArrayInt(nombreLineas);
				nombreLineas[cont] = rs.getInt(nombreColumna);
				cont++;
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		return nombreLineas;
	}
	
	/**
	 * Consulta a la BDD que devuelve un String
	 * @param select select La consulta en SQL
	 * @param nombreColumna El nombre de la columna del rs
	 * @return
	 */
	public String consultaColumnaUnString(String select, String nombreColumna) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD(); 
		String result = "";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, select);
		try {
			while (rs.next()) {
				result = rs.getString(nombreColumna);
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		return result;
	}
	
	/**
	 * Consulta a la BDD que devuelve un array de floats
	 * @param select La consulta en SQL
	 * @param nombreColumna El nombre de la columna del rs
	 * @return
	 */
	public float[] consultaColumnaFloat(String select, String nombreColumna) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		
		Connection con = miConexion.conectarBD(); 
		float[] nombreLineas = new float[0];
		int cont = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, select);
		try {
			while (rs.next()) {
				nombreLineas = alargarArrayFloat(nombreLineas);
				nombreLineas[cont] = rs.getInt(nombreColumna);
				cont++;
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		return nombreLineas;
	}
	
	/**
	 * Alarga un array de Strings
	 * @param lista El array
	 * @return
	 */
	public String[] alargarArray(String[] lista) {
		String [] auxiliar = new String[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}
	
	/**
	 * Alarga un array de floats
	 * @param lista El array
	 * @return
	 */
	public float[] alargarArrayFloat(float[] lista) {
		float [] auxiliar = new float[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}
	
	/**
	 * Alarga un array de ints
	 * @param lista El array
	 * @return
	 */
	public int[] alargarArrayInt(int[] lista) {
		int [] auxiliar = new int[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}
	
	/**
	 * Alarga un array de Resulset
	 * @param lista
	 * @return El array
	 */
	public ResultSet[] alargarArrayRS(ResultSet[] lista) {
		ResultSet [] auxiliar = new ResultSet[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}
}
