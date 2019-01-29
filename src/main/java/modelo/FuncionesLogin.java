package modelo;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import vista.Ventana;

public class FuncionesLogin {
	
	public Cliente comprobarDNI(String DNI, char[] pass, Cliente cliente, Ventana miVentana) throws Exception {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		String nombre;
		String apellidos;
		String fechaNacimiento;
		char sexo;	

    	String passEncriptada;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from cliente where DNI = '" + DNI + "';");
		int cont = 0;
		while(rs.next()) {
			// Comprobamos la contraseña
			passEncriptada = DigestUtils.md5Hex(String.valueOf(pass));
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
	
	public boolean comprobarPass(String DNI, String pass) throws Exception {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		String passBD = "";
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
 