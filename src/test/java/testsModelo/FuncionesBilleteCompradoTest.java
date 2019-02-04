package testsModelo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import modelo.FuncionesBilleteComprado;

public class FuncionesBilleteCompradoTest {
	FuncionesBilleteComprado func = new FuncionesBilleteComprado();
	
	@Test
	public void testSiguienteNumeroBillete() throws SQLException {
		int numeroBillete = 1;
		System.out.println(func.siguienteNumeroBillete());
		
		assertEquals(func.siguienteNumeroBillete(), numeroBillete);
		
	}

}
