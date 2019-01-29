package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Autobus;
import modelo.Municipio;

public class MunicipioTest {

	private String nombre = "Shiganshina";
	private int codPostal = 99;
	private int[] paradas;
	private Municipio municipio = new Municipio(nombre, codPostal, paradas);
	
	@Test
	public void testConstructorMunicipio() {
		assertEquals(nombre, municipio.getNombre(), "Shiganshina");
		assertEquals(codPostal, municipio.getCodPostal(), 99);
		assertArrayEquals(paradas, municipio.getParadas());
	}
	
	@Test
	public void testNombre() {
		municipio.setNombre(nombre);
		assertEquals(nombre, municipio.getNombre());
	}
	
	@Test
	public void testCodPostal() {
		municipio.setCodPostal(codPostal);
		assertEquals(codPostal, municipio.getCodPostal());
	}
	
	@Test 
	public void testParadas() {
		municipio.setParadas(paradas);
		assertEquals(paradas, municipio.getParadas());
	}

}
 