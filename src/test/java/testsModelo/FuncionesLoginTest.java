package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Cliente;
import modelo.FuncionesLogin;
import modelo.Modelo;
import vista.Ventana;

public class FuncionesLoginTest {

	Ventana miVentana = new Ventana();
	Modelo miModelo = new Modelo();
	FuncionesLogin funcionesLoginTest = new FuncionesLogin();
	
	@Test
	public void testComprobarDNI() {
		Cliente clienteTest = new Cliente("15236985K", "Popeye", "El marino", "1956-01-17", 'V');
		Cliente cliente;
		//cliente = funcionesLoginTest.comprobarDNI("15236985K", "abracadabra", cliente, miVentana);
		
		//pasar un array de chars como contraseña
		
		//assertEquals(cliente, clienteTest);
	}
	
	@Test
	public void testComprobarPass() {
		//No se probar funciones con conexion a BD
	}

}
