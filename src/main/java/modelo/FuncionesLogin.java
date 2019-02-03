package modelo;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import vista.Ventana;

/**
 * Clase con las funciones del panel de login
 *
 */
public class FuncionesLogin {
	
	/**
	 * Metodo que comprueba el DNI y la contrasena del cliente que quiere logear
	 * @param DNI DNI del cliente
	 * @param pass contrasena del cliente
	 * @param cliente instancia del objeto cliente general de la aplicacion
	 * @param miVentana instancia de la ventana principal
	 * @return cliente objeto actualizado al nuevo cliente logeado
	 * @throws Exception excepcion en caso de error en el acceso a la base de datos
	 */
	public Cliente comprobarDNI(String DNI, char[] pass, Cliente cliente, Ventana miVentana) throws Exception {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		String nombre;
		String apellidos;
		String fechaNacimiento;
		char sexo;	

    	String passEncriptada;
		
    	//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from cliente where DNI = '" + DNI + "';");
		int cont = 0;
		while(rs.next()) {
			// Comprobamos la contraseña
			passEncriptada = DigestUtils.md5Hex(String.valueOf(pass));
			//Si DNI y contrasena coinciden creamos el cliente
			if(comprobarPass(DNI, passEncriptada)) {
				nombre = rs.getString("Nombre");
				apellidos = rs.getString("Apellidos");
				fechaNacimiento = rs.getString("Fecha_nac");
				sexo = rs.getString("Sexo").charAt(0);
				cliente = new Cliente(DNI, nombre, apellidos,fechaNacimiento, sexo);			
			} else {
				JOptionPane.showMessageDialog(miVentana, "Contraseña incorrecta", "¡Atención!", JOptionPane.WARNING_MESSAGE);
			}
			cont++;
		}
		if (cont == 0){
			JOptionPane.showMessageDialog(miVentana, "El DNI no existe", "¡Atención!", JOptionPane.WARNING_MESSAGE);
		}
		con.close();
		return cliente; 
	}
	
	/**
	 * Metodo que comprueba la contrasena a partir de un DNI
	 * @param DNI DNI del cliente a comprobar la contrasena
	 * @param pass Contrasena a comprobar
	 * @return boolean true si la contrasena y DNi coinciden, false si no
	 * @throws Exception excepcion en caso de error al acceder a la base de datos
	 */
	public boolean comprobarPass(String DNI, String pass) throws Exception {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		String passBD = "";
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select Contraseña from cliente where DNI = '" + DNI + "';");
		while(rs.next()) {
			passBD = rs.getString("Contraseña");
		}
		con.close();
		if(pass.equals(passBD)) 
			return true;
		else
			return false;
	}
}
 