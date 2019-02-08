package testsModelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import modelo.FuncionesFechas;

public class FuncionesFechasTest {

	FuncionesFechas func = new FuncionesFechas();
	
	Date fechaInicio = new Date();
	Date fechaLimite = new Date();
	Date fechaLimite2 = new Date();
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	public void testSetFechasDisponibles() throws ParseException {
		fechaInicio = format.parse("2019-02-04");
		fechaLimite = format.parse("2019-02-07");
		fechaLimite2 = format.parse("2019-02-08");
		
		assertEquals(func.setFechasDisponibles(fechaInicio), fechaLimite);
		assertNotEquals(func.setFechasDisponibles(fechaInicio), fechaLimite2);
	}
	
	@Test
	public void testDistanciaRecorrido() throws SQLException {
		String codP1 = "Termibus-Bilbao";
		String codP2 = "Ayuntamiento Plentzia";
		
		assertEquals(func.distanciaRecorrido(codP1, codP2), 15.912, 0.1);
	}
	
	@Test
	public void testCoordenadasParada() throws SQLException {
		String codParada = "1";
		float[] coordenadas = {43.2614f, -2.94974f};
		float[] resultado = func.coordenadasParada(codParada); 
				
		assertEquals(resultado[0], coordenadas[0], 0.1);
		assertEquals(resultado[1], coordenadas[1], 0.1);		
	}
	
	@Test
	public void testDistanciaEntreParadas() {
		//Declaración e inicialización de variables
		float[] origen = {0f,0f};
		float[] destino1 = {1f,1f};
		float[] destino2 = {0f,0f};
		//Test
		assertEquals(func.distanciaEntreParadas(origen, destino1), 1.4142, 0.1);
		assertEquals(func.distanciaEntreParadas(origen, destino2), 0, 0.1);
	}
	
	@Test
	public void testCalcularPrecioBillete() throws SQLException {
		int codAutobus = 1001;
		double distancia = 10;
		double precioBillete = 0.32 * 10 * 1.2 * 1.21;
		
		assertEquals(func.calcularPrecioBillete(codAutobus, distancia), precioBillete, 0.01);
	}
	
	@Test
	public void testConsumoAutobus() throws SQLException {
		int codAutobus = 1001;
		float consumo = 0.32f;
		
		assertEquals(func.consumoAutobus(codAutobus), consumo, 0.1);
	}
	
	@Test
	public void testbuscarAutobus() throws SQLException {
		int codAutobus = 1001;
		String codLinea= "L1";
		String fechaBillete= "2019-02-08";
		
		
		assertEquals(func.buscarAutobus(codLinea, fechaBillete), codAutobus, 40);
		
		
	}
	

}
