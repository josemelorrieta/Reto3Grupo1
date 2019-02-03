package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * Clase del panel de despedida
 *
 */
public class PanelDespedida extends JPanel {
	
	JPanel panelDespedida = new JPanel();
	/**
	 * Create the panel.
	 */
	public PanelDespedida() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBackground(Color.RED);
		lblNewJgoodiesLabel.setBounds(0, 0, 1100, 700);
		lblNewJgoodiesLabel.setIcon(new ImageIcon(PanelDespedida.class.getResource("/Imagenes/Gracias.png")));
		add(lblNewJgoodiesLabel);

	}

}
