package testsControlador;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.Controlador;
import modelo.Modelo;
import vista.Ventana;

public class ControladorTest {

	Modelo miModelo = new Modelo();
	Ventana miVentana = new Ventana();
	Controlador miControlador = new Controlador(miVentana, miModelo);
	
	@Test
	public void testConstructorControlador() {
		
		assertEquals(miControlador.miVentana, miVentana);
		assertEquals(miControlador.miModelo, miModelo);
	}

	@Test
	public void testGetterSetters() { 
		miModelo.setControlador(miControlador);
		assertEquals(miControlador, miModelo.getControlador());
	}
	
}
