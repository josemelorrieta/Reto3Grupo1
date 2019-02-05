package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesLineas {
	private Modelo miModelo;
	
	public FuncionesLineas(Modelo miModelo) {
		this.miModelo = miModelo;
	}
	
	/**
	 * Metodo para cargar los nombres de lineas en el array nombreLineas
	 * @param nombreLineas Array donde guardar los nombres de linea 
	 * @return nombre lineas Array con los nombres de lineas
	 * @throws SQLException Excepcion en caso de error en el acceso a la base de datos
	 */
	public String[] cargarNombreLineas(String[] nombreLineas) throws SQLException {
		//Definicion e incializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		String query = "SELECT Nombre FROM linea";
		
		String nombre = "";
		
		//Inicio del proograma		
		nombreLineas = null;
		nombreLineas = new String[0];
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		//Recorremos los resultados de la consulta
		while(rs.next()) {
			nombre = rs.getString("Nombre");
			//En cada resultado incrementamos el array en una posición para meter el siguiente nombre
			nombreLineas = miModelo.misFuncionesModelo.incrementarArrayString(nombreLineas);
			nombreLineas[nombreLineas.length - 1] = nombre;
		}
		
		con.close();
		
		return nombreLineas;
	}

}
