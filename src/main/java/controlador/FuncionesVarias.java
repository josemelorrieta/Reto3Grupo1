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

	

//	//Este metodo se puede mjorar :P
//	public String CargarLineas() throws SQLException {
//		ConexionBD miConexion = new ConexionBD();
//		ConsultaBD miConsulta = new ConsultaBD();
//		Connection con = miConexion.conectarBD();
//		ResultSet rs = miConsulta.hacerConsultaBD(con, "select parada.Nombre from parada, linea, `linea-parada` where linea.Cod_Linea = `linea-parada`.Cod_Linea and `linea-parada`.Cod_Parada=parada.Cod_Parada and linea.Cod_Linea = 'L1' order BY sqrt(power(latitud - (SELECT latitud FROM parada WHERE cod_parada = 1), 2)+power(longitud - (SELECT longitud FROM parada WHERE cod_parada = 1), 2));");
//		ArrayList<String> paradas = new ArrayList<String>();
//		for (int i = 0; i<rs.getRow(); i++) {
//			paradas.add(i, rs.getString(i));
//		}
//		return paradas.get(0) + " - " + paradas.get(rs.getRow()-1);
//			
//	}
 
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
    
	// merge conflicts descomentar y arreglar
	
//	public String accionLogin(String dni, char[] pass) {
//    	String passEncriptada;
//    	// Comprobamos si existe el DNI en la base de datos 
//		try {
//			if(comprobarDNI(dni)) {
//				// Comprobamos la contraseña
//				passEncriptada = DigestUtils.md5Hex(String.valueOf(pass));
//				if(comprobarPass(dni, passEncriptada)) {
//					return "Ok";
//				}
//				else
//					return "Contraseña incorrecta";
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
<<<<<<< HEAD
	
	public void cargarLineass (LineaAutobus linea) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		int[] buses = new int[0];
		int[] busesAux;
		int cont = 0;
		int codLinea = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select distinct `linea-parada`.Cod_Linea, `linea_autobus`.Cod_bus from `linea-parada`, `linea_autobus` where `linea-parada`.Cod_Linea = `linea_autobus`.Cod_Linea and `linea_autobus`.Cod_Linea = 'L1';" );
		try {
			while (rs.next()) {
				busesAux = new int[buses.length+1];
				for (int i = 0; i < buses.length; i++) {
					busesAux[i] = buses[i];
				}
				buses = busesAux;
				buses[cont] = rs.getInt("Cod_bus");
				codLinea = rs.getInt("Cod_Linea");
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
	
	public String[] alargarArray(String[] lista) {
		String [] auxiliar = new String[lista.length+1];
		for (int i = 0; i < lista.length; i++) {
			auxiliar[i] = lista[i];
		}
		return auxiliar;
	}


	
=======
	 
>>>>>>> 87a11c90a03bf1a8dae8e0cf09ac133173bec896
}
