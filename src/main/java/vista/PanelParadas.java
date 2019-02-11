package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

/**
 * Clase del panel de seleccion de origen y destino
 *
 */
public class PanelParadas extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JButton btnAtras = new JButton("Atrás");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JButton btnCancelar = new JButton("Cancelar");
	public DefaultComboBoxModel<String> modeloOrigen = new DefaultComboBoxModel	<String>();
	public DefaultComboBoxModel<String> modeloDestino = new DefaultComboBoxModel<String>();
	public JComboBox<String> paradaDeOrigen = new JComboBox<String>();
	public JComboBox<String> paradaDeDestino = new JComboBox<String>();
	public JLabel lblMostrarLinea;

	/**
	 * Create the panel.
	 */
	public PanelParadas() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		btnAtras.setSize(195, 70);
		btnAtras.setLocation(270, 551);
		btnAtras.setName("btnAtrasParadas");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnAtras.setBackground(new Color(248, 248, 255));
		add(btnAtras);
		
		btnSiguiente.setName("btnSiguienteParadas");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnSiguiente.setBackground(new Color(248, 248, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(837, 551, 195, 70);
		add(btnSiguiente);

		JLabel lblParadaDeOrigen = DefaultComponentFactory.getInstance().createLabel("Parada de Origen:");
		lblParadaDeOrigen.setForeground(Color.BLACK);
		lblParadaDeOrigen.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblParadaDeOrigen.setBounds(75, 262, 352, 49);
		add(lblParadaDeOrigen);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Parada de Destino:");
		lblNewJgoodiesLabel.setForeground(Color.BLACK);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewJgoodiesLabel.setBounds(565, 262, 336, 49);
		add(lblNewJgoodiesLabel);
		
		paradaDeOrigen.setBackground(Color.WHITE);
		paradaDeOrigen.setBounds(75, 322, 417, 49);
		paradaDeOrigen.setFont(new Font("Tahoma", Font.PLAIN, 30));
		paradaDeOrigen.setName("paradaDeOrigen");
		add(paradaDeOrigen);
		
		paradaDeDestino.setBackground(Color.WHITE);
		paradaDeDestino.setFont(new Font("Tahoma", Font.PLAIN, 30));
		paradaDeDestino.setBounds(565, 322, 417, 49);		
		add(paradaDeDestino);
		
	
		btnCancelar.setName("btnCancelarParadas");
		btnCancelar.setBackground(new Color(248, 248, 255));
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(48, 551, 195, 70);
		add(btnCancelar);
		
		lblMostrarLinea = new JLabel();
		lblMostrarLinea.setForeground(new Color(204, 51, 51));
		lblMostrarLinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarLinea.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMostrarLinea.setBackground(new Color(204, 51, 153));
		lblMostrarLinea.setBounds(10, 72, 1065, 48);
		add(lblMostrarLinea);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_2.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_2.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_2);
	}
}
