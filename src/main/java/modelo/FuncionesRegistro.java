package modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

public class FuncionesRegistro {
	
	
	
	public Cliente registrarNuevoCliente(String dni, String nombre, String apellidos, String sexo, String fechaNacimiento, char[] pass) {
		char sexoBD = 0;
		String passBD = "";
		String query = "";
		
		if (sexo == "Hombre")
			sexoBD = 'V';
		else
			sexoBD = 'H';
		
		Cliente cliente = new Cliente(dni, nombre, apellidos, fechaNacimiento, sexoBD);
		passBD = DigestUtils.md5Hex(String.valueOf(pass));
		cliente.setContraseña(passBD);
		
		query = "INSERT into cliente VALUES ('" + dni + "', '" + nombre + "', '" + apellidos + "', '" + fechaNacimiento + "', '"+ sexoBD + "0', '" + passBD + "');";
		
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
 