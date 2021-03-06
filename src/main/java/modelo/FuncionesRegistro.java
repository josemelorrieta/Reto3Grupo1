package modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

import vista.Ventana;

/**
 * Clase con las funcniones del panel de registro
 *
 */
public class FuncionesRegistro {
	public ConexionBD miConexion = new ConexionBD();
	public ConsultaBD miConsulta = new ConsultaBD();
	
	private Ventana miVentana;
	
	/**
	 * Metodo que registra un nuevo cliente a partir de los datos del formulario
	 * @param dni DNI del nuevo cliente
	 * @param nombre Nombre del nuevo cliente
	 * @param apellidos Apellidos del nuevo cliente
	 * @param sexo Sexo del nuevo cliente
	 * @param fechaNacimiento Fecha de nacimiento del nuevo cliente
	 * @param pass contrasena del nuevo cliente
	 * @return cliente Objeto con el nuevo cliente
	 * @throws SQLException excepcion en caso de error al acceder a la base de datos
	 * @throws ParseException excepcion en caso de error en la encriptacion de la contrasena
	 */
	public Cliente registrarNuevoCliente(String dni, String nombre, String apellidos, String sexo, String fechaNacimiento, char[] pass) throws SQLException, ParseException {
		//Declaracion e inicializacion de variables
		Connection con = miConexion.conectarBD();
		Cliente cliente;
		char sexoBD = 0;
		String passBD = "";
		String query = "";
		
		//Inicio del programa
		if (sexo == "Hombre")
			sexoBD = 'V';
		else
			sexoBD = 'M';
		
		//encriptar clave
		passBD = DigestUtils.md5Hex(String.valueOf(pass));
	
		query = "INSERT into cliente VALUES ('" + dni + "', '" + nombre + "', '" + apellidos + "', '" + fechaNacimiento + "', '"+ sexoBD + "', '" + passBD + "');";
		
		//Comprobar que la insercion de los datos en la BD es correcta
		if (miConsulta.insertarDatosBD(con, query)) {
			cliente = new Cliente(dni, nombre, apellidos, fechaNacimiento, sexoBD);
			passBD = DigestUtils.md5Hex(String.valueOf(pass));
			cliente.setContrase�a(passBD);
		} else {
			cliente = null;
		}
		con.close();
		
		return cliente;
	}
	
	/**
	 * Metodo que comprueba si existe el DNI
	 * @param dni DNI a comprobar
	 * @return boolean tru si existe en la base de datos, false si no
	 * @throws SQLException excepcion en caso de error al acceder a la base de datos
	 */
	public boolean verificarDNI (String dni) throws SQLException {
		//Declaraci�n e inicializaci�n de variables
		ConexionBD miConexion = new ConexionBD();
		ConsultaBD miConsulta = new ConsultaBD();
		Connection con = miConexion.conectarBD();
		
		//Inicio del programa
		ResultSet rs = miConsulta.hacerConsultaBD(con, "select * from cliente where DNI = '" + dni + "';");
		
		// Si hay registros devuelve tru, si no false
		if (rs.last()) {
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}
	}
	
	/**
	 * Comprueba todos los campos de la ventana registro. Avisa de si estan todos los campos rellenos y de si existe ya el dni introducido
	 * @param dni String con el DNI del cliente
	 * @param nombre String con el nombre del cliente
	 * @param apellido String con el apellido del cliente
	 * @param fecha String con la fecha de nacimiento del cliente
	 * @param password array de char con la clave introducida por el usuario
	 * @param password2 array de char con la segunda clave introducida por el usuario
	 * 
	 * @return boolean Devuelve true si los campos del registro son correctos, false si no
	 * 
	 * @throws SQLException Excepcion en caso de error al conectar a la base de datos
	 * 
	 */
	public boolean comprobarCamposRegistro(String dni, String nombre, String apellido, Date fecha, char[] password, char[] password2) throws SQLException {

		//comprobar si ya existe ese DNI
		if (verificarDNI(dni)) {
			JOptionPane.showMessageDialog(miVentana, "Ya existe un ususario con ese DNI", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			//Validacion de los campos
			if (dni != "" && nombre != "" && apellido !="" && fecha != null && password.length != 0 ) {
					if(validarDNI(dni)) {
						if(validarNombreYApellido(nombre) || validarNombreYApellido(apellido))
						{
							JOptionPane.showMessageDialog(miVentana, "�Nombre o apellido incorrecto!", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
							return false;
							
						} if (!String.valueOf(password).equals(String.valueOf(password2))) {
							JOptionPane.showMessageDialog(miVentana, "�Las contrase�as no coinciden!", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
							return false;
						} else {
						return true;
						}
					}
					else {
						JOptionPane.showMessageDialog(miVentana, "�Formato DNI incorrecto!", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
						return false;
					}
			} else {
				JOptionPane.showMessageDialog(miVentana, "�Debe rellenar todos los campos!", "�Atenci�n!", JOptionPane.WARNING_MESSAGE);
				return false;
			} 
		}
		
	}
	
	/**
	 * Valida el campo del DNI.
	 * @param dni El DNI del cliente.
	 * 
	 * @return boolean Comprueba si el formato del DNI es el correcto.
	 */
	public boolean validarDNI(String dni){
        boolean correcto=false;
        Pattern pattern=Pattern.compile("(\\d{8})([TRWAGMYFPDXBNJZSQVHLCKE])");
        Matcher matcher=pattern.matcher(dni);
        if(matcher.matches()){
            String letra=matcher.group(2);
            String letras="TRWAGMYFPDXBNJZSQVHLCKE";
            int index=Integer.parseInt(matcher.group(1));
            index=index%23;
            String reference=letras.substring(index,index+1);
            if(reference.equals(letra)){
                correcto=true;
            }else{
                correcto=false;
            }
        }else{
            correcto=false;
        }
        return correcto;
    }
	
	/**
	 * Valida el campo del DNI.
	 * @param NombreOApellido String con el Nombre o el Apellido.
	 * @return Comprueba si es correcto el nombre y apellido ,es decir , comprueba que no ha introducido numeros o caracteres.
	 */
	public boolean validarNombreYApellido (String NombreOApellido) {
		
		 if (NombreOApellido.matches("^[a-zA-Z������������ ]+$"))
			return false;
		  else 
			 return true;
	}

	/**
	 * Metodo que fija el rango de seleccion de fechas en el registro
	 * Debe ser mayor de edad y no anterior al 1/1/1900
	 * @return Date fecha minima de mayoria de edad
	 */
	public Date rangoFechasRegistro() {
		//Declaracion e inicializacion de variables
		Calendar calendar = Calendar.getInstance();
		
		//Inicio del programa
		calendar.add(Calendar.YEAR, -12);
		//fechaLimite = calendar.getTime();
		
		return calendar.getTime();	
	}
	
}	
	
	 