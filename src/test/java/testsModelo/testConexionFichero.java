package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ConexionFichero;

public class testConexionFichero {

	@Test
	public void testCogerDatosDeFicheroTest() {
		ConexionFichero leerDatosFichero = new ConexionFichero();
		String ficheroTest = "src/main/java/modelo/datosBD.txt";
		String ficheroErrorTest = "";
		String[] datoTest = {"localhost", "termibus", "hr", "PepeJeans"};
		String[] resultado = leerDatosFichero.cogerDatosDeFichero(ficheroTest);
		System.out.println(resultado[3]);
		assertEquals(resultado[0], datoTest[0]);
		assertEquals(resultado[1], datoTest[1]);
		assertEquals(resultado[2], datoTest[2]);
		assertEquals(resultado[3], datoTest[3]);
		
		String[] resultadoError = leerDatosFichero.cogerDatosDeFichero(ficheroErrorTest);
		assertEquals(resultadoError[0], null);		
	}

}
