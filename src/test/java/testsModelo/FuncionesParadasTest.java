package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.FuncionesParadas;
import modelo.Parada;

public class FuncionesParadasTest {

	private FuncionesParadas funcionesParadas = new FuncionesParadas();
	
	@Test
	public void testCargarParadas() {
		Parada[] paradasTest1 = new Parada[0];
		Parada paradaTest = new Parada(1, "Luis Briñas", "Termibus-Bilbao", 43.2614f, -2.94974f);
		paradasTest1 = funcionesParadas.cargarParadas(paradasTest1, "L1");
		
		assertEquals(paradasTest1[0], paradaTest);
	}
	
	@Test
	public void testIncrementarArrayParadas() {
		Parada[] paradasTest = new Parada[0];
		String[] paradasTest2 = new String[1];
		paradasTest = funcionesParadas.incrementarArrayParada(paradasTest);
		
		assertEquals(paradasTest.length, paradasTest2.length);
	}
	
	@Test
	public void testNombreLineaACodLinea() {
		String codLineaTest = "";
		codLineaTest = funcionesParadas.nombreLineaACodLinea("Termibus-Plentzia");
		
		assertEquals(codLineaTest, "L1");
	}
	
	@Test
	public void testFiltrarParadasDestino() {
		Parada paradaTest1 = new Parada(1, "Luis Briñas", "Termibus-Bilbao", 43.2614f, -2.94974f);
		Parada paradaTest2 = new Parada(3, "Otsobarrena", "Metro Leioa", 43.3191f, -2.99149f);
		Parada[] paradasTest1 = {paradaTest1, paradaTest2};
		Parada[] paradasTest2 = new Parada[0];
		Parada[] paradasTest3 = {paradaTest2};
		paradasTest2 = funcionesParadas.filtrarParadasDestino(paradasTest1, 0, paradasTest2);
		
		assertArrayEquals(paradasTest2, paradasTest3);
	}

}
