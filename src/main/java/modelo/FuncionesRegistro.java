package modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.commons.codec.digest.DigestUtils;

public class FuncionesRegistro {
	public ConexionBD miConexion = new ConexionBD();
	public ConsultaBD miConsulta = new ConsultaBD();
	
	public Cliente registrarNuevoCliente(String dni, String nombre, String apellidos, String sexo, String fechaNacimiento, char[] pass) throws SQLException, ParseException {
		Connection con = miConexion.conectarBD();
		Cliente cliente;
		char sexoBD = 0;
		String passBD = "";
		String query = "";
		
		if (sexo == "Hombre")
			sexoBD = 'V';
		else
			sexoBD = 'M';
		
		passBD = DigestUtils.md5Hex(String.valueOf(pass));
	
		query = "INSERT into cliente VALUES ('" + dni + "', '" + nombre + "', '" + apellidos + "', '" + fechaNacimiento + "', '"+ sexoBD + "', '" + passBD + "');";
		
		if (miConsulta.insertarDatosBD(con, query)) {
			cliente = new Cliente(dni, nombre, apellidos, fechaNacimiento, sexoBD);
			passBD = DigestUtils.md5Hex(String.valueOf(pass));
			cliente.setContraseña(passBD);
		} else {
			cliente = null;
		}
		con.close();
		
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
 