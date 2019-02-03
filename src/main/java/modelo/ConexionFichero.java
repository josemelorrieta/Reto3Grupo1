package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * Clase para acceso a lectura /escritura de ficheros
 *
 */
public class ConexionFichero {
	
	/**
	 * Lee los datos de conexion a la base de datos de un fichero de texto
	 * @param datosBD Cadena con la ruta y nombre del fichero de texto
	 * @return array con los datos extraidos del fichero de texto
	 */
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
	
	/**
	 * Metodo para escribir los datos del billete a un fichero de texto
	 * @param datosBillete array con los valores Linea, Origen, Destino, Fecha Ida, Fecha Vuelta, DNI, Nombre, Fecha Nacimiento, Sexo y Fecha de compra
	 */
	public void imprimirBillete(String[] datosBillete) {
		FileWriter fichero = null;	
		BufferedWriter linea = null;
		
		try {
			//generar fichero con el nombre compuesto por el dni y la fecha de ida del billete en la carpeta Temp
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
			linea.write("L�nea: " + datosBillete[0]);
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
