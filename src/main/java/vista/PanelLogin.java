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
		setBackground(SystemColor.controlHighlight);
		setBounds(0, 0, 1085, 660);
		setLayout(null);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnRegistrarse.setBackground(new Color(248, 248, 255));
		btnRegistrarse.setName("btnRegistrarseLogin");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrarse.setBounds(837, 551, 195, 70);
		add(btnRegistrarse);
		
		btnAtras = new JButton("Atrás");
		btnAtras.setName("btnAtrasLogin");
		btnAtras.setBackground(new Color(248, 248, 255));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(48, 551, 195, 70);
		add(btnAtras);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_3.setBounds(325, 175, 433, 33);
		add(lblNewJgoodiesLabel_3);
		lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblNewJgoodiesLabel.setBounds(325, 285, 433, 33);
		add(lblNewJgoodiesLabel);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		TextDni = new JTextField();
		TextDni.setBounds(399, 212, 298, 33);
		add(TextDni);
		TextDni.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(399, 325, 298, 33);
		add(passwordField);
		
		btnLogin = new JButton ("Login");
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnLogin.setBackground(new Color(248, 248, 255));
		btnLogin.setName("btnLogin");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setBounds(439, 406, 213, 57);
		add(btnLogin);
		
		JLabel lblLogin= DefaultComponentFactory.getInstance().createLabel("LOGIN");
		lblLogin.setBackground(new Color(204, 51, 153));
		lblLogin.setForeground(new Color(204, 51, 51));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(10, 72, 1065, 48);
		add(lblLogin);
		
		
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblNewJgoodiesLabel_1.setForeground(Color.CYAN);
		lblNewJgoodiesLabel_1.setBackground(new Color(204, 51, 51)); 
		lblNewJgoodiesLabel_1.setBounds(322, 144, 440, 360);
		add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_2.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_2.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_2);
		
	}
}
