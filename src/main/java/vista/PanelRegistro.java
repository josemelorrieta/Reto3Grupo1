package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class PanelRegistro extends JPanel {
	
	JPanel panelRegistro = new JPanel();
	
	private JTextField textFieldContraseña;
	private JTextField textFieldApellidos;
	private JTextField textFieldNombre;
	private JTextField textFieldDni;

	/**
	 * Create the panel.
	 */

	public PanelRegistro() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("REGISTRARSE");
		lblNewJgoodiesLabel.setForeground(Color.PINK);
		lblNewJgoodiesLabel.setBackground(Color.MAGENTA);
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setBounds(10, 49, 1080, 49);
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_1.setBounds(10, 192, 351, 35);
		add(lblNewJgoodiesLabel_1);
		
		JButton btnAtras = new JButton("CANCELAR");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(49, 599, 194, 68);
		add(btnAtras);
		
		JButton btnNewButton = new JButton("REGISTRARSE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(875, 599, 188, 68);
		add(btnNewButton);
		
		JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("NOMBRE:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(10, 257, 351, 35);
		add(lblNombre);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("APELLIDOS:");
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_2.setBounds(10, 327, 351, 25);
		add(lblNewJgoodiesLabel_2);
		
		JLabel lblSexo = DefaultComponentFactory.getInstance().createLabel("SEXO:");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSexo.setBounds(10, 383, 351, 25);
		add(lblSexo);
		
		JLabel lblContrasea = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(10, 447, 351, 25);
		add(lblContrasea);
		
		JCheckBox chckbxHombre = new JCheckBox("Hombre");
		chckbxHombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxHombre.setBounds(388, 385, 97, 23);
		add(chckbxHombre);
		
		JCheckBox chckbxMujer = new JCheckBox("Mujer");
		chckbxMujer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxMujer.setBounds(514, 385, 97, 23);
		add(chckbxMujer);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(388, 447, 277, 26);
		add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(388, 327, 277, 26);
		add(textFieldApellidos);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(388, 265, 277, 26);
		add(textFieldNombre);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(388, 200, 277, 26);
		add(textFieldDni);

	}
}
