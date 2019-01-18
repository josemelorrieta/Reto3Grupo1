package vista;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelLineas extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelLineas() {
		setBackground(Color.CYAN);
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Seleccione la Linea");
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewJgoodiesLabel.setBounds(10, 45, 1080, 49);
		add(lblNewJgoodiesLabel);
		
		JButton btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCerrarSesion.setBounds(40, 612, 211, 60);
		add(btnCerrarSesion);
		
		JButton btnComprarBillete = new JButton("COMPRAR BILLETE");
		btnComprarBillete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprarBillete.setBounds(849, 612, 223, 60);
		add(btnComprarBillete);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.PINK);
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 28));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u25CF\tBilbao-Mungia", "\u25CF\tBilbao-Gernika", "\u25CF\tBilbao-Donostia"}));
		comboBox.setBounds(315, 287, 484, 82);
		add(comboBox);

	}
}
