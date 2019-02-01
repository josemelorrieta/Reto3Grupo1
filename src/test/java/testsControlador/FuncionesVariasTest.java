package testsControlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Test;

import controlador.FuncionesVarias;
import modelo.Cliente;
import modelo.ConexionBD;
import modelo.ConsultaBD;
import modelo.FuncionesLogin;
import modelo.LineaAutobus;

import vista.Ventana;

public class FuncionesVariasTest {

	private Ventana miVentana = new Ventana();
	
	private ConexionBD conexionTest = new ConexionBD();
	private ConsultaBD consultaTest = new ConsultaBD();
	private FuncionesLogin funciones = new FuncionesLogin();
	private FuncionesVarias funcionesVarias = new FuncionesVarias();
	
	private String dniTest = "111111A";
	private char[] passTest = {'O', 'k'};
	private String passTestStr = String.valueOf(passTest);
	 

	Cliente clienteTest = new Cliente(dniTest, "Pepe", "El marino", "21/3/1975", 'V');



	
	@Test
	public void testCargarLineass() throws Exception {
		ArrayList<LineaAutobus> lineaTest = new ArrayList<LineaAutobus>();
		lineaTest.add(null);
		lineaTest.add(null);
		lineaTest.add(null);
		int[] rsTest1 = {1001, 1002, 1003};
		String[] rsTest2 = {"Bilbao", "Leioa", "Berango", "Sopela", "Sopela", "Barrika", "Plentzia"};
		String codLinea = "L1";
		funcionesVarias.cargarLineas(lineaTest, codLinea);
		
		assertEquals(lineaTest.getCodLinea(), "L1");
		assertArrayEquals(lineaTest.getCodAutobus(), rsTest1);
		assertArrayEquals(lineaTest.getMunicipios(), rsTest2);
	}

	@Test
	public void testComprobarDNI() throws Exception {
		clienteTest.setContraseña(passTestStr);
		assertNotEquals(funciones.comprobarDNI(dniTest, passTest, clienteTest,  miVentana), null);
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
		
//		assertEquals(funciones.comprobarPass(dniTest, String.valueOf(passTest)), false);
	}

}
