package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que contiene los metodos del panel de billete comprado
 *
 */
public class FuncionesBilleteComprado {

	/**
	 * Metodo que devulve el siguiente numero de billete valido
	 * @return numeroBillete El siguiente numero de billete valido
	 * @throws SQLException Excepcion en caso de error al acceder a la base de datos 
	 */
	public int siguienteNumeroBillete() throws SQLException {
		//Declaración e inicialización de variables
		int numeroBillete = 0;
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		//Consulta a la base de datos
		String query = "SELECT MAX(Cod_Billete) FROM billete";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		//Inicio del programa
		//Si no hay resultados el siguiente es el 1
		while(rs.next()) {
			numeroBillete = rs.getInt("MAX(Cod_Billete)");
		}
		
		numeroBillete++;
		con.close();
		
		return numeroBillete;
	}
}
