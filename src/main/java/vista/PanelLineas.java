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

/** 
 * Clase del panel de seleccion de linea
 *
 */
public class PanelLineas extends JPanel { 
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultComboBoxModel<String> modeloLineas = new DefaultComboBoxModel<String>();
	public JComboBox<String> listaLineas = new JComboBox<String>();

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
		
		
		listaLineas.setBackground(Color.WHITE);
		listaLineas.setForeground(Color.BLACK);
		listaLineas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		listaLineas.setBounds(315, 287, 484, 82);
		add(listaLineas);

	}
}
