package testsModelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		dni = "11111112A";
		cliente = func.registrarNuevoCliente(dni, nombre, apellidos, sexo, fechaNac, pass);
		assertEquals(cliente.getSexo(), 'V');
		System.out.println(cliente.getSexo());
	}
	
	@Test
	public void verificarDNITest()  throws SQLException {
		
		String dni= "78878943G";
		
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		String dni = "12345678Z";	
		String nombre = "osito";
		String apellido = "gominola";
		Date fecha = null;
		try {
			fecha = sdf.parse("2000-08-25");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] password = {1,2,3};
		char[] password2 = {1,2,3, 4};
		
		String dni2 = "12345";	
		String nombre2 = "123";
		String apellido2 = "123";
		Date fecha2 = null;
		
		String dni3 = "12345678Z";	
		String nombre3 = "123";
		String apellido3 = "123";
		
		String dni4 = "1234567";	
		String nombre4 = "123";
		String apellido4 = "123";
		
		String dni5 = "12345678Z";	
		String nombre5 = "AA";
		String apellido5 = "123";
		
		String dni6 = "12345678Z";	
		String nombre6 = "123";
		String apellido6 = "BB";
		
		String dni7 = null;	
		String nombre7 = null;
		String apellido7 = null;
		
		String dni8 = "78878943G";	
		String nombre8 = "Otilio";
		String apellido8 = "Ladrillo";
		
		assertEquals(func.comprobarCamposRegistro(dni, nombre, apellido, fecha, password, password),true);
		assertEquals(func.comprobarCamposRegistro(dni2, nombre2, apellido2, fecha2, password, password), false);
		assertEquals(func.comprobarCamposRegistro(dni3, nombre3, apellido3, fecha, password, password), false);
		assertEquals(func.comprobarCamposRegistro(dni4, nombre4, apellido4, fecha, password, password), false);
		assertEquals(func.comprobarCamposRegistro(dni5, nombre5, apellido5, fecha, password, password), false);	
		assertEquals(func.comprobarCamposRegistro(dni6, nombre6, apellido6, fecha, password, password), false);
		assertEquals(func.comprobarCamposRegistro(dni7, nombre7, apellido7, fecha, password, password), false);
		assertEquals(func.comprobarCamposRegistro(dni8, nombre8, apellido8, fecha, password, password2), false);
	
	}

	@Test
	public void testRangoFechasRegistro() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -12);
		
		assertEquals(sdf.format(func.rangoFechasRegistro()), sdf.format(calendar.getTime()));
	}



}
