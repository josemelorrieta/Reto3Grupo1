package vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class PanelSaludo extends JPanel {

	JPanel panelSaludo = new JPanel();
	/**
	 * @wbp.parser.entryPoint
	 */
	public void crearPanelSaludo() {
		panelSaludo.setForeground(Color.WHITE);
		panelSaludo.setBorder(new LineBorder(Color.BLACK, 4));
		panelSaludo.setBackground(Color.WHITE);
		panelSaludo.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("(PULSE PARA CONTINUAR)");
		lblNewJgoodiesLabel.setBackground(Color.WHITE);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(0, 420, 1084, 78);
		panelSaludo.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		lblNewJgoodiesLabel_3.setBackground(Color.WHITE);
		lblNewJgoodiesLabel_3.setIcon(new ImageIcon(Ventana1.class.getResource("/Imagenes/bienvenido.gif")));
		lblNewJgoodiesLabel_3.setBounds(20, 79, 1064, 347);
		panelSaludo.add(lblNewJgoodiesLabel_3);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		lblNewJgoodiesLabel_1.setIcon(new ImageIcon(PanelSaludo.class.getResource("/Imagenes/logo-termibus.png")));
		lblNewJgoodiesLabel_1.setBounds(730, 541, 302, 111);
		panelSaludo.add(lblNewJgoodiesLabel_1);
	}
}
