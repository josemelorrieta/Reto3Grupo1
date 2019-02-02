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

public class ControladorRegistro implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	FuncionesRegistro funcionesRegistro = new FuncionesRegistro();
	
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Controlador miControlador;
	private Modelo miModelo;

	private Cliente cliente;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//Constructor
		public ControladorRegistro (Controlador miControlador, Ventana miVentana, Modelo miModelo) {

			this.miVentana = miVentana;
			this.miControlador = miControlador;
			this.miModelo = miModelo;
			
			this.cliente = miModelo.cliente;
			
			miVentana.registro.btnCancelar.addActionListener(this);
			miVentana.registro.btnRegistrarse.addActionListener(this);
			 
		}
		
	//Metodo para resetear los valores de la ventana registro
		public void resetear() {
			 miVentana.registro.textFieldDni.setText(""); 
			 miVentana.registro.textFieldNombre.setText("");
			 miVentana.registro.textFieldApellidos.setText("");
			 miVentana.registro.textFieldNombre.setText(""); 
			 miVentana.registro.passwordField.setText("");
			 miVentana.registro.dateChooser.setToolTipText("");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnAtrasRegistro": funciones.cambiarDePanel(miVentana.registro, miVentana.login);
					 resetear();
					 break;
					 
				case "btnRegistro": try {
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
	
	//Comprueba todos los campos de la ventana registro. Avisa de si estan todos los campos rellenos y de si existe ya el dni introducido
		private boolean comprobarCamposRegistro() throws SQLException {
			if (funcionesRegistro.verificarDNI(miVentana.registro.textFieldDni.getText())) {
				JOptionPane.showMessageDialog(miVentana, "Ya existe un ususario con ese DNI", "¡Atención!", JOptionPane.WARNING_MESSAGE);
				return false;
			} else {
				if (miVentana.registro.textFieldDni.getText() != "" && miVentana.registro.textFieldNombre.getText() != "" && miVentana.registro.textFieldApellidos.getText()!="" && /*miVentana.registro.textFieldFechaNacimiento.getText()!="" &&*/ miVentana.registro.passwordField.getPassword().length != 0) {
						return true;
					} else {
						JOptionPane.showMessageDialog(miVentana, "¡Debe rellenar todos los campos!", "¡Atención!", JOptionPane.WARNING_MESSAGE);
						return false;
					}
			}
		}

}
 