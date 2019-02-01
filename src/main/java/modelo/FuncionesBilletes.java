package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesBilletes {
	public Billete[] billetesCliente(Cliente cliente, Billete[] billetes) throws SQLException {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		billetes = null;
		billetes = new Billete[0];
		
		int numBillete;
		String fecha;
		String codLinea;
		int origen;
		int destino;
		int codAutobus;
		double precioTrayecto;
		String dni;
		
		String origenStr;
		String destinoStr;
		
		String query = "SELECT * FROM billete WHERE DNI='" + cliente.getDni() + "';";
		
		int cont = 0;
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);		
		
		while(rs.next()) {
			numBillete = rs.getInt("Cod_Billete");
			fecha = rs.getString("Fecha");
			codLinea = rs.getString("Cod_Linea");
			origen = rs.getInt("Cod_Parada_Inicio");
			destino = rs.getInt("Cod_Parada_Fin");
			codAutobus = rs.getInt("Cod_Bus");
			precioTrayecto = rs.getDouble("NTrayecto");
			dni = rs.getString("DNI");
			
			origenStr = nombreParada(origen);
			destinoStr = nombreParada(destino);
			
			billetes = incrementarArrayBilletes(billetes);
			billetes[cont] = new Billete(numBillete, fecha, codLinea, origenStr, destinoStr, codAutobus, precioTrayecto, dni);
			cont++;
		}
		if (cont == 0) {
			billetes = null;
		}
		
		return billetes;
	}
	
	public Billete[] incrementarArrayBilletes(Billete[] billetes) {
		Billete[] auxiliar = new Billete[billetes.length + 1];
		for (int i=0;i<billetes.length; i++) {
			auxiliar[i] = billetes[i];
		}
		return auxiliar;
	}
	
	public String nombreParada(int codParada) throws SQLException {
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		String nombreParada = "";
		
		String query = "SELECT Nombre FROM parada WHERE Cod_Parada = '" + codParada + "';";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			nombreParada = rs.getString("Nombre");
		}
		con.close();
		
		return nombreParada;
	}
}
