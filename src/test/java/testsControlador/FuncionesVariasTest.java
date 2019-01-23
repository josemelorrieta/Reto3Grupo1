package testsControlador;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.FuncionesVarias;

public class FuncionesVariasTest {

	private FuncionesVarias funcionesTest = new FuncionesVarias();
	
	@Test
	public void testDistanciaEuclidea() {
		int coorXOrigen = 7;
		int coordXDestino = 4;
		int coorYOrigen = 2;
		int coordYDestino = 9;

		assertEquals(funcionesTest.DistanciaEuclidea(coorXOrigen, coordXDestino, coorYOrigen, coordYDestino), 0, 0);
	}

}
