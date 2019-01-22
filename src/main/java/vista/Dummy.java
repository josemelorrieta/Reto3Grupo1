package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Dummy extends JPanel {

	public JButton btnLogin;
	/**
	 * Create the panel.
	 */
	public Dummy() {
		setLayout(null);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(563, 438, 77, 27);
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnLogin.setBackground(Color.PINK);
		add(btnLogin);
	}

}
