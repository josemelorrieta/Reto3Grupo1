package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

/** 
 * Clase del panel de registro de un nuevo usuario
 *
 */
public class PanelRegistro extends JPanel {
	
	private static final long serialVersionUID = 3L;
	
	JPanel panelRegistro = new JPanel();
	public JTextField textFieldApellidos;
	public JTextField textFieldNombre;
	public JTextField textFieldDni;
	public JComboBox<String> comboBoxGenero = new JComboBox<String>();
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnRegistrarse = new JButton("Confirmar");
	public JPasswordField passwordField;
	public JDateChooser dateChooser = new JDateChooser();
	
	
	/**
	 * Create the panel.
	 */
 
	public PanelRegistro() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("REGISTRARSE");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(new Color(204, 51, 51));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_1.setBounds(100, 195, 351, 35);
		add(lblNewJgoodiesLabel_1);	
		
		btnCancelar.setBackground(new Color(248, 248, 255));
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(48, 551, 195, 70);	
		btnCancelar.setName("btnAtrasRegistro");
		add(btnCancelar);
		
		
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrarse.setBounds(858, 575, 194, 68);
		btnRegistrarse.setName("btnRegistro");
		add(btnRegistrarse);
		
		JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("NOMBRE:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(100, 249, 351, 29);
		add(lblNombre);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("APELLIDOS:");
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_2.setBounds(100, 297, 351, 29);
		add(lblNewJgoodiesLabel_2);
		
		JLabel lblSexo = DefaultComponentFactory.getInstance().createLabel("SEXO:");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSexo.setBounds(100, 353, 351, 25);
		add(lblSexo);
		
		JLabel lblContrasea = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(100, 451, 351, 25);
		add(lblContrasea);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(468, 300, 277, 26);
		add(textFieldApellidos);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(468, 252, 277, 26);
		add(textFieldNombre);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(468, 203, 277, 26);
		add(textFieldDni);
		comboBoxGenero.setBackground(Color.WHITE);
		
		
		comboBoxGenero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBoxGenero.setModel(new DefaultComboBoxModel<String>(new String[] {"Hombre", "Mujer"}));
		comboBoxGenero.setBounds(468, 354, 95, 25);
		add(comboBoxGenero);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(468, 455, 277, 25);
		add(passwordField);
		
		JLabel lblFechaDeNacimiento = DefaultComponentFactory.getInstance().createLabel("FECHA DE NACIMIENTO:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaDeNacimiento.setBounds(232, 399, 219, 30);
		add(lblFechaDeNacimiento);
		
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewJgoodiesLabel_3.setForeground(Color.CYAN);
		lblNewJgoodiesLabel_3.setBackground(new Color(204, 51, 51)); 
		lblNewJgoodiesLabel_3.setBounds(190, 160, 725, 367);
		add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_9 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_9.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_9.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_9);
		
		dateChooser.setBounds(468, 409, 277, 20);
		add(dateChooser);

	}
}
