package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;

/**
 * Clase del panel de seleccion de origen y destino
 *
 */
public class PanelParadas extends JPanel {

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
		setBackground(Color.CYAN);
		setLayout(null);
		btnAtras.setName("btnAtrasParadas");

		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(273, 575, 194, 68);
		add(btnAtras);
		btnSiguiente.setName("btnSiguienteParadas");
		
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(858, 575, 194, 68);
		add(btnSiguiente);

		JLabel lblParadaDeOrigen = DefaultComponentFactory.getInstance().createLabel("Parada de Origen:");
		lblParadaDeOrigen.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblParadaDeOrigen.setBounds(131, 262, 352, 49);
		add(lblParadaDeOrigen);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Parada de Destino:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewJgoodiesLabel.setBounds(628, 262, 336, 37);
		add(lblNewJgoodiesLabel);
		
		paradaDeOrigen.setBackground(Color.WHITE);
		paradaDeOrigen.setBounds(131, 322, 336, 49);
		paradaDeOrigen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		paradaDeOrigen.setName("paradaDeOrigen");
		add(paradaDeOrigen);
		
		paradaDeDestino.setBackground(Color.WHITE);
		paradaDeDestino.setFont(new Font("Tahoma", Font.PLAIN, 22));
		paradaDeDestino.setBounds(628, 322, 336, 49);		
		add(paradaDeDestino);
		
	
		btnCancelar.setName("btnCancelarParadas");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(36, 575, 194, 68);
		add(btnCancelar);
		
		lblMostrarLinea = new JLabel();
		lblMostrarLinea.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarLinea.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMostrarLinea.setBounds(132, 42, 847, 60);
		add(lblMostrarLinea);
	}
}
