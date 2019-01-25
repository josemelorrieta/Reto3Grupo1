package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.ConexionBD;
import modelo.ConsultaBD;

public class FuncionesVarias {

	public boolean comprobarDNI(String DNI) throws Exception {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select DNI from cliente where DNI = '" + DNI + "';");
		 if (rs.last())
			 return true;
		 else
			 return false; 
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
	
    public String hash(String stringToHash)  {
    	final char[] hexa = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(stringToHash.getBytes());
            StringBuilder sb = new StringBuilder(2 * bytes.length);
            for (int i = 0; i < bytes.length; i++) {
                int low = (int)(bytes[i] & 0x0f);
                int high = (int)((bytes[i] & 0xf0) >> 4);
                sb.append(hexa[high]);
                sb.append(hexa[low]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            //exception handling goes here
            return null;
        }
    }
	
}
