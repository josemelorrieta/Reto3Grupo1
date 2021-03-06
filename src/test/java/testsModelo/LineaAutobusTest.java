package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.LineaAutobus;

public class LineaAutobusTest {

	private String codLinea= "L1";
	private int[] codAutobus;
	private String[] municipios;
	private LineaAutobus lineaAutobus = new LineaAutobus(codLinea, codAutobus, municipios);
	
	@Test
	public void testConstructorLineaAutobus2() {
		
		assertEquals(codLinea, lineaAutobus.getCodLinea(), "L1");
		assertArrayEquals(codAutobus, lineaAutobus.getCodAutobus());
		assertArrayEquals(municipios, lineaAutobus.getMunicipios());
		
	}

	@Test
	public void testCodLinea() { 
		lineaAutobus.setCodLinea(codLinea);
		assertEquals(codLinea, lineaAutobus.getCodLinea());
	}
	
	@Test
	public void testCodAutobus() {
		lineaAutobus.setCodAutobus(codAutobus);
		assertEquals(codAutobus, lineaAutobus.getCodAutobus());
	}
	
	@Test
	public void testMunicipios() {
		lineaAutobus.setMunicipios(municipios);
		assertArrayEquals(municipios, lineaAutobus.getMunicipios());
	}
}
  