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
import com.toedter.calendar.JDateChooser;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class PanelFechas extends JPanel { 
	
	public JButton btnAtras = new JButton("Atras");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JButton btnCancelar = new JButton("Cancelar");
	public JRadioButton btnRadioButton = new JRadioButton("Comprar billete de vuelta");
	public JTextArea textPrecio = new JTextArea();
	public JDateChooser dateIda = new JDateChooser();
	public JDateChooser dateVuelta = new JDateChooser();


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
		
		JLabel lblPrecio = DefaultComponentFactory.getInstance().createLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPrecio.setBounds(316, 452, 138, 37);
		add(lblPrecio);
		textPrecio.setEditable(false);
		textPrecio.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		
		textPrecio.setBounds(452, 458, 199, 37);
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
		dateIda.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		
		dateIda.setBounds(118, 309, 265, 50);
		add(dateIda);

		dateVuelta.setBounds(656, 309, 265, 50);
		dateVuelta.setEnabled(false);
		add(dateVuelta);

	}
}
