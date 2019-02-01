package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Municipio;
import modelo.Parada;

public class ParadaTest {

	private int codParada = 1;
	private String calle = "Calle Wallaby, 42, Sidney";
	private String nombre = "Dentista";
	private float coordX = 9;
	private float coordY = 9;
	
	private Parada parada = new Parada(codParada, calle, nombre, coordX, coordY);
	
	@Test
	public void test() {
		assertEquals(codParada, parada.getCodParada(), 1);
		assertEquals(calle, parada.getCalle(), "Calle Wallaby, 42, Sidney");
		assertEquals(nombre, parada.getNombre(), "Dentista");
		assertEquals(coordX, parada.getCoordX(), 9);
		assertEquals(coordY, parada.getCoordY(), 9);
	}

	@Test
	public void testCodParada() {
		parada.setCodParada(codParada);
		assertEquals(codParada, parada.getCodParada());
	}
	
	@Test
	public void testCalle() {
		parada.setCalle(calle);
		assertEquals(calle, parada.getCalle());
	}
	
	
	@Test
	public void testNombre() {
		parada.setNombre(nombre);
		assertEquals(nombre, parada.getNombre());
	}
	
	@Test
	public void testCoordX() {
		parada.setCoordX(coordX);
		assertEquals(coordX, parada.getCoordX(), 0.001);
	}
	
	@Test
	public void testCoordY() {
		parada.setCoordY(coordY);
		assertEquals(coordY, parada.getCoordY(), 0.001);
	}
}
