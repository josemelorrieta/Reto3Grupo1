package controlador;

import java.sql.Connection;
import java.sql.ResultSet;

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

	
}
