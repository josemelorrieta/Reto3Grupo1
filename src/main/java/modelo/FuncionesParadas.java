package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesParadas {
	private Modelo miModelo;
	
	/**
	 * Constructor de la clase
	 * @param miModelo Clase Modelo general
	 */
	public FuncionesParadas(Modelo miModelo) {
		this.miModelo = miModelo;
	}
	
	/**
	 * Metodo para cargar las paradas de la linea seleccionada
	 * @param paradas Array de paradas a cargar
	 * @param linea String con el nombre de la linea seleccionada
	 * @return paradas Array rellanado con las paradas de la lineas seleccionada
	 */
	public Parada[] cargarParadas(Parada[] paradas, String linea) {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		String codLinea = nombreLineaACodLinea(linea);
		
		miModelo.billeteActual = miModelo.misFuncionesModelo.crearBilleteActual(miModelo, codLinea);
		
		String query = "SELECT parada.Cod_Parada, Calle, Nombre, Latitud, Longitud FROM parada, `linea-parada` WHERE parada.Cod_Parada=`linea-parada`.Cod_Parada and Cod_Linea='" + codLinea + "'" ;
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		paradas = null;
		paradas = new Parada[0];
		
		int codParada =  0;
		String calle = "";
		String nombre = "";
		float latitud = 0;
		float longitud = 0;
		
		try {
			while(rs.next()) {
				codParada = rs.getInt("Cod_Parada");
				calle = rs.getString("Calle");
				nombre = rs.getString("Nombre");
				latitud = rs.getFloat("Latitud");
				longitud = rs.getFloat("Longitud");
				
				//Incrementamos el array para meter el nuevo objeto
				paradas = incrementarArrayParada(paradas);
				paradas[paradas.length - 1] = new Parada(codParada, calle, nombre, latitud, longitud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return paradas;
	}
	
	/**
	 * Metodo para incrementar el array de paradas
	 * @param lineas Array de paradas a incrementar
	 * @return aux Array de paradas incrementado
	 */
	public Parada[] incrementarArrayParada(Parada[] paradas) {
		//Declaracion e inicializacion de variables
		Parada[] aux = new Parada[paradas.length + 1];
		
		//Inicio del programa
		for (int i=0;i<paradas.length;i++) {
			aux[i] = paradas[i];
		}
		
		return aux;
	}
	
	public String nombreLineaACodLinea(String linea) {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		String codLinea = "";
		
		String query = "SELECT Cod_Linea FROM linea WHERE Nombre='" + linea + "'" ;
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		try {
			while(rs.next()) {
				codLinea = rs.getString("Cod_Linea");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return codLinea;
		
	}
	
	/**
	 * Metodo que filtra las paradas de destino segun la parada de origen
	 * @param paradas Array de paradas de la linea
	 * @param indexOrigen Entero que define el indice de la linea de origen seleccionada
	 * @param paradasDestino Array de paradas generado para las paradas de destino
	 * @return
	 */
	public Parada[] filtrarParadasDestino(Parada[] paradas, int indexOrigen, Parada[] paradasDestino) {
		//Declaracion e inicializacion de variables
		paradasDestino = new Parada[0];
		
		//Inicio del programa
		for (int i=indexOrigen + 1;i<paradas.length;i++) {
			paradasDestino = incrementarArrayParada(paradasDestino);
			paradasDestino[paradasDestino.length - 1] = paradas[i];
		}
		
		return paradasDestino;
	}
	
	public double calcularPrecioBillete (String origen, String destino, Parada[] paradas) {
		//Declaracion e inicializacion de variables
		double precio = 0;
		float latitudOrigen = 0;
		float longitudOrigen = 0;
		float latitudDestino = 0;
		float longitudDestino = 0;
		double distancia = 0;
		//Falta calcular el consumo según el autobus
		final double consumoAutobus = 0.232;
		
		//Inicio del programa
		for (int i=0;i<paradas.length;i++) {
			if (paradas[i].getNombre() == origen) {
				latitudOrigen = paradas[i].getCoordX();
				longitudOrigen = paradas[i].getCoordY();
			} else if (paradas[i].getNombre() == destino) {
				latitudDestino = paradas[i].getCoordX();
				longitudDestino = paradas[i].getCoordY();
			}
		}
		
		//Calcular la distancia entre origen y destino
		distancia = distanciaEuclidea(latitudOrigen, longitudOrigen, latitudDestino, longitudDestino);
		//Pasas a Km
		distancia = distancia * 111.195;
		//Precio es distancia por consumo + beneficio 20%
		precio = distancia * consumoAutobus * 1.2;
		
		return precio;
	}
	
	public double distanciaEuclidea (float latitudOrigen, float longitudOrigen, float latitudDestino, float longitudDestino) {
		//Declaracion e inicializacion de variables
		double distancia = 0;
		
		//Inicio del programa
		distancia = Math.sqrt((Math.pow((latitudDestino - latitudOrigen), 2)) - (Math.pow((longitudDestino - longitudOrigen), 2)));
		
		return distancia;
	}
}
