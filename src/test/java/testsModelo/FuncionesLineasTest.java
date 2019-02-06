package testsModelo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import modelo.FuncionesLineas;
import modelo.Modelo;

public class FuncionesLineasTest {

	private Modelo miModelo = new Modelo();
	private FuncionesLineas funcionesLineas = new FuncionesLineas(miModelo);
	
	@Test
	public void testCargarNombreLineas() throws SQLException {
		String[] lineasTest = null;
		String[] lineas = {"Termibus-Plentzia", "Termibus-Muskiz", "Termibus-Balmaseda", "Termibus-Durango"};
		lineasTest = funcionesLineas.cargarNombreLineas(lineasTest);
		
		for (int i = 0; i < lineasTest.length; i++) {
			System.out.println(lineasTest[i]);
		}
		assertArrayEquals(lineas, lineasTest);
	}

}
