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
	 * Metodo que devuelve la distanca euclidea 
	 * @param coordP1 Array con la latitud y longitud de la parada de origen
	 * @param coordP2 Array con la latitud y longitud de la parada de destino
	 * @return distancia Distancia en grados terrestres entre las dos paradas
	 */
	public double distanciaEntreParadas (float[] coordP1, float[] coordP2) {
		//Declaración e inicialización de variables
		double distancia = 0;
		
		//Inicio del programa
		//Calcular distancia euclidea RAIZ((x1-x2)^2 + (y1-y2)^2)
		distancia = Math.sqrt(Math.pow((coordP2[0] - coordP1[0]), 2) + Math.pow((coordP2[1] - coordP1[1]), 2));
		
		return distancia;
	}
}
