package testsModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import modelo.FuncionesModelo;
import modelo.FuncionesParadas;
import modelo.Modelo;
import modelo.Parada;

public class FuncionesParadasTest {

	Modelo miModelo = new Modelo();
	private FuncionesParadas funcionesParadas = new FuncionesParadas(miModelo);
	
	@Test
	public void testCargarParadas() {
		Parada[] paradasTest1 = new Parada[0];
		Parada paradaTest = new Parada(1, "Luis Briñas", "Termibus-Bilbao", 43.2614f, -2.94974f);
		paradasTest1 = funcionesParadas.cargarParadas(paradasTest1, "Termibus-Plentzia");
		
		assertEquals(paradasTest1[0].getCodParada(), paradaTest.getCodParada());
		assertEquals(paradasTest1[0].getNombre(), paradaTest.getNombre());
		assertEquals(paradasTest1[0].getCalle(), paradaTest.getCalle());
		assertEquals(paradasTest1[0].getCoordX(), paradaTest.getCoordX(), 0.000001);
		assertEquals(paradasTest1[0].getCoordY(), paradaTest.getCoordY(), 0.000001);
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
	
	@Test
	public void testOrdenarParadas() {
		Parada paradaTest1 = new Parada(1, "Luis Briñas", "Termibus-Bilbao", 43.2614f, -2.94974f);
		Parada paradaTest2 = new Parada(7, "BI-634", "Asilo Barrika", 43.4055f, -2.96369f);
		Parada paradaTest3 = new Parada(8, "Erribera", "Ayuntamiento Plentzia", 43.2833f, -2.99605f);
		
		Parada[] paradasTest = {paradaTest1, paradaTest2, paradaTest3};
		
		paradasTest = funcionesParadas.ordenarParadas(paradasTest);
		
		assertEquals(paradasTest[0].getCodParada(), 1);
		assertEquals(paradasTest[1].getCodParada(), 8);
		assertEquals(paradasTest[2].getCodParada(), 7);
	}

	@Test
	public void testArrayDistanciasParada() {
		Parada paradaTest1 = new Parada(1, "Luis Briñas", "Termibus-Bilbao", 43.2614f, -2.94974f);
		Parada paradaTest2 = new Parada(7, "BI-634", "Asilo Barrika", 43.4055f, -2.96369f);
		float[] coordP1 = new float[2];
		float[] coordP2 = new float[2];
		
		coordP1[0] = paradaTest1.getCoordX();
		coordP1[1] = paradaTest1.getCoordY();
		coordP2[0] = paradaTest2.getCoordX();
		coordP2[1] = paradaTest2.getCoordY();
		
		Parada[] paradasTest = {paradaTest1, paradaTest2};
		
		FuncionesModelo funcionesMock = mock(FuncionesModelo.class);
		when(funcionesMock.distanciaEntreParadas(coordP1, coordP2)).thenReturn(1.0);
		
		float[] distanciasTest = funcionesParadas.arrayDistanciasParada(paradasTest, funcionesMock);
		
		assertEquals(distanciasTest[1], 1, 0.01);
	}
	
	@Test
	public void testCargarParadasOrdenadas() {
		Parada[] paradasTest1 = new Parada[0];
		Parada paradaTest = new Parada(1, "Luis Briñas", "Termibus-Bilbao", 43.2614f, -2.94974f);
		paradasTest1 = funcionesParadas.cargarParadasOrdenadas(paradasTest1, "Termibus-Plentzia");

		
		assertEquals(paradasTest1[0].getCodParada(), paradaTest.getCodParada());
		assertEquals(paradasTest1[0].getNombre(), paradaTest.getNombre());
		assertEquals(paradasTest1[0].getCalle(), paradaTest.getCalle());
		assertEquals(paradasTest1[0].getCoordX(), paradaTest.getCoordX(), 0.000001);
		assertEquals(paradasTest1[0].getCoordY(), paradaTest.getCoordY(), 0.000001);
	}
	
}
