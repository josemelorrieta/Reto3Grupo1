package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ConexionBD;

public class TestConexionBD {

	@Test
	public void testConectarBD() {
		ConexionBD conexionBDTest = new ConexionBD();
		String urlTest = "localhost";
		String databaseTest ="termibus";
		String userTest = "hr";
		String passwordTest = "PepeJeans";
		String wrongPassword = "Levis";
		
		assertNotEquals(conexionBDTest.conectarBD(), null);
		assertEquals(conexionBDTest.conectarBD(), null);
	}

}
