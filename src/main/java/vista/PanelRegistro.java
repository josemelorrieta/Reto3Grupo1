package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PanelRegistro extends JPanel {

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
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		lblNewJgoodiesLabel_1.setBounds(270, 200, 92, 14);
		add(lblNewJgoodiesLabel_1);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(49, 599, 194, 68);
		add(btnAtras);
		
		JButton btnNewButton = new JButton("REGISTRARSE");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(875, 599, 188, 68);
		add(btnNewButton);

	}
}
