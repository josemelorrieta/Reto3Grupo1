package testsModelo;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import modelo.Billete;
import modelo.FuncionesBilletes;

public class FuncionesBilleteTest {
	FuncionesBilletes func = new FuncionesBilletes();
	
	@Test
	public void testBilletesCliente() {
		//No se hacer test con conexion a BD 
	}
	
	@Test
	public void testIncrementarArrayBilletes() {
		Billete[] billetes = new Billete[1];
		billetes[0] = new Billete(1, "2019-02-12", "L1", "Termibus", "Plentzia", 1001, 20.0, "11111111A");
		billetes = func.incrementarArrayBilletes(billetes);
		
		assertEquals(billetes.length, 2);
		assertEquals(billetes[1], null);
	}

	@Test
	public void testNombreParada()  throws SQLException {
		
		int codParada = 1;
		String nombreParada = "Termibus-Bilbao";
		
		assertEquals(func.nombreParada(codParada), nombreParada);
	}

}
