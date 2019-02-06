package testsModelo;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;

import org.junit.Test;

import modelo.Cliente;
import modelo.FuncionesRegistro;

public class FuncionesRegistroTest {
	private FuncionesRegistro func = new FuncionesRegistro();
	
	private String dni = "11111111A";
	private String nombre = "Pepe";
	private String apellidos = "Lopez";
	private String sexo = "Hombre";
	private String fechaNac = "1980-04-24";
	private char[] pass = {'O', 'k'};
	
	Cliente cliente = null;
	
	@Test
	public void registrarNuevoCliente() throws SQLException, ParseException {
		cliente = func.registrarNuevoCliente(dni, nombre, apellidos, sexo, fechaNac, pass);
		assertNotEquals(cliente, null);
	}
	
	@Test
	public void registrarNuevoCliente2() throws SQLException, ParseException {
		cliente = func.registrarNuevoCliente(dni, nombre, apellidos, sexo, fechaNac, pass);
		assertEquals(cliente.getSexo(), 'V');
		System.out.println(cliente.getSexo());
	}
	
	@Test
	public void verificarDNITest()  throws SQLException {
		
		String dni= "79268079M";
		
		assertEquals(func.verificarDNI(dni), true);
		
		
	}
	
	@Test
	public void validarDNITest() {	
		
		String dni = "12345678Z";	
		String dni2 = "12345678A";
		String dni3 = "123a";
		
		assertEquals(func.validarDNI(dni), true);		
		assertEquals(func.validarDNI(dni2), false);
		assertEquals(func.validarDNI(dni3), false);
		
	}
	
	@Test
	public void comprobarCamposRegistroTest() throws SQLException {		
		
		String dni = "12345678Z";	
		String nombre = "osito";
		String apellido = "gominola";
		String fecha = "2000-08-25";
		int password = 123;
		
		String dni2 = "12345";	
		String nombre2 = "123";
		String apellido2 = "123";
		String fecha2 = null;
		int password2 = 12;
		
		String dni3 = "12345678Z";	
		String nombre3 = "123";
		String apellido3 = "123";
		String fecha3 =  "2000-08-25";
		int password3 = 12;
		
		String dni4 = "1234567";	
		String nombre4 = "123";
		String apellido4 = "123";
		String fecha4 =  "2000-08-25";
		int password4 = 12;
		
		String dni5 = "12345678Z";	
		String nombre5 = "AA";
		String apellido5 = "123";
		String fecha5 =  "2000-08-25";
		int password5 = 12;
		
		String dni6 = "12345678Z";	
		String nombre6 = "123";
		String apellido6 = "BB";
		String fecha6 =  "2000-08-25";
		int password6 = 12;
		
		String dni7 = null;	
		String nombre7 = null;
		String apellido7 = null;
		String fecha7 = null;
		int password7 = 0;
		
		String dni8 = "79268079M";	
		String nombre8 = "osito";
		String apellido8 = "gominola";
		String fecha8 = "2000-08-25";
		int password8 = 123;
		
		assertEquals(func.comprobarCamposRegistro(dni, nombre, apellido, fecha, password),true);
		assertEquals(func.comprobarCamposRegistro(dni2, nombre2, apellido2, fecha2, password2), false);
		assertEquals(func.comprobarCamposRegistro(dni3, nombre3, apellido3, fecha3, password3), false);
		assertEquals(func.comprobarCamposRegistro(dni4, nombre4, apellido4, fecha4, password4), false);
		assertEquals(func.comprobarCamposRegistro(dni5, nombre5, apellido5, fecha5, password5), false);	
		assertEquals(func.comprobarCamposRegistro(dni6, nombre6, apellido6, fecha6, password6), false);
		assertEquals(func.comprobarCamposRegistro(dni7, nombre7, apellido7, fecha7, password7), false);
		assertEquals(func.comprobarCamposRegistro(dni8, nombre8, apellido8, fecha8, password8), false);
	

		
	}

	



}
