package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesModelo {
	
	/**
	 * Metodo que increnta la longitud de un array de Strings
	 * @param lineas Array de Strings a incrementar
	 * @return aux Array de Strings incrementado
	 */
	public String[] incrementarArrayString(String[] arrayString) {
		//Declaracion e inicializacion de variables
		String[] aux = new String[arrayString.length + 1];
		
		//Inicio del programa
		for (int i=0;i<arrayString.length;i++) {
			aux[i] = arrayString[i];
		}
		
		return aux;
	}
	
	/**
	 * Metodo que increnta la longitud de un array de enteros
	 * @param arrayInt Array de enteros a incrementar
	 * @return aux Array de enteros incrementado
	 */
	public int[] incrementarArrayInt(int[] arrayInt) {
		//Declaracion e inicializacion de variables
		int[] aux = new int[arrayInt.length + 1];
		
		//Inicio del programa
		for (int i=0;i<arrayInt.length;i++) {
			aux[i] = arrayInt[i];
		}
		
		return aux;
	}
	
	/**
	 * Metodo que crea el billete que sera rellenado durante el proceso de compra
	 * @param miModelo Instancia de la clase Modelo
	 * @param codLinea String con el codigo de la linea seleccionada
	 * @return billete Billete creado para seguir con la compra
	 */
	public Billete crearBilleteActual(Modelo miModelo, String codLinea) {
		//Declaracion e inicializacion de variables		
		Billete billete;
		int numBillete = siguienteNumeroBillete();
		
		//Inicio del programa
		billete = new Billete(numBillete, null, codLinea, null, null, 0, 0, miModelo.cliente.getDni());
		
		return billete;
	}
	
	/**
	 * Metodo que devulve el siguiente numero de billete valido
	 * @return numeroBillete El siguiente numero de billete valido
	 * @throws SQLException Excepcion en caso de error al acceder a la base de datos 
	 */
	public int siguienteNumeroBillete() {
		//Declaración e inicialización de variables
		int numeroBillete = 0;
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		//Consulta a la base de datos
		String query = "SELECT MAX(Cod_Billete) FROM billete";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		//Inicio del programa
		//Si no hay resultados el siguiente es el 1
		try {
			while(rs.next()) {
				numeroBillete = rs.getInt("MAX(Cod_Billete)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		numeroBillete++;
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return numeroBillete;
	}
	
	/**
	 * Metodo que busca que autobus esta libre para seleccionarlo al billete
	 * @param codLinea String codigo de la linea de autobus
	 * @return codAutobus Codigo del autobus seleccionado
	 */
	public int codigoAutobusLibre(String codLinea) {
		//Declaración e inicialización de variables
		int codAutobus = 0;
		int[] autobusesPorLinea = null;
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		String query = "SELECT Cod_Bus FROM linea_autobus WHERE Cod_Linea = '" + codLinea + "'";
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		autobusesPorLinea = new int[0];
		
		//Cargamos los codigos de autobus de la linea
		try {
			while(rs.next()) {
				codAutobus = rs.getInt("Cod_Bus");
				autobusesPorLinea = incrementarArrayInt(autobusesPorLinea);
				autobusesPorLinea[autobusesPorLinea.length -1] = codAutobus;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//comprobamos las plazas de los autobuses para elegirlo
		
		
		
		return codAutobus;
	}

}
