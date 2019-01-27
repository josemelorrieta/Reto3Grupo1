package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.codec.digest.DigestUtils;

import modelo.ConexionBD;
import modelo.ConsultaBD;
import vista.Ventana;

public class FuncionesVarias {
	
	

	public boolean comprobarDNI(String DNI) throws Exception {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select DNI from cliente where DNI = '" + DNI + "';");
		 if (rs.last()) {
			 con.close();
			 return true;
		 } else {
			 con.close();
			 return false;
		 }
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
		return paradas.get(1) + " - " + paradas.get(rs.getRow()-1);
			
	}
 
	public boolean comprobarPass(String DNI, String pass) throws Exception {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		String passBD = "";
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select Contraseņa from cliente where DNI = '" + DNI + "';");
		while(rs.next()) {
			passBD = rs.getString("Contraseņa");
		}
		con.close();
		if(pass.equals(passBD)) 
			return true;
		else
			return false;
	}
    
	public String accionLogin(String dni, char[] pass) {
    	String passEncriptada;
    	// Comprobamos si existe el DNI en la base de datos 
		try {
			if(comprobarDNI(dni)) {
				// Comprobamos la contraseņa
				passEncriptada = DigestUtils.md5Hex(String.valueOf(pass));
				if(comprobarPass(dni, passEncriptada)) {
					return "Ok";
				}
				else
					return "Contraseņa incorrecta";
				
			} else { 
				return "El DNI introducido no existe";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "Hubo un error";
    }

	
}
