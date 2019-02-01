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

	Parada parada;
	
//	public ArrayList<LineaAutobus> cargarLineas (ArrayList<LineaAutobus> lineas, String[] codLinea) {
//		ConexionBD miConexion = new ConexionBD();
//		ConsultaBD miConsulta = new ConsultaBD();
//		Connection con = miConexion.conectarBD(); 
//		int[] buses = new int[0];
//		int cont = 0;
//		ResultSet rs[] = new ResultSet[0];
//		
//		// Cargamos los resulset para todas las lineas (un rs por cada linea que exista)
//		for (int i = 0; i < codLinea.length; i++) {
//			rs = alargarArrayRS(rs);
//			rs[i] = miConsulta.hacerConsultaBD(con, "select distinct `linea_parada`.Cod_Linea, `linea_autobus`.Cod_bus from `linea_parada`, `linea_autobus` where `linea_parada`.Cod_Linea = `linea_autobus`.Cod_Linea and `linea_autobus`.Cod_Linea = '" + codLinea[i] +"'; " );
//			//alargar el array de rs 
//		}
//		
//		// Llenamos los arrays auxiliares con el contenido de los rs una vez por cada linea que haya
//		try {
//			for (int i = 0; i < codLinea.length; i++) {
//				while (rs[i].next()) {
//					buses = alargarArrayInt(buses);
//					buses[cont] = rs[i].getInt("Cod_bus");
//					codLinea[i] = rs[i].getString("Cod_Linea"); 
//					cont++;
//				}
//			}
//		} catch (SQLException e) {
//			System.out.println("Implementar un txt");
//		}
//		
//		// Llenamos los atributos de los objetos que creemos (un objeto por cada linea de la BDD con sus atributos)
//		for (int i = 0; i < codLinea.length; i++) {
//			lineas = crearObjetosLineas(lineas, rs[i], codLinea[i], buses, con);
//		}
//		
//		// Cerramos la conexión
//		try {
//			con.close();
//		} catch (SQLException e) {
//			System.out.println("Implementar un txt");
//		}
//		
//		return lineas;
//	}
	
//	public ArrayList<LineaAutobus> cargarLineas(ArrayList<LineaAutobus> lineas, String[] codLinea) {
//		int[] codLinea = consultaColumnaInt(select, nombreColumna);
//		int[] codAutobus = consultaColumnaInt(select, nombreColumna);
//		String[] municipios = consultaColumnaInt(select, nombreColumna);
//		
//		
//	}
	
	public String[] municipioPorLinea(Connection con) {
		ConsultaBD miConsulta = new ConsultaBD();
		String[] municipios = new String[0];
		int cont = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select poblacion.Nombre from poblacion, `poblacion_parada`, parada, `linea-parada` where `linea-parada`.Cod_Parada = parada.Cod_parada and parada.Cod_Parada = `poblacion_parada`.Cod_Parada and `poblacion_parada`.Cod_Postal = poblacion.Cod_Postal and `linea-parada`.Cod_Linea = 'L1';");
		try {
			while (rs.next()) {
				municipios = alargarArray(municipios);
				municipios[cont] = rs.getString("Nombre");
				cont++;
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		return municipios; 	
	}
	
	public ArrayList<LineaAutobus> crearObjetosLineas(ArrayList<LineaAutobus> lineas, ResultSet rs, String codLinea, int[] buses, Connection con) {
		try {
			while (rs.next()) {
				LineaAutobus linea = new LineaAutobus(codLinea, buses, municipioPorLinea(con));
				lineas.add(linea);
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		return lineas;
	}
	
	public ArrayList<Parada> crearObjetosParadas(ArrayList<Parada> paradas, int[]codParada, String[] calle, String[] nombre, float[] coordX, float[] coordY) {
		for (int i = 0; i < codParada.length; i++) {
			parada = new Parada(codParada[i], calle[i], nombre[i], coordX[i], coordY[i]);
			paradas.add(parada);
		}
		return paradas;
	}
	
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
	
	public ArrayList<Parada> cargarParadas(ArrayList<Parada> paradas, String linea) {
		int[] codParada = consultaColumnaInt("select distinct `linea_parada`.Cod_Parada from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "Cod_Parada");
		String[] calle = consultaColumnaString("select calle from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "calle");
		String[] nombre = consultaColumnaString("select distinct parada.nombre from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "nombre");
		float[] coordX = consultaColumnaFloat("select distinct Latitud from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "Latitud");
		float[] coordY = consultaColumnaFloat("select distinct Longitud from parada, `linea_parada` where parada.Cod_Parada = `linea_parada`.`Cod_Parada` and Cod_Linea like '"+linea+"' ;", "Longitud");
		
		paradas = crearObjetosParadas(paradas, codParada, calle, nombre, coordX, coordY);
		
		return paradas;
	}
	
	public String[] alargarArray(String[] lista) {
		String [] auxiliar = new String[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}
	
	public float[] alargarArrayFloat(float[] lista) {
		float [] auxiliar = new float[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}
	
	public int[] alargarArrayInt(int[] lista) {
		int [] auxiliar = new int[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}
	
	public ResultSet[] alargarArrayRS(ResultSet[] lista) {
		ResultSet [] auxiliar = new ResultSet[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}
}
