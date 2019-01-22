package modelo;

import java.sql.Connection;
import java.sql.ResultSet;

public class Cliente {

	private int dni;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private char sexo;
	private String contraseña;
	
	public Cliente(int dni,String nombre, String apellidos, String fechaNacimiento, char sexo, String contraseña) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.contraseña = contraseña;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public boolean existeCliente(String dni) {
		ConexionBD conexion = new ConexionBD();
		ConsultaBD consulta = new ConsultaBD();
		
		String query = "SELECT * FROM cliente WHERE DNI='" + dni + "'"; 
		
		Connection con = conexion.conectarBD();
		ResultSet resultado = consulta.hacerConsultaBD(con, query);
		
		if (resultado != null)
			return true;
		else 
			return false;
	}
	
}
