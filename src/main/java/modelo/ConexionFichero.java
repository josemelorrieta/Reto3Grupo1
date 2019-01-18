package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConexionFichero {
	
	public String[] cogerDatosDeFichero() {
		String[] datos = new String[4];
		File datosBD = null;
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			datosBD = new File("src/main/java/modelo/datosBD.txt");
			fileReader = new FileReader(datosBD);
			buffer = new BufferedReader(fileReader);
			String linea = "";
			int cont = 0;
			
			while ((linea = buffer.readLine()) != null) {
				datos[cont] = linea.substring(linea.indexOf(":") + 1);
				cont++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fileReader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return datos;
	}
	
	
}
