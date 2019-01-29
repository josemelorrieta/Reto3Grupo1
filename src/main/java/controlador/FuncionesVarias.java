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
import modelo.LineaAutobus;
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
