package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;

/**
 * Clase del panel de despedida
 *
 */
public class PanelDespedida extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JPanel panelDespedida = new JPanel();
	
	/**
	 * Create the panel.
	 */
	public PanelDespedida() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel.setBounds(0, 0, 1100, 701);
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		lblNewJgoodiesLabel.setBackground(Color.RED);

		lblNewJgoodiesLabel.setBounds(0, 0, 1100, 700);
		lblNewJgoodiesLabel.setIcon(new ImageIcon(PanelDespedida.class.getResource("/imagenes/Gracias.png")));
		add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("SU SESIÓN SE CERRARÁ");
		lblNewJgoodiesLabel_1.setForeground(Color.RED);
		lblNewJgoodiesLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 30));
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setBounds(10, 56, 1100, 31);
		add(lblNewJgoodiesLabel_1);

	}
}
