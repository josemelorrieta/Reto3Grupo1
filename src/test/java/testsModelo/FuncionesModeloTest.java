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
	public void siguienteNumeroBilleteTest() {
		
		assertEquals(func.siguienteNumeroBillete(), 1);
			
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
	public void incrementarArrayIntTest() {
	
		int[] arrayInt = new int[2] ;
		int[] arrayInt2 = new int [1] ;
		arrayInt2 = func.incrementarArrayInt(arrayInt2);
		
		
		assertEquals(arrayInt.length, arrayInt2.length);
	}
	
	/*@Test
	public void codigoAutobusLibreTest() {
		
		String codLinea= "L1"; 
		int codAutobus = 1001;
		
		int[] autobusesPorLinea = new int [40];
		autobusesPorLinea[autobusesPorLinea.length -1] = codAutobus;
		
		assertEquals(func.codigoAutobusLibre(codLinea), codAutobus, 39);
	}*/
	
	

	
	

}
