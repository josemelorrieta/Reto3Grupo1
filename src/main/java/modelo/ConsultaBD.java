package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
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
}
