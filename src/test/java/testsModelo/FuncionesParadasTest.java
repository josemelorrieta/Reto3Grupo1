package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.FuncionesParadas;
import modelo.Modelo;
import modelo.Parada;

public class FuncionesParadasTest {

	private Modelo miModelo = new Modelo();
	private FuncionesParadas funcionesParadas = new FuncionesParadas(miModelo);
	
	@Test
	public void testCargarParadas() {
		Parada[] paradasTest = null;
		Parada paradaTest = new Parada(1, "Luis Briñas", "Termibus-Bilbao", 43.2614f, -2.94974f);
		paradasTest = funcionesParadas.cargarParadas(paradasTest, "L1");
		
		assertEquals(paradasTest[0], paradaTest);
	}
	
	@Test
	public void testIncrementarArrayParadas() {
		Parada[] paradasTest = new Parada[0];
		String[] paradasTest2 = new String[1];
		paradasTest = funcionesParadas.incrementarArrayParada(paradasTest);
		
		assertEquals(paradasTest.length, paradasTest2.length);
	}
	
	@Test
	public void testNombreLinaACodLinea() {
		String codLineaTest = "";
		codLineaTest = funcionesParadas.nombreLineaACodLinea("Termibus-Plentzia");
		
		assertEquals(codLineaTest, "L1");
	}

}
