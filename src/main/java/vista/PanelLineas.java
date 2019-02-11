package vista;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.SystemColor;

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
		setBackground(SystemColor.controlHighlight);
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setLayout(null);
		
		listaLineas.setForeground(Color.WHITE);
		listaLineas.setBackground(Color.MAGENTA);
		listaLineas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		listaLineas.setBounds(334, 296, 417, 49);		
		add(listaLineas);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("SELECCIONE LA LINEA");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(new Color(204, 51, 51));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		add(lblNewJgoodiesLabel);
		
		btnCancelar.setName("btnCancelarLineas");
		btnCancelar.setBackground(new Color(248, 248, 255));
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(48, 551, 195, 70);
		add(btnCancelar);
		
		btnSiguiente.setName("btnSiguienteLineas");
		btnSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnSiguiente.setBackground(new Color(248, 248, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(837, 551, 195, 70);
		add(btnSiguiente);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_2.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_2.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_2);

	}
}
