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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFechas extends JPanel { 
	
	public JButton btnAtras = new JButton("Atras");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JButton btnCancelar = new JButton("Cancelar");
	public JComboBox FechaDeIda = new JComboBox();
	public JComboBox FechaDeVuelta = new JComboBox();
	public JRadioButton btnRadioButton = new JRadioButton("Comprar billete de vuelta");
	public JTextArea textPrecio = new JTextArea();


	/**
	 * Create the panel.
	 */
	public PanelFechas() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		
		btnAtras.setName("btnAtrasFechas");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(287, 575, 186, 68);
		add(btnAtras);
		
		btnSiguiente.setName("btnSiguienteFechas");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(858, 575, 194, 68);
		add(btnSiguiente);
		
		JLabel lblFechaDeIda = DefaultComponentFactory.getInstance().createLabel("Fecha de Ida:");
		lblFechaDeIda.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblFechaDeIda.setBounds(129, 255, 252, 49);
		add(lblFechaDeIda);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Fecha de Vuelta:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewJgoodiesLabel.setBounds(646, 261, 314, 37);
		add(lblNewJgoodiesLabel);
		btnRadioButton.setName("btnRadioComprarBilleteVuelta");
		btnRadioButton.setBackground(Color.CYAN);
		
		btnRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioButton.setBounds(367, 196, 284, 48);
		add(btnRadioButton);
		
		FechaDeIda.setForeground(Color.BLACK);
		FechaDeIda.setBackground(Color.WHITE);
		FechaDeIda.setBounds(129, 312, 252, 48);
		add(FechaDeIda);
		FechaDeVuelta.setEnabled(false);
		
		FechaDeVuelta.setBackground(Color.WHITE);		
		FechaDeVuelta.setBounds(646, 309, 296, 51);
		add(FechaDeVuelta);
		
		JLabel lblPrecio = DefaultComponentFactory.getInstance().createLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPrecio.setBounds(316, 452, 138, 37);
		add(lblPrecio);
		
		
		textPrecio.setBounds(452, 452, 199, 49);
		add(textPrecio);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("SELECCIONE FECHA");
		lblNewJgoodiesLabel_1.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblNewJgoodiesLabel_1.setBounds(10, 26, 1080, 68);
		add(lblNewJgoodiesLabel_1);
		
		btnCancelar.setName("btnCancelarFechas");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(53, 575, 186, 68);	
		add(btnCancelar);

	}
}
