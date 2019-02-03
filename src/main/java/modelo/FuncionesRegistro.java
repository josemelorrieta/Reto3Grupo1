package modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Clase con las funcniones del panel de registro
 *
 */
public class FuncionesRegistro {
	public ConexionBD miConexion = new ConexionBD();
	public ConsultaBD miConsulta = new ConsultaBD();
	
	/**
	 * Metodo que registra un nuevo cliente a partir de los datos del formulario
	 * @param dni DNI del nuevo cliente
	 * @param nombre Nombre del nuevo cliente
	 * @param apellidos Apellidos del nuevo cliente
	 * @param sexo Sexo del nuevo cliente
	 * @param fechaNacimiento Fecha de nacimiento del nuevo cliente
	 * @param pass contrasena del nuevo cliente
	 * @return cliente Objeto con el nuevo cliente
	 * @throws SQLException excepcion en caso de error al acceder a la base de datos
	 * @throws ParseException excepcion en caso de error en la encriptacion de la contrasena
	 */
	public Cliente registrarNuevoCliente(String dni, String nombre, String apellidos, String sexo, String fechaNacimiento, char[] pass) throws SQLException, ParseException {
		//Declaracion e inicializacion de variables
		Connection con = miConexion.conectarBD();
		Cliente cliente;
		char sexoBD = 0;
		String passBD = "";
		String query = "";
		
		//Inicio del programa
		if (sexo == "Hombre")
			sexoBD = 'V';
		else
			sexoBD = 'M';
		
		//encriptar clave
		passBD = DigestUtils.md5Hex(String.valueOf(pass));
	
		query = "INSERT into cliente VALUES ('" + dni + "', '" + nombre + "', '" + apellidos + "', '" + fechaNacimiento + "', '"+ sexoBD + "', '" + passBD + "');";
		
		//Comprobar que la insercion de los datos en la BD es correcta
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
	
	/**
	 * Metodo que comprueba si existe el DNI
	 * @param dni DNI a comprobar
	 * @return boolean tru si existe en la base de datos, false si no
	 * @throws SQLException excepcion en caso de error al acceder a la base de datos
	 */
	public boolean verificarDNI (String dni) throws SQLException {
		//Declaración e inicialización de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from cliente where DNI = '" + dni + "';");
		
		// Si hay registros devuelve tru, si no false
		if (rs.last()) {
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}
	}

}
 