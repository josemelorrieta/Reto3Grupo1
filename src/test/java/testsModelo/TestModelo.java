package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Modelo;

public class TestModelo {

	@Test
	public void testConectarBD() {
		Modelo modeloTest = new Modelo();
		String urlTest = "localhost";
		String databaseTest ="termibus";
		String userTest = "hr";
		String passwordTest = "PepeJeans";
		String wrongPassword = "Levis";
		
		assertNotEquals(modeloTest.conectarBD(urlTest, databaseTest, userTest, passwordTest), null);
		assertEquals(modeloTest.conectarBD(urlTest, databaseTest, userTest, wrongPassword), null);
	}

}
