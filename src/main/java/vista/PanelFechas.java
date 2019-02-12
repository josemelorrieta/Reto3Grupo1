package vista;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.SystemColor;

/**
 * Clase del panel de seleccion de fechas para el bilelte
 *
 */
public class PanelFechas extends JPanel { 
	
	private static final long serialVersionUID = 7L;
	
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
		lblFechaDeIda.setForeground(Color.BLACK);
		lblFechaDeIda.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblFechaDeIda.setBounds(135, 263, 252, 49);
		add(lblFechaDeIda);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Fecha de Vuelta:");
		lblNewJgoodiesLabel.setForeground(Color.BLACK);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewJgoodiesLabel.setBounds(684, 263, 266, 49);
		add(lblNewJgoodiesLabel);
		btnRadioButton.setName("btnRadioComprarBilleteVuelta");
		btnRadioButton.setBackground(SystemColor.controlHighlight); 
		
		btnRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRadioButton.setBounds(6, 195, 1047, 48); 
		add(btnRadioButton);
		
		JLabel lblPrecio = DefaultComponentFactory.getInstance().createLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPrecio.setBounds(46, 436, 862, 37);
		add(lblPrecio);
		
		textPrecio.setText("");
		textPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		textPrecio.setFont(new Font("Tahoma", Font.PLAIN, 35));
		
		
		textPrecio.setBounds(537, 442, 140, 31);
		add(textPrecio);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("SELECCIONE FECHA");
		lblNewJgoodiesLabel_1.setForeground(new Color(204, 51, 51));
		lblNewJgoodiesLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel_1.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel_1.setBounds(10, 72, 1065, 48);
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
		
		dateIda.setBounds(135, 323, 265, 50);
		add(dateIda);
		dateVuelta.setFont(new Font("Tahoma", Font.PLAIN, 18));

		dateVuelta.setBounds(685, 323, 265, 50);
		dateVuelta.setEnabled(false);
		add(dateVuelta);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_2.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_2.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_2);

	}
}
