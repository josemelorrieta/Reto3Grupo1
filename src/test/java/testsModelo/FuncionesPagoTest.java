package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.FuncionesPago;

public class FuncionesPagoTest {

	FuncionesPago func = new FuncionesPago();
	
	@Test
	public void sumarDineroPagoTest() {
		
		double valor = 0;
		double pagado = 1;
		
		assertEquals(func.sumarDineroPago(valor, pagado), 1, 0.01);
			
	}

}
