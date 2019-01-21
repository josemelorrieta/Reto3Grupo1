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
	
	public JButton btnCerrarSesion = new JButton("CERRAR SESION");
	public JButton btnComprarBillete = new JButton("COMPRAR BILLETE");
	public JComboBox SeleccionarLinea = new JComboBox();

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
		
		
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCerrarSesion.setBounds(40, 612, 211, 60);
		add(btnCerrarSesion);
		
		
		btnComprarBillete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprarBillete.setBounds(849, 612, 223, 60);
		add(btnComprarBillete);
		
		
		SeleccionarLinea.setBackground(Color.PINK);
		SeleccionarLinea.setForeground(Color.BLACK);
		SeleccionarLinea.setFont(new Font("Tahoma", Font.PLAIN, 28));
		SeleccionarLinea.setModel(new DefaultComboBoxModel(new String[] {"\u25CF\tTermibus-Plentzia", "\u25CF\tTermibus-Muskiz", "\u25CF\tTermibus-Balmaseda", "\u25CF\tTermibus-Durango"}));
		SeleccionarLinea.setBounds(315, 287, 484, 82);
		add(SeleccionarLinea);

	}
}
