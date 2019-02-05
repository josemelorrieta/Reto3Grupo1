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
	public void verificarDNITest() {
		
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
	public void validarNombreYApellidoTest() {		

		String nombre = "osito";
		String nombre2 = "123";
		String apellido = "gominola";
		String apellido2 = "123";
		
		assertEquals(func.validarNombreYApellido(nombre), false);
		assertEquals(func.validarNombreYApellido(nombre2), true);
		assertEquals(func.validarNombreYApellido(apellido), false);
		assertEquals(func.validarNombreYApellido(apellido2), true);
		
		
	}



}
