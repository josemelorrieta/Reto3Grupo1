package vista;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.BevelBorder;
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
import javax.swing.JTextField;
import java.awt.SystemColor;

/**
 * Clase del panel de seleccion de fechas para el bilelte
 *
 */
public class PanelFechas extends JPanel { 
	
	public JButton btnAtras = new JButton("Atrás");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JButton btnCancelar = new JButton("Cancelar");
	public JRadioButton btnRadioButton = new JRadioButton("Comprar billete de vuelta");
	public JLabel textPrecio = new JLabel();
	public JDateChooser dateIda = new JDateChooser();
	public JDateChooser dateVuelta = new JDateChooser();


	/**
	 * Create the panel.
	 */
	public PanelFechas() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null); 
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnAtras.setName("btnAtrasFechas");
		btnAtras.setSize(195, 70);
		btnAtras.setLocation(270, 551);
		btnAtras.setName("btnAtrasFechas");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnAtras.setBackground(new Color(248, 248, 255));
		add(btnAtras);
		
		btnSiguiente.setName("btnSiguienteFechas");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnSiguiente.setBackground(new Color(248, 248, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(837, 551, 195, 70);
		btnSiguiente.setEnabled(false);
		add(btnSiguiente);
		
		JLabel lblFechaDeIda = DefaultComponentFactory.getInstance().createLabel("Fecha de Ida:");
		lblFechaDeIda.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblFechaDeIda.setBounds(118, 263, 252, 49);
		add(lblFechaDeIda);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Fecha de Vuelta:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewJgoodiesLabel.setBounds(648, 269, 314, 37);
		add(lblNewJgoodiesLabel);
		btnRadioButton.setName("btnRadioComprarBilleteVuelta");
		btnRadioButton.setBackground(SystemColor.controlHighlight); 
		
		btnRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioButton.setBounds(367, 196, 284, 48); 
		add(btnRadioButton);
		
		JLabel lblPrecio = DefaultComponentFactory.getInstance().createLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPrecio.setBounds(337, 452, 138, 37);
		add(lblPrecio);
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		
		textPrecio.setBounds(452, 452, 199, 37);
		add(textPrecio);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("SELECCIONE FECHA");
		lblNewJgoodiesLabel_1.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblNewJgoodiesLabel_1.setBounds(10, 26, 1080, 68);
		add(lblNewJgoodiesLabel_1);
		
		btnCancelar.setName("btnCancelarFechas");
		btnCancelar.setBackground(new Color(248, 248, 255));
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(48, 551, 195, 70);	
		add(btnCancelar);
		
		dateIda.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateIda.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
			}
		});
		
		dateIda.setBounds(118, 323, 265, 50);
		add(dateIda);
		dateVuelta.setFont(new Font("Tahoma", Font.PLAIN, 18));

		dateVuelta.setBounds(650, 323, 265, 50);
		dateVuelta.setEnabled(false);
		add(dateVuelta);

	}
}
