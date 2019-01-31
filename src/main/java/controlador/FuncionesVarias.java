package controlador;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ConexionBD; 
import modelo.ConsultaBD;
import modelo.LineaAutobus;

public class FuncionesVarias {

	public void cargarLineas (ArrayList<LineaAutobus> lineas, String[] codLinea) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD(); 
		int[] buses = new int[0];
		int cont = 0;
		ResultSet rs[] = new ResultSet[0];
		
		// Cargamos los resulset para todas las lineas (un rs por cada linea que exista)
		for (int i = 0; i < codLinea.length; i++) {
			rs[i] = miConsulta.hacerConsultaBD(con, "select distinct `linea-parada`.Cod_Linea, `linea_autobus`.Cod_bus from `linea-parada`, `linea_autobus` where `linea-parada`.Cod_Linea = `linea_autobus`.Cod_Linea and `linea_autobus`.Cod_Linea = '"+codLinea[i]+"';" );
		}
		
		// Llenamos los arrays auxiliares con el contenido de los rs una vez por cada linea que haya
		try {
			for (int i = 0; i < codLinea.length; i++) {
				while (rs[i].next()) {
					buses = alargarArrayInt(buses);
					buses[cont] = rs[i].getInt("Cod_bus");
					codLinea[i] = rs[i].getString("Cod_Linea");
					cont++;
				}
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		
		// Llenamos los atributos de los objetos que creemos (un objeto por cada linea de la BDD con sus atributos)
		for (int i = 0; i < codLinea.length; i++) {
			crearObjetosLineas(lineas, rs[i], codLinea[i], buses, con);
		}
		
		// Cerramos la conexión
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
	}
	
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
	
	public void crearObjetosLineas(ArrayList<LineaAutobus> lineas, ResultSet rs, String codLinea, int[] buses, Connection con) {
		try {
			while (rs.next()) {
				LineaAutobus linea = new LineaAutobus(codLinea, buses, municipioPorLinea(con));
				lineas.add(linea);
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
	}
	
	public String[] sacarNombresCodLineas(String select) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD(); 
		String[] nombreLineas = new String[0];
		int cont = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, select);
		try {
			while (rs.next()) {
				nombreLineas = alargarArray(nombreLineas);
				nombreLineas[cont] = rs.getString("Nombre");
				cont++;
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		return nombreLineas;
	}
	
	public String[] alargarArray(String[] lista) {
		String [] auxiliar = new String[lista.length+1];
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
}
