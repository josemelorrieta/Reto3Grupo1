package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;

/**
 * Clase del panel de saludo
 *
 */
public class PanelSaludo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JPanel panelSaludo = new JPanel();
	JLabel lblNewJgoodiesLabel_3;
	JLabel lblNewJgoodiesLabel_1;
	public JButton btnSaludo = new JButton("");

	/**
	 * Create the panel.
	 */
	public PanelSaludo() {
		
		setForeground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK, 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		JLabel lblPoweredBy = DefaultComponentFactory.getInstance().createLabel("POWERED BY");
		lblPoweredBy.setForeground(new Color(0, 0, 139));
		lblPoweredBy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPoweredBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoweredBy.setBounds(790, 20, 136, 40);
		add(lblPoweredBy);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_2.setIcon(new ImageIcon(PanelSaludo.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_2.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_2);
		
		lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_3.setIcon(new ImageIcon(PanelSaludo.class.getResource("/imagenes/bienvenido3.png")));
		lblNewJgoodiesLabel_3.setBackground(Color.WHITE);
		lblNewJgoodiesLabel_3.setIcon(new ImageIcon(PanelSaludo.class.getResource("/imagenes/bienvenido3.png")));
		lblNewJgoodiesLabel_3.setBounds(97, 121, 890, 347);
		add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("(PULSE PARA CONTINUAR)");
		lblNewJgoodiesLabel.setBackground(Color.WHITE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 438, 1080, 78);
		add(lblNewJgoodiesLabel);
		btnSaludo.setName("btnSaludo");
		
		
		btnSaludo.setBounds(-14, -11, 1114, 732);
		btnSaludo.setContentAreaFilled(false);
		add(btnSaludo);
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewJgoodiesLabel_4.setIcon(new ImageIcon(PanelSaludo.class.getResource("/imagenes/logo.png")));
		lblNewJgoodiesLabel_4.setBounds(800, 26, 242, 82);
		add(lblNewJgoodiesLabel_4);
		
	}
}
