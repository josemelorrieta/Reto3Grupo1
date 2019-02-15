package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionesParadas {
	
	private Modelo miModelo;
		
	/**
	 * Constructor de la clase
	 * @param miModelo Instancia del modelo
	 */
	public FuncionesParadas (Modelo miModelo) {
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
		
		//Buscamos el codigo de la linea a partir de su nombre
		String codLinea = nombreLineaACodLinea(linea);
		
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
	 * @param paradas Array de paradas a incrementar
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
	 * @return array de paradas con las paradas de destino
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
	
	/**
	 * Metodo que ordena las paradas por distancia a una parada de origen
	 * @param paradas Parada[] array de paradas a ordenar
	 * @return paradas Parada[] array de paradas ordenado
	 */
	public Parada[] ordenarParadas(Parada[] paradas) {
		//Declaracion e inicializacion de variables
		float[] distancias = new float[paradas.length];
		
		//Inicio del programa
		//Creamos un array paralelo de distancias
		distancias = arrayDistanciasParada(paradas, miModelo.misFuncionesModelo);
		
		//Ordenar el array mediante el array de distancias por el metodo de la burbuja
    	for (int x = 0; x < distancias.length; x++) {
	        for (int i = 0; i < distancias.length-x-1; i++) {
	            if(distancias[i+1] < distancias[i]){
	                float tmpDistancia = distancias[i+1];
	                Parada tmpParada = paradas[i+1];
	                distancias[i+1] = distancias[i];
	                paradas[i+1] = paradas[i];
	                distancias[i] = tmpDistancia;
	                paradas[i] = tmpParada;
	            }
	        }
	    }
    	
		return paradas;
	}
	
	/**
	 * Metodo que crea un array paralelo al de paradas con las distancias a la parada de origen
	 * @param paradas Parada[] array de paradas
	 * @param misFuncionesModelo instancia de la clase Funciones Modelo
	 * 
	 * @return distancias float[] array de distancias paralelo al de paradas
	 */
	public float[] arrayDistanciasParada(Parada[] paradas, FuncionesModelo misFuncionesModelo) {
		//Declaracion e inicializacion de variables
		float[] distancias = new float[paradas.length];
		//Coordenadas parada termibus (origen)
		float[] coordP1 = {paradas[0].getCoordX(), paradas[0].getCoordY()};
		float[] coordP2 = new float[2];
		
		//Inicio del programa
		for (int i=0;i<distancias.length;i++) {
			//Calculamos las coordenadas de la parada coorespondiente
			coordP2[0] = paradas[i].getCoordX();
			coordP2[1] = paradas[i].getCoordY();
			//Calculamos la distancia a la parada de origen Termibus
			distancias[i] = (float) misFuncionesModelo.distanciaEntreParadas(coordP1, coordP2);
		}
		
		return distancias;
	}
	
	/**
	 * Metodo para cargar las paradas de la linea seleccionada ordenadas por distancia a la parada de origen
	 * @param paradas Array de paradas a cargar
	 * @param linea String con el nombre de la linea seleccionada
	 * @return paradas Array rellanado con las paradas de la lineas seleccionada
	 */
	//Este metodo no se usa ya que hacemos los calculos en java al no poder testear la SELECT
	public Parada[] cargarParadasOrdenadas(Parada[] paradas, String linea) {
		//Declaracion e inicializacion de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		//Buscamos el codigo de la linea a partir de su nombre
		String codLinea = nombreLineaACodLinea(linea);
		
		String query = "SELECT parada.Cod_Parada, Calle, Nombre, Latitud, Longitud FROM parada, `linea-parada` WHERE `linea-parada`.Cod_Linea='" + codLinea + "' AND parada.Cod_Parada = `linea-parada`.Cod_Parada ORDER BY sqrt(power(latitud - (SELECT latitud FROM parada WHERE cod_parada = 1), 2)+power(longitud - (SELECT longitud FROM parada WHERE cod_parada = 1), 2))";
		
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
	
}
