package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;

public class PanelParadas extends JPanel {
	
	public JButton btnAtras = new JButton("Atras");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JButton btnCancelar = new JButton("Cancelar");
	public JComboBox ParadaDeOrigen = new JComboBox();
	public JComboBox ParadaDeDestino = new JComboBox();
	private final JTextArea textArea = new JTextArea();

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
		lblNewJgoodiesLabel.setBounds(628, 268, 336, 37);
		add(lblNewJgoodiesLabel);
		
		ParadaDeOrigen.setBounds(131, 322, 336, 49);
		add(ParadaDeOrigen);
		
		ParadaDeDestino.setBounds(628, 316, 351, 49);		
		add(ParadaDeDestino);
		
		textArea.setBounds(131, 40, 848, 62);
		add(textArea);
		
	
		btnCancelar.setName("btnCancelarParadas");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(36, 575, 194, 68);
		add(btnCancelar);
	}
}
