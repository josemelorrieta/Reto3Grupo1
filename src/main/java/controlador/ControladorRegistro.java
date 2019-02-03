package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.FuncionesRegistro;
import modelo.Modelo;
import vista.Ventana;

/**
 * Clase que controla el panel de Registro de nuevo usuario
 *
 */
public class ControladorRegistro implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	FuncionesRegistro funcionesRegistro = new FuncionesRegistro();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Controlador miControlador;
	private Modelo miModelo;

	private Cliente cliente;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Constructor de la clase
	 * @param miControlador instancia del controlador para acceder a otros paneles
	 * @param miVentana instancia de la ventana principal
	 * @param miModelo instancia del modelo para acceder a las funciones
	 */
	public ControladorRegistro (Controlador miControlador, Ventana miVentana, Modelo miModelo) {

		this.miVentana = miVentana;
		this.miControlador = miControlador;
		this.miModelo = miModelo;
		
		this.cliente = miModelo.cliente;
		
		//Definicion de los listeners de los botones del panel
		miVentana.registro.btnCancelar.addActionListener(this);
		miVentana.registro.btnRegistrarse.addActionListener(this);
		 
	}
		
	/**
	 * Metodo para resetear los valores de la ventana registro
	 */
	public void resetear() {
		 miVentana.registro.textFieldDni.setText(""); 
		 miVentana.registro.textFieldNombre.setText("");
		 miVentana.registro.textFieldApellidos.setText("");
		 miVentana.registro.textFieldNombre.setText(""); 
		 miVentana.registro.passwordField.setText("");
		 miVentana.registro.dateChooser.setToolTipText("");
	}

	/**
	 * Metodo para la llamada a los botones del panel de registro de nuevo usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Accion dependiendo del boton del que venga el evento
		switch (((JButton) e.getSource()).getName()) {
			case "btnAtrasRegistro": funciones.cambiarDePanel(miVentana.registro, miVentana.login);
				 resetear();
				 break;
				 
			case "btnRegistro": try {
				//Si el formulario esta bien rellenado creamos el cliente y cambiamos a la ventana de billetes
				if (comprobarCamposRegistro()) {
					cliente = funcionesRegistro.registrarNuevoCliente(miVentana.registro.textFieldDni.getText(), miVentana.registro.textFieldNombre.getText(), miVentana.registro.textFieldApellidos.getText(), miVentana.registro.comboBoxGenero.getSelectedItem().toString(), sdf.format(miVentana.registro.dateChooser.getDate()), miVentana.registro.passwordField.getPassword());
					if (cliente != null) {
						funciones.cambiarDePanel(miVentana.registro, miVentana.login);
						resetear();
						
						miControlador.miControladorBilletes.actualizarBilletes(miModelo.billetes);
					} else {
						JOptionPane.showMessageDialog(miVentana, "Hubo un error en el registro", "¡Atención!", JOptionPane.WARNING_MESSAGE);
					}
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * Comprueba todos los campos de la ventana registro. Avisa de si estan todos los campos rellenos y de si existe ya el dni introducido
	 * @return boolean Si no hay error en los datos del formulario devuelve true, si no devuelve false
	 * @throws SQLException Excepcion en caso de error al conectar a la base de datos
	 */
	private boolean comprobarCamposRegistro() throws SQLException {
		//comprobar si ya existe ese DNI
		if (funcionesRegistro.verificarDNI(miVentana.registro.textFieldDni.getText())) {
			JOptionPane.showMessageDialog(miVentana, "Ya existe un ususario con ese DNI", "¡Atención!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			//Validacion de los campos
			if (miVentana.registro.textFieldDni.getText() != "" && miVentana.registro.textFieldNombre.getText() != "" && miVentana.registro.textFieldApellidos.getText()!="" && miVentana.registro.dateChooser.getDate() != null && miVentana.registro.passwordField.getPassword().length != 0) {
					return true;
				} else {
					JOptionPane.showMessageDialog(miVentana, "¡Debe rellenar todos los campos!", "¡Atención!", JOptionPane.WARNING_MESSAGE);
					return false;
				}
		}
	}

}
 