package testsControlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import modelo.FuncionesDevolucion;
import modelo.FuncionesPago;
import modelo.Modelo;

public class FuncionesPagoTest {
	
	private Modelo miModelo = new Modelo();
	private FuncionesPago pagoTest = new FuncionesPago();
	private FuncionesDevolucion cambiosTest = new FuncionesDevolucion(miModelo);
	//private FuncionesPago leerDatosMock = mock(FuncionesPago.class);
	
	
	@Test
	public void testCalcularPrecio() {
		float distancia = 5;
		
		assertEquals(13.068f, (float)pagoTest.CalcularPrecio(distancia), 0.0001);
		assertNotEquals(11f, (float)pagoTest.CalcularPrecio(distancia), 0.0001);
	}
	
	// Test de los cambios en los puntos críticos de cada billete/moneda
	
	@Test
	public void testCambiosMayor500() {
		float dinero = 523f;
		int [] cambiosTest = cambiosTest.(dinero);
		
		assertEquals(1, cambiosTest[0], 0.0001);
		assertNotEquals(11f, cambiosTest[0], 0.0001);
	}
	
	@Test
	public void testCambiosIgual500() {
		float dinero = 500f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[0], 0.0001);
		assertNotEquals(11f, cambiosTest[0], 0.0001); 
	}
	
	@Test
	public void testCambiosMayor200() {
		float dinero = 325f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[1], 0.0001);
		assertNotEquals(11f, cambiosTest[1], 0.0001);
	}
	
	@Test
	public void testCambiosIgual200() {
		float dinero = 300f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[1], 0.0001);
		assertNotEquals(11f, cambiosTest[1], 0.0001);
	}
	
	@Test
	public void testCambiosMayor100() {
		float dinero = 120f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[2], 0.0001);
		assertNotEquals(11f, cambiosTest[2], 0.0001);
	}
	
	@Test
	public void testCambiosIgual100() {
		float dinero = 100f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[2], 0.0001);
		assertNotEquals(11f, cambiosTest[2], 0.0001);
	}
	
	@Test
	public void testCambiosMayor50() {
		float dinero = 75f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[3], 0.0001);
		assertNotEquals(11f, cambiosTest[3], 0.0001);
	}
	
	@Test
	public void testCambiosIgual50() {
		float dinero = 50f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[3], 0.0001);
		assertNotEquals(11f, cambiosTest[3], 0.0001);
	}
	
	@Test
	public void testCambiosMayor20() {
		float dinero = 35f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[4], 0.0001);
		assertNotEquals(11f, cambiosTest[4], 0.0001);
	}
	
	@Test
	public void testCambiosIgual20() {
		float dinero = 20f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[4], 0.0001);
		assertNotEquals(11f, cambiosTest[4], 0.0001);
	}
	
	@Test
	public void testCambiosMayor10() {
		float dinero = 15f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[5], 0.0001);
		assertNotEquals(11f, cambiosTest[5], 0.0001);
	}
	
	@Test
	public void testCambiosIgual10() {
		float dinero = 10f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[5], 0.0001);
		assertNotEquals(11f, cambiosTest[5], 0.0001);
	}
	
	@Test
	public void testCambiosMayor5() {
		float dinero = 7f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[6], 0.0001);
		assertNotEquals(11f, cambiosTest[6], 0.0001);
	}
	
	@Test
	public void testCambiosIgual5() {
		float dinero = 5f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[6], 0.0001);
		assertNotEquals(11f, cambiosTest[6], 0.0001);
	}
	
	@Test
	public void testCambiosMayor2() {
		float dinero = 3f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[7], 0.0001);
		assertNotEquals(11f, cambiosTest[7], 0.0001);
	}
	
	@Test
	public void testCambiosIgual2() {
		float dinero = 2f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[7], 0.0001);
		assertNotEquals(11f, cambiosTest[7], 0.0001);
	}
	
	@Test
	public void testCambiosMayor1() {
		float dinero = 1.5f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[8], 0.0001);
		assertNotEquals(11f, cambiosTest[8], 0.0001);
	}
	
	@Test
	public void testCambiosIgual1() {
		float dinero = 1f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[8], 0.0001);
		assertNotEquals(11f, cambiosTest[8], 0.0001);
	}
	
	@Test
	public void testCambiosMayor50c() {
		float dinero = 0.75f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[9], 0.0001);
		assertNotEquals(11f, cambiosTest[9], 0.0001);
	}
	
	@Test
	public void testCambiosIgual50c() {
		float dinero = 0.50f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[9], 0.0001);
		assertNotEquals(11f, cambiosTest[9], 0.0001);
	}
	
	@Test
	public void testCambiosMayor20c() {
		float dinero = 0.30f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[10], 0.0001);
		assertNotEquals(11f, cambiosTest[10], 0.0001);
	}
	
	@Test
	public void testCambiosIgual20c() {
		float dinero = 0.20f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[10], 0.0001);
		assertNotEquals(11f, cambiosTest[10], 0.0001);
	}
	
	@Test
	public void testCambiosMayor10c() {
		float dinero = 0.15f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[11], 0.0001);
		assertNotEquals(11f, cambiosTest[11], 0.0001);
	}
	
	@Test
	public void testCambiosIgual10c() {
		float dinero = 0.10f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[11], 0.0001);
		assertNotEquals(11f, cambiosTest[11], 0.0001);
	}
	
	@Test
	public void testCambiosMayor5c() {
		float dinero = 0.07f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[12], 0.0001);
		assertNotEquals(11f, cambiosTest[12], 0.0001);
	}
	
	@Test
	public void testCambiosIgual5c() {
		float dinero = 0.05f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[12], 0.0001);
		assertNotEquals(11f, cambiosTest[12], 0.0001);
	}
	
	@Test
	public void testCambiosMayor2c() {
		float dinero = 0.03f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[13], 0.0001);
		assertNotEquals(11f, cambiosTest[13], 0.0001);
	}
	
	@Test
	public void testCambiosIgual2c() {
		float dinero = 0.02f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[13], 0.0001);
		assertNotEquals(11f, cambiosTest[13], 0.0001);
	}
	
	@Test
	public void testCambiosIgual1c() {
		float dinero = 0.01f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(1, cambiosTest[14], 0.0001);
		assertNotEquals(11f, cambiosTest[14], 0.0001);
	}
}
