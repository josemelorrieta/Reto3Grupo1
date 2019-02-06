package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.FuncionesPago;

public class FuncionesPagoTest {

	FuncionesPago func = new FuncionesPago();
	
	@Test
	public void CalcularPrecioTest() {
		
		float distancia = 30;
		
		assertEquals(func.CalcularPrecio(distancia), 78.408, 0.01);
	}

}
