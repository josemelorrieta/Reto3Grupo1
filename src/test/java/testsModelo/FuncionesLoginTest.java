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
	public void testComprobarDNIyPass() throws Exception {
		Cliente clienteTest = new Cliente("15236985K", "Popeye", "El marino", "1956-01-17", 'V');
		Cliente cliente1 = null;
		Cliente cliente2 = null;
		Cliente cliente3 = null;
		char [] contrs = {'a', 'b', 'r', 'a', 'c', 'a', 'd', 'a', 'b', 'r', 'a'};
		char [] contrs2 = {'h', 'o', 'l', 'a'};
		cliente1 = funcionesLoginTest.comprobarDNI("15236985K", contrs, cliente1, miVentana);
		cliente2 = funcionesLoginTest.comprobarDNI("15236985K", contrs2, cliente2, miVentana);
		cliente3 = funcionesLoginTest.comprobarDNI("11111111K", contrs, cliente3, miVentana);
		
//		System.out.println(cliente1.getApellidos());
//		System.out.println(cliente1.getDni());
//		System.out.println(cliente1.getFechaNacimiento());
//		System.out.println(cliente1.getNombre());
//		System.out.println(cliente1.getSexo());
//		System.out.println(clienteTest.getApellidos());
//		System.out.println(clienteTest.getDni());
//		System.out.println(clienteTest.getFechaNacimiento());
//		System.out.println(clienteTest.getNombre());
//		System.out.println(clienteTest.getSexo());
		assertEquals(cliente1, clienteTest);
	}
	

}
