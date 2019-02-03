package testsModelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import modelo.FuncionesFechas;

public class FuncionesFechasTest {

	FuncionesFechas func = new FuncionesFechas();
	
	Date fechaInicio = new Date();
	Date fechaLimite = new Date();
	Date fechaLimite2 = new Date();
	
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	public void testSetFechasDisponibles() throws ParseException {
		fechaInicio = format.parse("2019-02-04");
		fechaLimite = format.parse("2019-02-07");
		fechaLimite2 = format.parse("2019-02-08");
		
		assertEquals(func.setFechasDisponibles(fechaInicio), fechaLimite);
		assertNotEquals(func.setFechasDisponibles(fechaInicio), fechaLimite2);
	}

}
