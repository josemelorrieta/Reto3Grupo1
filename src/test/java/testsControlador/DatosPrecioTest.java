package testsControlador;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.DatosPrecio;

public class DatosPrecioTest {

	DatosPrecio datosTest = new DatosPrecio();
	
	@Test
	public void testDatosPrecio() {
		assertNotEquals(datosTest.IVA, 0, 0.0001);
		assertNotEquals(datosTest.beneficio, 0, 0.0001);
		assertNotEquals(datosTest.precioGasolina, 0, 0.0001);
		
		assertEquals(datosTest.IVA, 1.21f, 0.0001);
		assertEquals(datosTest.beneficio, 1.2f, 0.0001);
		assertEquals(datosTest.precioGasolina, 1.8f, 0.0001);
	}

}
