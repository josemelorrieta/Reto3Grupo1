package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ConexionFichero {
	
	public String[] cogerDatosDeFichero(String datosBD) {
		String[] datos = new String[4];
		FileReader fileReader = null;
		BufferedReader buffer = null;
		
		try {
			fileReader = new FileReader(datosBD);
			buffer = new BufferedReader(fileReader);
			String linea = "";
			String clave = "";
			String dato = "";
			
			while ((linea = buffer.readLine()) != null) {
				clave = linea.substring(0, linea.indexOf(":"));
				dato = linea.substring(linea.indexOf(":") + 2);
				
				switch (clave) {
					case "url": datos[0] = dato; break;
					case "database": datos[1] = dato; break;
					case "user": datos[2] = dato; break;
					case "password": datos[3] = dato; break;
				}
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
	
	public void imprimirBillete(String[] datosBillete) {
		/* datos Billete = "Linea", "Origen", "Destino", "Fecha ida", "Fecha vuelta" , "DNI", "Nombre", "Apellidos", "Fecha nacimiento", "Sexo", "Fecha compra" */
		FileWriter fichero = null;	
		BufferedWriter linea = null;
		
		try {
			fichero = new FileWriter("c:/Temp/" + datosBillete[5] + "-" + datosBillete[3].replaceAll("/",  "") + ".txt");
			linea = new BufferedWriter(fichero);
			
			linea.write("BILLETE");
			linea.newLine();
			linea.write("-------");
			linea.newLine();
			linea.newLine();
			linea.write("DATOS DEL TRAYECTO");
			linea.newLine();
			linea.write("------------------");
			linea.newLine();
			linea.write("Línea: " + datosBillete[0]);
			linea.newLine();
			linea.write("Origen: " + datosBillete[1]);
			linea.newLine();
			linea.write("Destino: " + datosBillete[2]);
			linea.newLine();
			linea.write("Fecha ida: " + datosBillete[3]);
			linea.newLine();
			if (datosBillete[4] != null) {
				linea.write("Fecha vuelta: " + datosBillete[4]);
				linea.newLine();
			}
			linea.newLine();
			linea.write("DATOS DEL CLIENTE");
			linea.newLine();
			linea.write("-----------------");
			linea.newLine();
			linea.write("DNI: " + datosBillete[5]);
			linea.newLine();
			linea.write("Nombre y Apellidos: " + datosBillete[6] + " " + datosBillete[7]);
			linea.newLine();
			linea.write("Fecha nacimiento: " + datosBillete[8]);
			linea.newLine();
			linea.write("Sexo: " + datosBillete[9]);
			linea.newLine();
			linea.newLine();
			linea.write("Fecha de la compra: " + datosBillete[10]);
			linea.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fichero != null)
					fichero.close();
				if (linea != null)
					linea.close();
				} catch (Exception e) {
					e.getStackTrace();
			}
		}
	}
	
	
}
