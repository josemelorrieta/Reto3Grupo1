package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import modelo.Cliente;
import modelo.ConexionBD;
import modelo.ConsultaBD;
import vista.Ventana;

public class FuncionesVarias {
	
	

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

	//Este metodo se puede mjorar :P
	public String CargarLineas() throws SQLException {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select parada.Nombre from parada, linea, `linea-parada` where linea.Cod_Linea = `linea-parada`.Cod_Linea and `linea-parada`.Cod_Parada=parada.Cod_Parada and linea.Cod_Linea = 'L1' order BY sqrt(power(latitud - (SELECT latitud FROM parada WHERE cod_parada = 1), 2)+power(longitud - (SELECT longitud FROM parada WHERE cod_parada = 1), 2));");
		ArrayList<String> paradas = new ArrayList<String>();
		for (int i = 0; i<rs.getRow(); i++) {
			paradas.add(i, rs.getString(i));
		}
		return paradas.get(0) + " - " + paradas.get(rs.getRow()-1);
			
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
