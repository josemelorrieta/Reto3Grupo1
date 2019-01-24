package controlador;

import java.sql.Connection;
import java.sql.ResultSet;

import modelo.ConexionBD;
import modelo.ConsultaBD;

public class FuncionesVarias {

//	public double DistanciaEuclidea(int coorXOrigen, int coordXDestino, int coorYOrigen, int coordYDestino) {
//		return Math.sqrt(Math.abs((Math.pow((coordXDestino-coorXOrigen), 2))) + Math.abs((Math.pow((coordYDestino-coorYOrigen), 2))));
//	}
	
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

	
}
