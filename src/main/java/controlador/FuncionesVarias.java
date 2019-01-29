package controlador;


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
 

	 
}
