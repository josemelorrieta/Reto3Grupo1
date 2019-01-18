package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Cliente;
import modelo.LineaAutobus;

public class LineaAutobusTest {

	private int codLinea= 01;
	private int codAutobus = 02;
	private String municipios = "Muni";
	private LineaAutobus lineaAutobus = new LineaAutobus(codLinea, codAutobus, municipios);
	
	@Test
	public void testConstructorLineaAutobus2() {
		assertEquals(codLinea, lineaAutobus.getCodLinea(), 01);
		assertEquals(codAutobus, lineaAutobus.getCodAutobus(), 02);
		assertEquals(municipios, lineaAutobus.getMunicipios(), "Muni");
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
	public void testmunicipios() {
		lineaAutobus.setMunicipios(municipios);
		assertEquals(municipios, lineaAutobus.getMunicipios());
	}
}
