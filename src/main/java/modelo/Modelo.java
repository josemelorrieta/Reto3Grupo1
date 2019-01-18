package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

import controlador.Controlador;
import vista.Vista;

public class Modelo {
	private Controlador miControlador;

	public Controlador getControlador() {
		return miControlador;
	}

	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public Connection conectarBD(String url, String database, String user, String password) {
		// Definición e inicialización de variables
		Connection conexion = null;
		final String NombreFichero = ""; //Falta definir el fichero de datos
		
		// Inicio del programa
		url = "jdbc:mysql://" + url + "/" + database;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conexion;
	}

}
