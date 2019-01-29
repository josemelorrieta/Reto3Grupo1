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
import modelo.LineaAutobus;
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
			// Comprobamos la contrase�a
			passEncriptada = DigestUtils.md5Hex(String.valueOf(pass));
			if(comprobarPass(DNI, passEncriptada)) {
				nombre = rs.getString("Nombre");
				apellidos = rs.getString("Apellidos");
				fechaNacimiento = rs.getString("Fecha_nac");
				sexo = rs.getString("Sexo").charAt(0);
				cliente = new Cliente(DNI, nombre, apellidos,fechaNacimiento, sexo);			
			} else {
				JOptionPane.showMessageDialog(miVentana, "Contrase�a incorrecta", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
			}
			cont++;
		}
		if (cont == 0){
			JOptionPane.showMessageDialog(miVentana, "El DNI no existe", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
		}
		con.close();
		return cliente;
	}
 
	public boolean comprobarPass(String DNI, String pass) throws Exception {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		String passBD = "";
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select Contrase�a from cliente where DNI = '" + DNI + "';");
		while(rs.next()) {
			passBD = rs.getString("Contrase�a");
		}
		con.close();
		if(pass.equals(passBD)) 
			return true;
		else
			return false;

	} 
    
	// merge conflicts descomentar y arreglar
	
//	public String accionLogin(String dni, char[] pass) {
//    	String passEncriptada;
//    	// Comprobamos si existe el DNI en la base de datos 
//		try {
//			if(comprobarDNI(dni)) {
//				// Comprobamos la contrase�a
//				passEncriptada = DigestUtils.md5Hex(String.valueOf(pass));
//				if(comprobarPass(dni, passEncriptada)) {
//					return "Ok";
//				}
//				else
//					return "Contrase�a incorrecta";
//				
//			} else { 
//				return "El DNI introducido no existe";
//			}
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return "Hubo un error";
//    }
	
	public String[] municipioPorLinea(Connection con) {
		ConsultaBD miConsulta = new ConsultaBD();
		String[] municipios = new String[0];
		String[] municipiosAux;
		int cont = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select poblacion.Nombre from poblacion, `poblacion_parada`, parada, `linea-parada` where `linea-parada`.Cod_Parada = parada.Cod_parada and parada.Cod_Parada = `poblacion_parada`.Cod_Parada and `poblacion_parada`.Cod_Postal = poblacion.Cod_Postal and `linea-parada`.Cod_Linea = 'L1';");
		try {
			while (rs.next()) {
				municipiosAux = new String[municipios.length+1];
				for (int i = 0; i < municipios.length; i++) {
					municipiosAux[i] = municipios[i];
				}
				municipios = municipiosAux;
				municipios[cont] = rs.getString("Nombre");
				cont++;
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		return municipios; 	
	}

	public void cargarLineass (LineaAutobus linea) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		int[] buses = new int[0];
		int[] busesAux;
		int cont = 0;
		String codLinea = "";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select distinct `linea-parada`.Cod_Linea, `linea_autobus`.Cod_bus from `linea-parada`, `linea_autobus` where `linea-parada`.Cod_Linea = `linea_autobus`.Cod_Linea and `linea_autobus`.Cod_Linea = 'L1';" );
		try {
			while (rs.next()) {
				busesAux = new int[buses.length+1];
				for (int i = 0; i < buses.length; i++) {
					busesAux[i] = buses[i];
				}
				buses = busesAux;
				buses[cont] = rs.getInt("Cod_bus");
				codLinea = rs.getString("Cod_Linea");
				cont++;
			}
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
		linea.setCodAutobus(buses);
		linea.setMunicipios(municipioPorLinea(con));
		linea.setCodLinea(codLinea);
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Implementar un txt");
		}
	}
}
