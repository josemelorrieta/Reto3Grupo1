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
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class PanelRegistro extends JPanel {
	
	JPanel panelRegistro = new JPanel();
	
	private JTextField textFieldContraseña;
	public JTextField textFieldApellidos;
	public JTextField textFieldNombre;
	public JTextField textFieldDni;
	public JButton btnCancelar = new JButton("CANCELAR");
	public JButton btnRegistrarse = new JButton("REGISTRARSE");
	public JCheckBox ElegirHombre = new JCheckBox("Hombre");
	public JCheckBox ElegirMujer = new JCheckBox("Mujer");

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
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewJgoodiesLabel.setBounds(-35, 78, 1080, 49);
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_1.setBounds(48, 184, 351, 35);
		add(lblNewJgoodiesLabel_1);
		
		
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(48, 575, 194, 68);
		add(btnCancelar);
		
		
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrarse.setBounds(858, 575, 194, 68);
		add(btnRegistrarse);
		
		JLabel lblNombre = DefaultComponentFactory.getInstance().createLabel("NOMBRE:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(48, 249, 351, 35);
		add(lblNombre);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("APELLIDOS:");
		lblNewJgoodiesLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_2.setBounds(48, 316, 351, 25);
		add(lblNewJgoodiesLabel_2);
		
		JLabel lblSexo = DefaultComponentFactory.getInstance().createLabel("SEXO:");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSexo.setBounds(48, 374, 351, 25);
		add(lblSexo);
		
		JLabel lblContrasea = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContrasea.setBounds(48, 436, 351, 25);
		add(lblContrasea);
		
		
		ElegirHombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ElegirHombre.setBounds(427, 377, 97, 23);
		add(ElegirHombre);
		
		
		ElegirMujer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ElegirMujer.setBounds(553, 377, 97, 23);
		add(ElegirMujer);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(427, 439, 277, 26);
		add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(427, 319, 277, 26);
		add(textFieldApellidos);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(427, 257, 277, 26);
		add(textFieldNombre);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(427, 192, 277, 26);
		add(textFieldDni);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewJgoodiesLabel_3.setBounds(239, 164, 530, 337);
		add(lblNewJgoodiesLabel_3);

	}
}
