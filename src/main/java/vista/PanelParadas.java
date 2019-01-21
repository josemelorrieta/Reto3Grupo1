package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class PanelParadas extends JPanel {
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JComboBox FechaDeIda = new JComboBox();
	public JComboBox FechaDeVuelta = new JComboBox();
	public JRadioButton rdbtnNewRadioButton = new JRadioButton("Comprar billete de vuelta");
	JTextArea textPrecio = new JTextArea();
	private final JTextArea textLinea = new JTextArea();

	/**
	 * Create the panel.
	 */
	public PanelParadas() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		
		
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(29, 627, 130, 49);
		add(btnCancelar);
		
		
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(935, 627, 130, 49);
		add(btnSiguiente);
		
		JLabel lblFechaDeIda = DefaultComponentFactory.getInstance().createLabel("Fecha de Ida:");
		lblFechaDeIda.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblFechaDeIda.setBounds(129, 255, 252, 49);
		add(lblFechaDeIda);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Fecha de Vuelta:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewJgoodiesLabel.setBounds(646, 261, 314, 37);
		add(lblNewJgoodiesLabel);
		
		
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(409, 196, 224, 48);
		add(rdbtnNewRadioButton);
		
		
		FechaDeIda.setBounds(129, 312, 252, 48);
		add(FechaDeIda);
		
		
		FechaDeVuelta.setBounds(646, 309, 296, 51);
		add(FechaDeVuelta);
		
		JLabel lblPrecio = DefaultComponentFactory.getInstance().createLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPrecio.setBounds(299, 470, 138, 37);
		add(lblPrecio);
		
		
		textPrecio.setBounds(431, 470, 199, 37);
		add(textPrecio);
		textLinea.setBounds(129, 39, 831, 62);
		
		add(textLinea);

	}
}
