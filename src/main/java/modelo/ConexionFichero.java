package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	public boolean imprimirBillete(Billete billeteIda, Billete billeteVuelta, Cliente cliente) {
		FileWriter fichero = null;	
		BufferedWriter linea = null;
		
		String sexo = "";
		double precio = 0;
		Calendar calendar = Calendar.getInstance();
		Date fechaAux = new Date();

		SimpleDateFormat sdfOrg = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		try {
			//generar fichero con el nombre compuesto por el dni y la fecha de ida del billete en la carpeta Temp
			fichero = new FileWriter("C:/Temp/" + billeteIda.getDni() + "-" + billeteIda.getFecha().replaceAll("-",  "") + "-" + billeteIda.getNumBillete() + ".txt");
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
			linea.write("Línea: " + billeteIda.getCodLinea());
			linea.newLine();
			linea.write("Origen: " + billeteIda.getOrigen());
			linea.newLine();
			linea.write("Destino: " + billeteIda.getDestino());
			linea.newLine();
			// Cambiamos el formato de fecha de yyyy-MM-dd a dd/MM/yyyy
			linea.write("Fecha ida: " + sdf.format(sdfOrg.parse(billeteIda.getFecha())));
			linea.newLine();
			if (billeteVuelta != null) {
				// Cambiamos el formato de fecha de yyyy-MM-dd a dd/MM/yyyy
				linea.write("Fecha vuelta: " + sdf.format(sdfOrg.parse(billeteVuelta.getFecha())));
				linea.newLine();
				precio = billeteIda.getPrecioTrayecto() + billeteVuelta.getPrecioTrayecto();
			} else {
				precio = billeteIda.getPrecioTrayecto();
			}
			linea.write("Precio: " + precio + "€");
			linea.newLine();
			linea.newLine();
			linea.write("DATOS DEL CLIENTE");
			linea.newLine();
			linea.write("-----------------");
			linea.newLine();
			linea.write("DNI: " + billeteIda.getDni());
			linea.newLine();
			linea.write("Nombre y Apellidos: " + cliente.getNombre() + " " + cliente.getApellidos());
			linea.newLine();
			// Cambiamos el formato de fecha de yyyy-MM-dd a dd/MM/yyyy
			linea.write("Fecha nacimiento: " + sdf.format(sdfOrg.parse(cliente.getFechaNacimiento())));
			linea.newLine();
			if (cliente.getSexo() == 'V') {
				sexo = "Hombre";
			} else {
				sexo = "Mujer";
			}
			linea.write("Sexo: " + sexo);
			linea.newLine();
			linea.newLine();
			linea.write("Fecha de la compra: " + sdf.format(calendar.getTime()).replaceAll("-", "/"));
			linea.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (fichero != null)
					fichero.close();
				if (linea != null)
					linea.close();
				} catch (Exception e) {
					e.getStackTrace();
					return false;
			}
		}
		return true;
	}
	
	
}
