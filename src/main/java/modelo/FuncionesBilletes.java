package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que contiene las funciones relativas al panel de billetes
 *
 */
public class FuncionesBilletes {
	/**
	 * Metodo que crea el array de billetes a partir del DNI de el cliente logeado
	 * @param cliente Objeto cliente que se ha logeado en la aplicacion
	 * @param billetes array de Billete donde se almacenaran los billetes del cliente logeado
	 * @return billetes array de billetes del cliente logeado
	 * @throws SQLException excepcion en caso de error en el acceso a la base de datos
	 */
	public Billete[] billetesCliente(Cliente cliente, Billete[] billetes) throws SQLException {
		//Declaracion e incializacion de variables
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
		
		//Inicio del programa
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
			
			//Incrementar posiciones del arraty en uno para alojar el nuevo billete
			billetes = incrementarArrayBilletes(billetes);
			billetes[cont] = new Billete(numBillete, fecha, codLinea, origenStr, destinoStr, codAutobus, precioTrayecto, dni);
			cont++;
		}
		//Si no hay billetes en la busqueda devuelve null
		if (cont == 0) {
			billetes = null;
		}
		
		return billetes;
	}
	
	/**
	 * Incremento del array de billetes en un posicion para un nuevo billete
	 * @param billetes array de billetes del cliente a ser incrementado
	 * @return auxiliar array de billetes igual al de entrada con una posicion vacia al fina
	 */
	public Billete[] incrementarArrayBilletes(Billete[] billetes) {
		//Declaracion e inicializacion de variables
		Billete[] auxiliar = new Billete[billetes.length + 1];
		
		//Inicio del programa
		//copia del array de entrada en el de salida
		for (int i=0;i<billetes.length; i++) {
			auxiliar[i] = billetes[i];
		}
		return auxiliar;
	}
	
	/**
	 * Metodo que devuelve le nombre de una parada a partir de un codigo de parada
	 * @param codParada codigo de parada para devolver su nombre
	 * @return nombre de la parada correspondiente al codigo recibido
	 * @throws SQLException excepcion en caso de error al acceder a la base de datos
	 */
	public String nombreParada(int codParada) throws SQLException {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		String nombreParada = "";
		
		//Inicio del programa
		String query = "SELECT Nombre FROM parada WHERE Cod_Parada = '" + codParada + "';";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			nombreParada = rs.getString("Nombre");
		}
		con.close();
		
		return nombreParada;
	}
}
