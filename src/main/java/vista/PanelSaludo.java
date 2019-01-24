package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class PanelSaludo extends JPanel {
	
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
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("(PULSE PARA CONTINUAR)");
		lblNewJgoodiesLabel.setBackground(Color.WHITE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(0, 420, 1084, 78);
		add(lblNewJgoodiesLabel);
		
		lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		lblNewJgoodiesLabel_1.setIcon(new ImageIcon(PanelSaludo.class.getResource("/Imagenes/logo-termibus.png")));
		lblNewJgoodiesLabel_1.setBounds(739, 526, 302, 111);
		add(lblNewJgoodiesLabel_1);
		
		lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		lblNewJgoodiesLabel_3.setBackground(Color.WHITE);
		lblNewJgoodiesLabel_3.setIcon(new ImageIcon(Ventana.class.getResource("/Imagenes/bienvenido.gif")));
		lblNewJgoodiesLabel_3.setBounds(10, 77, 1064, 347);
		add(lblNewJgoodiesLabel_3);
		btnSaludo.setName("btnSaludo");
		
		
		btnSaludo.setBounds(-14, -11, 1150, 732);
		btnSaludo.setContentAreaFilled(false);
		add(btnSaludo);
		
	}
}
