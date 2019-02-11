package vista;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder; 
import javax.swing.border.BevelBorder;

/**
 * Clase del panel de login
 *
 */
public class PanelLogin extends JPanel {
	
	public JTextField TextDni; 
	public JPasswordField passwordField;
	public JButton btnLogin;
	public JButton btnAtras;
	public JButton btnRegistrarse;
	
	/**
	 *
	 */
	public PanelLogin() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(UIManager.getColor("windowText"));
		setBounds(0, 0, 1090, 690);
		setLayout(null);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setName("btnRegistrarseLogin");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrarse.setBounds(846, 575, 194, 68);
		add(btnRegistrarse);
		
		
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_1.setForeground(Color.CYAN);
		lblNewJgoodiesLabel_1.setBackground(new Color(204, 51, 51)); 
		lblNewJgoodiesLabel_1.setBounds(335, 142, 440, 360);
		lblNewJgoodiesLabel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(lblNewJgoodiesLabel_1);
		
		btnAtras = new JButton("Atras");
		btnAtras.setName("btnAtrasLogin");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(48, 575, 194, 68);
		add(btnAtras);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_3.setBounds(202, 159, 645, 33);
		add(lblNewJgoodiesLabel_3);
		lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblNewJgoodiesLabel.setBounds(208, 277, 639, 33);
		add(lblNewJgoodiesLabel);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		TextDni = new JTextField();
		TextDni.setBounds(372, 203, 298, 33);
		add(TextDni);
		TextDni.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(372, 316, 298, 33);
		add(passwordField);
		
		btnLogin = new JButton ("Login");
		btnLogin.setName("btnLogin");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(412, 397, 213, 57);
		add(btnLogin);
		
		JLabel lblLogin= DefaultComponentFactory.getInstance().createLabel("LOGIN");
		lblLogin.setBackground(new Color(204, 51, 51));
		lblLogin.setForeground(new Color(204, 51, 51));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 72, 1070, 48);
		add(lblLogin);
		
	}
}
