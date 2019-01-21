package testsControlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import controlador.FuncionesPago;

public class FuncionesPagoTest {

	FuncionesPago pagoTest = new FuncionesPago();
	private FuncionesPago leerDatosMock = mock(FuncionesPago.class);
	
	@Test
	public void testCalcularPrecio() {
		float distancia = 5;
		
		assertEquals(13.068f, (float)pagoTest.CalcularPrecio(distancia), 0.0001);
		assertNotEquals(11f, (float)pagoTest.CalcularPrecio(distancia), 0.0001);
	}

	@Test
	public void testCambios() {
		float dinero = 5.45f;
		int [] cambiosTest = pagoTest.Cambios(dinero);
		
		assertEquals(0, cambiosTest[0], 0.0001);
		assertEquals(0, cambiosTest[1], 0.0001);
		assertEquals(0, cambiosTest[2], 0.0001);
		assertEquals(0, cambiosTest[3], 0.0001);
		assertEquals(0, cambiosTest[4], 0.0001);
		assertEquals(0, cambiosTest[5], 0.0001);
		assertEquals(1, cambiosTest[6], 0.0001);
		assertEquals(0, cambiosTest[7], 0.0001);
		assertEquals(0, cambiosTest[8], 0.0001);
		assertEquals(0, cambiosTest[9], 0.0001);
		assertEquals(2, cambiosTest[10], 0.0001);
		assertEquals(0, cambiosTest[11], 0.0001);
		assertEquals(1, cambiosTest[12], 0.0001);
		assertEquals(0, cambiosTest[13], 0.0001);
		assertEquals(0, cambiosTest[14], 0.0001);
		
		assertNotEquals(11f, cambiosTest[0], 0.0001);
		assertNotEquals(11f, cambiosTest[1], 0.0001);
		assertNotEquals(11f, cambiosTest[2], 0.0001);
		assertNotEquals(11f, cambiosTest[3], 0.0001);
		assertNotEquals(11f, cambiosTest[4], 0.0001);
		assertNotEquals(11f, cambiosTest[5], 0.0001);
		assertNotEquals(11f, cambiosTest[6], 0.0001);
		assertNotEquals(11f, cambiosTest[7], 0.0001);
		assertNotEquals(11f, cambiosTest[8], 0.0001);
		assertNotEquals(11f, cambiosTest[9], 0.0001);
		assertNotEquals(11f, cambiosTest[10], 0.0001);
		assertNotEquals(11f, cambiosTest[11], 0.0001);
		assertNotEquals(11f, cambiosTest[12], 0.0001);
		assertNotEquals(11f, cambiosTest[13], 0.0001);
		assertNotEquals(11f, cambiosTest[14], 0.0001);
	}
	
}
