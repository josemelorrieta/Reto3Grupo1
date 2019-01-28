package testsControlador;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Test;

import controlador.FuncionesVarias;
import modelo.ConexionBD;
import modelo.ConsultaBD;

public class FuncionesVariasTest {

	private FuncionesVarias funcionesTest = new FuncionesVarias();
	
	private ConexionBD conexionTest = new ConexionBD();
	private ConsultaBD consultaTest = new ConsultaBD();
	private FuncionesVarias funciones = new FuncionesVarias();
	
	private String dniTest = "111111A";
	private char[] passTest = {'O', 'k'};

	@Test
	public void testComprobarDNI() throws Exception {
		String DNI = "45899844Y";
		String DNI2 = "45894Y";
		
		assertEquals(funcionesTest.comprobarDNI(DNI), true);
		assertEquals(funcionesTest.comprobarDNI(DNI2), false); 
	}

	
	@Test
	public void testCargarLineas() throws Exception {
		System.out.println(funcionesTest.CargarLineas());
		Connection con = conexionTest.conectarBD();
		ResultSet rs = consultaTest.hacerConsultaBD(con, "select parada.Nombre from parada, linea, `linea-parada` where linea.Cod_Linea = `linea-parada`.Cod_Linea and `linea-parada`.Cod_Parada=parada.Cod_Parada and linea.Cod_Linea = 'L1' order BY sqrt(power(latitud - (SELECT latitud FROM parada WHERE cod_parada = 1), 2)+power(longitud - (SELECT longitud FROM parada WHERE cod_parada = 1), 2));");
		System.out.println(rs.getRow());
		assertEquals(funcionesTest.CargarLineas(), "Termibus-Bilbao - Asilo Barrika");
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
		
		assertEquals(funciones.comprobarPass(dniTest, String.valueOf(passTest)), false);
	}
	
	@Test
	public void accionLoginTest() throws Exception {
		FuncionesVarias mockFunciones = new FuncionesVarias();
		
		mockFunciones = mock(FuncionesVarias.class);
		when(mockFunciones.comprobarDNI(dniTest)).thenReturn(true);
		when(mockFunciones.comprobarPass(dniTest, String.valueOf(passTest))).thenReturn(true);
		
		System.out.println(mockFunciones.accionLogin(dniTest, passTest));
		assertEquals(mockFunciones.accionLogin(dniTest, passTest), "Ok");
	}
}
