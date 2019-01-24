package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;

import modelo.ConexionBD;
import modelo.ConsultaBD;

public class FuncionesVarias {

	public double DistanciaEuclidea(int coorXOrigen, int coordXDestino, int coorYOrigen, int coordYDestino) {
		return Math.sqrt(Math.abs((Math.pow((coordXDestino-coorXOrigen), 2))) + Math.abs((Math.pow((coordYDestino-coorYOrigen), 2))));
	}
	
	public boolean comprobarDBI(String DNI) throws Exception {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select DNI from cliente where DNI = '" + DNI + "';");
		 if (rs.last())
			 return true;
		 else
			 return false;
	}

    public  String hash(String stringToHash)  {
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
