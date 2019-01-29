package controlador;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.ConexionBD; 
import modelo.ConsultaBD;
import modelo.LineaAutobus;

public class FuncionesVarias {

	public void cargarLineass (LineaAutobus linea, String codLinea) {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD(); 
		int[] buses = new int[0];
		int[] busesAux;
		int cont = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select distinct `linea-parada`.Cod_Linea, `linea_autobus`.Cod_bus from `linea-parada`, `linea_autobus` where `linea-parada`.Cod_Linea = `linea_autobus`.Cod_Linea and `linea_autobus`.Cod_Linea = '"+codLinea+"';" );
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
}
