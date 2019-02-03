package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que realiza consultas y modificaciones en la base de datos
 *
 */
public class ConsultaBD {
	/**
	 * Metodo para consultar en la base de datos
	 * @param con Conexion a la base de datos
	 * @param query Consulta a realizar de tipo SELECT
	 * @return ResultSet con los resultados de la consulta realizada
	 */
	public ResultSet hacerConsultaBD (Connection con, String query) {
		ResultSet rs = null;
		
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return rs;
	}
	
	/**
	 * Metodo para insertar valores en una tabla de la base de datos
	 * @param con Conexion a la base de datos
	 * @param query Consulta a realizar de tipo INSERT
	 * @return boolean true si se ha realizado la insercion con exito, false si no
	 * @throws SQLException excepcion en caso de error al escribir en la base de datos
	 */
	public boolean insertarDatosBD(Connection con, String query) throws SQLException {
		Statement st = con.createStatement();
		
		try {
			st.executeUpdate(query);
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}
}
