package vista;

import java.awt.Font;

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

public class PanelLogin extends JPanel {
	public PanelLogin() {
	}
	JPanel panelLogin = new JPanel();
	private JTextField TextDni;
	private JPasswordField passwordField;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void crearPanelLogin() {
		panelLogin.setBackground(Color.CYAN);
		panelLogin.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panelLogin.setLayout(null);
		
		JLabel lblLogin = DefaultComponentFactory.getInstance().createLabel("LOGIN");
		lblLogin.setBounds(0, 53, 1100, 61);
		lblLogin.setBackground(Color.DARK_GRAY);
		lblLogin.setForeground(Color.PINK);
		lblLogin.setLabelFor(lblLogin);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 50));
		panelLogin.add(lblLogin);
		
		JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistrarse.setBounds(867, 619, 194, 54);
		panelLogin.add(btnRegistrarse);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(50, 612, 194, 54);
		panelLogin.add(btnAtras);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(229, 123, 651, 455);
		panel.setBorder(new LineBorder(new Color(255, 175, 175), 3, true));
		panelLogin.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_3.setBounds(6, 116, 645, 33);
		lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("CONTRASE\u00D1A:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(6, 223, 639, 33);
		panel.add(lblNewJgoodiesLabel);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnLogin.setBackground(Color.PINK);
		btnLogin.setBounds(227, 359, 213, 57);
		panel.add(btnLogin);
		
		TextDni = new JTextField();
		TextDni.setBounds(180, 157, 298, 33);
		panel.add(TextDni);
		TextDni.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(180, 267, 298, 33);
		panel.add(passwordField);
		
		
	}
}
