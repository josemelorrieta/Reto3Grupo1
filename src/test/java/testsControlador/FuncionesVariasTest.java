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
	
	private String dniTest = "111111A";
	private char[] passTest = {'O', 'k'};
	private String passTestStr = String.valueOf(passTest);
	

	Cliente clienteTest = new Cliente(dniTest, "Pepe", "El marino", "21/3/1975", 'V');


	@Test
	public void testComprobarDNI() throws Exception {
		clienteTest.setContraseña(passTestStr);
		assertNotEquals(funciones.comprobarDNI(dniTest, passTest, clienteTest,  miVentana), null);
		//assertEquals(funcionesTest.comprobarDNI(DNI2), false);
	}

	
//	@Test
//	public void testCargarLineas() throws Exception {
//		System.out.println(funcionesTest.CargarLineas());
//		Connection con = conexionTest.conectarBD();
//		ResultSet rs = consultaTest.hacerConsultaBD(con, "select parada.Nombre from parada, linea, `linea-parada` where linea.Cod_Linea = `linea-parada`.Cod_Linea and `linea-parada`.Cod_Parada=parada.Cod_Parada and linea.Cod_Linea = 'L1' order BY sqrt(power(latitud - (SELECT latitud FROM parada WHERE cod_parada = 1), 2)+power(longitud - (SELECT longitud FROM parada WHERE cod_parada = 1), 2));");
//		System.out.println(rs.getRow());
//		assertEquals(funcionesTest.CargarLineas(), "Termibus-Bilbao - Asilo Barrika");
//	}
//	
	
//	@Test
//	public void testCargarLineas() throws Exception {
//		ArrayList<LineaAutobus> lineas;
//		System.out.println(funcionesTest.cargarLineass(lineas));
//		Connection con = conexionTest.conectarBD();
//		ResultSet rs = consultaTest.hacerConsultaBD(con, "select poblacion.Nombre from poblacion, `poblacion_parada`, parada, `linea-parada` where `linea-parada`.Cod_Parada = parada.Cod_parada and parada.Cod_Parada = `poblacion_parada`.Cod_Parada and `poblacion_parada`.Cod_Postal = poblacion.Cod_Postal and `linea-parada`.Cod_Linea = 'L1';");
//		assertEquals(funcionesTest.CargarLineass(lineas), "Bilbao Leioa Berango Sopela Sopela Barrika Plentzia");
//	}
	
	
	
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
		
		assertEquals(funciones.comprobarPass(dniTest, String.valueOf(passTest)), false);
	}

}
