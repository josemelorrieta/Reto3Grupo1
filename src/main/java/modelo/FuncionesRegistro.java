package modelo;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesRegistro {
	
	
	
	public Cliente registrarNuevoCliente() {
		Cliente cliente = null;
		
		System.out.println("Nuevo registro");
		return cliente;
	}
	
	public boolean verificarDNI (String dni) throws SQLException {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from cliente where DNI = '" + dni + "';");
		
		if (rs.last()) {
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}
	}
}
