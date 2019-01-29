package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaBD {
	public ResultSet hacerConsultaBD (Connection con, String query) {
		ResultSet rs = null;
		
		try {
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		return rs;
	}
	
	public boolean insertarDatosBD(Connection con, String query) throws SQLException {
		Statement st = con.prepareStatement(query);
	
		try {
			st.executeQuery(query);
			return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
}
