package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase que crea una nueva conexion a la base de datos
 *
 */
public class ConexionBD {
	
	/**
	 * Crea una conexion con la base de datos
	 * @return conexion si todo ha ido bien, null si no
	 */
	public Connection conectarBD() {
		// Definición e inicialización de variables
		Connection conexion = null;
		ConexionFichero datosFichero = new ConexionFichero();
		
		//fuichero del que saca los datos de conexion
		final String NombreFichero = "datosBD.txt";
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
