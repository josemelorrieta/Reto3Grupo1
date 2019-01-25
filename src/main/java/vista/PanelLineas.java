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
	
	public JButton btnCancelar = new JButton("CANCELAR");
	public JButton btnSiguiente = new JButton("SIGUIENTE");
	public JComboBox SeleccionarLinea = new JComboBox();

	/**
	 * Create the panel.
	 */
	public PanelLineas() {
		setBackground(Color.CYAN);
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("SELECCIONE LA LINEA");
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblNewJgoodiesLabel.setBounds(10, 56, 1080, 49);
		add(lblNewJgoodiesLabel);
		btnCancelar.setName("btnCancelarLineas");
		
		
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(55, 549, 211, 68);
		add(btnCancelar);
		btnSiguiente.setName("btnSiguienteLineas");
		
		
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(790, 549, 223, 68);
		add(btnSiguiente);
		
		
		SeleccionarLinea.setBackground(Color.PINK);
		SeleccionarLinea.setForeground(Color.BLACK);
		SeleccionarLinea.setFont(new Font("Tahoma", Font.PLAIN, 28));
		SeleccionarLinea.setModel(new DefaultComboBoxModel(new String[] {"\u25CF\tTermibus-Plentzia", "\u25CF\tTermibus-Muskiz", "\u25CF\tTermibus-Balmaseda", "\u25CF\tTermibus-Durango"}));
		SeleccionarLinea.setBounds(315, 287, 484, 82);
		add(SeleccionarLinea);

	}
}
