package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	
	public Connection conectarBD() {
		// Definición e inicialización de variables
		Connection conexion = null;
		ConexionFichero datosFichero = new ConexionFichero();
		
		final String NombreFichero = "src/main/java/modelo/datosBD.txt";
		String[] datos = datosFichero.cogerDatosDeFichero(NombreFichero);
		
		// Inicio del programa
		String url = "jdbc:mysql://" + datos[0] + "/" + datos[1];

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, datos[2], datos[3]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conexion;
	}
	
}
