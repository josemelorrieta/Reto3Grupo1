package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Autobus;
import modelo.LineaAutobus;

public class AutobusTest {

	private int codAutobus = 01;
	private int plazas = 99;
	private float consumo = (float) 15.55;
	private String color = "verde";
	private Autobus autobus = new Autobus(codAutobus, plazas, consumo, color);
	
	@Test
	public void testConstructorAutobus() {
		assertEquals(codAutobus, autobus.getCodAutobus(), 01);
		assertEquals(plazas, autobus.getPlazas(), 99);
		assertEquals(consumo, autobus.getConsumo(), (float) 15.55);
		assertEquals(color, autobus.getColor(), "verde");
	}
	
	@Test
	public void testCodAutobus() {
		autobus.setCodAutobus(codAutobus);
		assertEquals(codAutobus, autobus.getCodAutobus());
	}
	
	@Test
	public void testPlazas() {
		autobus.setPlazas(plazas);
		assertEquals(plazas, autobus.getPlazas());
	}
	
	@Test
	public void testConsumo() {
		autobus.setConsumo(consumo);
		assertEquals(consumo, autobus.getConsumo(),  0);
	}
	
	@Test
	public void testColor() {
		autobus.setColor(color);
		assertEquals(color, autobus.getColor());
	}

}
