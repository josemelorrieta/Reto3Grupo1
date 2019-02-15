package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Billete;

public class BilleteTest {

	private int numBillete = 01;
	private String fecha = "1/1/0001";
	private String codLinea = "L3";
	private String origen = "Mi casa";
	private String destino = "La playita";
	private int codAutobus = 0001;
	private double precioTrayecto = 1.75;
	private String dni = "12345678Z";
	private Billete billete = new Billete(numBillete, fecha, codLinea, origen, destino, codAutobus, precioTrayecto, dni);
	
	@Test
	public void testConstructorBillete2() {
		assertEquals(numBillete, billete.getNumBillete(), 01);
		assertEquals(fecha, billete.getFecha(), "1/1/0001");
		assertEquals(codLinea, billete.getCodLinea(), "L3");
		assertEquals(origen, billete.getOrigen(), "Mi casa");
		assertEquals(destino, billete.getDestino(), "La playita");
		assertEquals(codAutobus, billete.getCodAutobus(), 0001); 
		assertEquals(precioTrayecto, billete.getPrecioTrayecto(), 1.75);
		assertEquals(dni, billete.getDni(), "12345678Z");
	}

	@Test
	public void testNumBillete() {
		billete.setNumBillete(numBillete);
		assertEquals(numBillete, billete.getNumBillete());
	}
	
	@Test
	public void testFecha() {
		billete.setFecha(fecha);
		assertEquals(fecha, billete.getFecha());
	}
	
	@Test
	public void testCodLinea() {
		billete.setCodLinea(codLinea);
		assertEquals(codLinea, billete.getCodLinea());
	}
	
	@Test
	public void testOrigen() {
		billete.setOrigen(origen);
		assertEquals(origen, billete.getOrigen());
	}
	
	@Test
	public void testDestino() {
		billete.setDestino(destino);
		assertEquals(destino, billete.getDestino());
	}
	
	@Test
	public void testCodAutobus() {
		billete.setCodAutobus(codAutobus);
		assertEquals(codAutobus, billete.getCodAutobus());
	}
	
	@Test
	public void testPrecioTrayecto() {
		billete.setPrecioTrayecto(precioTrayecto);
		assertEquals(precioTrayecto, billete.getPrecioTrayecto(), 0);
	}
	
	@Test
	public void testDni() {
		billete.setDni(dni);
		assertEquals(dni, billete.getDni());
	}
}
