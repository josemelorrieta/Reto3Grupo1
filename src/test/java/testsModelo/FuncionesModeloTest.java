package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Billete;
import modelo.Cliente;
import modelo.FuncionesModelo;
import modelo.Modelo;

public class FuncionesModeloTest {

	FuncionesModelo func = new FuncionesModelo();
	private Modelo miModelo = new Modelo();
	Billete billeteTest = null;
	
	@Test
	public void incrementarArrayStringTest() {
	
		String[] arrayStr = new String[2] ;
		arrayStr = func.incrementarArrayString(arrayStr);
		
		assertEquals(arrayStr.length, 3);
	}
	
	@Test
	public void incrementarArrayIntTest() {
	
		int[] arrayInt = new int[2] ;
		int[] arrayInt2 = new int [1] ;
		arrayInt2 = func.incrementarArrayInt(arrayInt2);
		
		
		assertEquals(arrayInt.length, arrayInt2.length);
	}
	
	@Test
	public void crearBilleteActualTest() {
		
		String codLinea ="L1";
		miModelo.cliente = new Cliente("78878943G", "miguel", "lopez", "2018-02-08", 'M');
		billeteTest=func.crearBilleteActual(miModelo, codLinea);
		
		assertEquals(billeteTest.getCodLinea(), codLinea);
		assertEquals(billeteTest.getDni(), miModelo.cliente.getDni());
			
	}
	
	@Test
	public void siguienteNumeroBilleteTest() {
		
		assertEquals(func.siguienteNumeroBillete(), 1);
			
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

}
