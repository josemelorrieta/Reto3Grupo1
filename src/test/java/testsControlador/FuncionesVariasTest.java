package testsControlador;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.FuncionesVarias;

public class FuncionesVariasTest {

	private FuncionesVarias funcionesTest = new FuncionesVarias();

	@Test
	public void testComprobarDNI() throws Exception {
		String DNI = "45899844Y";
		String DNI2 = "45894Y";
		
		assertEquals(funcionesTest.comprobarDNI(DNI), true);
		assertEquals(funcionesTest.comprobarDNI(DNI2), false);
	}

	
	@Test
	public void testCargarLineas() throws Exception {
		System.out.println(funcionesTest.CargarLineas());
		assertEquals(funcionesTest.CargarLineas(), "Termibus-Bilbao - Asilo Barrika");
	}
}
