package modelo;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Clase del objeto cliente
 *
 */
public class Cliente {

	private String dni;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private char sexo;
	private String contraseña = null; 
	
	/**
	 * Constructor del objeto cliente
	 * @param dni DNI del cliente
	 * @param nombre Nombre del cliente
	 * @param apellidos Apellidos del cliente
	 * @param fechaNacimiento Fecha de nacimiento del cliente
	 * @param sexo Sexo del cliente. 'V' para hombre, 'M' para mujer
	 */
	public Cliente(String dni,String nombre, String apellidos, String fechaNacimiento, char sexo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}

	//Getters y setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
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
	
//	/**
//	 * Calse que comprueba si ya existe un cliente a partir de su dni
//	 * @param dni DNI del cliente a comprobar
//	 * @return boolean Devuelve true si existe el cliente y false si no existe
//	 */
//	public boolean existeCliente(String dni) {
//		ConexionBD conexion = new ConexionBD();
//		ConsultaBD consulta = new ConsultaBD();
//		
//		String query = "SELECT * FROM cliente WHERE DNI='" + dni + "'"; 
//		
//		Connection con = conexion.conectarBD();
//		ResultSet resultado = consulta.hacerConsultaBD(con, query);
//		
//		if (resultado != null)
//			return true;
//		else 
//			return false;
//	}

}
