package testsModelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Cliente;

public class ClienteTest {

	private String dni = "1111111A";
	private String nombre = "Perry";
	private String apellidos = "Mason";
	private String fechaNacimiento = "1/1/0001";
	private char sexo = 'v';
	private String contraseña = "aaaAAA";
	private Cliente cliente = new Cliente(dni, nombre, apellidos, fechaNacimiento, sexo);
	
	@Test
	public void testConstructorCliente1() {
		Cliente clienteTest = new Cliente(dni, nombre, apellidos,  fechaNacimiento, sexo);
		clienteTest.setContraseña(contraseña);
		assertEquals(dni, clienteTest.getDni());
		assertEquals(nombre, clienteTest.getNombre());
		assertEquals(apellidos, clienteTest.getApellidos());
		assertEquals(fechaNacimiento, clienteTest.getFechaNacimiento());
		assertEquals(sexo, clienteTest.getSexo());
		assertEquals(contraseña, clienteTest.getContraseña());
	}
 
	@Test
	public void testConstructorCliente2() { 
		cliente.setContraseña(contraseña);
		assertEquals(dni, cliente.getDni(), "1111111A");
		assertEquals(nombre, cliente.getNombre(), "Perry");
		assertEquals(apellidos, cliente.getApellidos(), "Mason");
		assertEquals(fechaNacimiento, cliente.getFechaNacimiento(), "1/1/0001");
		assertEquals(sexo, cliente.getSexo(), 'v');
		assertEquals(contraseña, cliente.getContraseña(), "aaaAAA");
	}
	
	@Test
	public void testDni() {
		cliente.setDni(dni);
		assertEquals(dni, cliente.getDni());
	}
	
	@Test
	public void testNombre() {
		cliente.setNombre(nombre);
		assertEquals(nombre, cliente.getNombre());
	}
	
	@Test
	public void testApellidos() {
		cliente.setApellidos(apellidos);
		assertEquals(apellidos, cliente.getApellidos());
	}
	
	@Test
	public void testFechaNacimiento() {
		cliente.setFechaNacimiento(fechaNacimiento);
		assertEquals(fechaNacimiento, cliente.getFechaNacimiento());
	}
	
	@Test
	public void testSexo() {
		cliente.setSexo(sexo);
		assertEquals(sexo, cliente.getSexo());
	}
	
	@Test
	public void testContraseña() {
		cliente.setContraseña(contraseña);
		assertEquals(contraseña, cliente.getContraseña());
	}
}
