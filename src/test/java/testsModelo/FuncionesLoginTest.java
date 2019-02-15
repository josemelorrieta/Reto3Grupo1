package testsModelo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Test;

import modelo.Cliente;
import modelo.ConexionBD;
import modelo.ConsultaBD;
import modelo.FuncionesLogin;

import vista.Ventana;

public class FuncionesLoginTest {

	private Ventana miVentana = new Ventana();
	private FuncionesLogin funcionesLoginTest = new FuncionesLogin();
	private ConexionBD conexionTest = new ConexionBD();
	private ConsultaBD consultaTest = new ConsultaBD();
	
	private String dniTest = "111111A";
	private char[] passTest = {'O', 'k'};
	private String passTestStr = String.valueOf(passTest);
	 

	Cliente clienteTest = new Cliente(dniTest, "Pepe", "El marino", "21/3/1975", 'V');
	
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
		
		assertEquals(cliente1, clienteTest);
	}
	

	@Test
	public void testComprobarDNI() throws Exception {
		clienteTest.setContraseña(passTestStr);
		assertNotEquals(funcionesLoginTest.comprobarDNI(dniTest, passTest, clienteTest,  miVentana), null);
		//assertEquals(funcionesTest.comprobarDNI(DNI2), false);
	}
		
	@Test
	public void comprobarPassTest() throws Exception {
		conexionTest = mock(ConexionBD.class);
		Connection conTest = null;
		when(conexionTest.conectarBD()).thenReturn(conTest);
		
		ResultSet rsMock = mock(ResultSet.class);
		when(rsMock.next()).thenReturn(true);
		
		ResultSet rsTest = null;
		consultaTest = mock(ConsultaBD.class);
		when(consultaTest.hacerConsultaBD(conTest, "")).thenReturn(rsTest);
		
		assertEquals(funcionesLoginTest.comprobarPass(dniTest, String.valueOf(passTest)), false);
	}
	
}
