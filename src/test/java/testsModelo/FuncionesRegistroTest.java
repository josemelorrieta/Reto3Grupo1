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
	
	public void verificarDNITest() {
		
	}

}
