package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JList;

/**
 * Calse del panel que muestra el resumen del billete comprado
 *
 */
public class PanelBilleteComprado extends JPanel {
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnAtras = new JButton("Atras");
	public JButton btnSiguiente = new JButton("Siguiente");
	public DefaultListModel<String> modeloMostrarBilletesComprado = new DefaultListModel<String>();
	public JList<String> MostrarBilleteComprado = new JList<String>();
	private final JButton btnBilleteDeIda = new JButton("Billete de Ida");
	private final JButton btnBilleteDeVuelta = new JButton("Billete de Vuelta");

	/**
	 * Create the panel.
	 */ 
	public PanelBilleteComprado() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		btnCancelar.setName("btnCancelarBilleteComprado");
		
	
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(37, 570, 145, 61);
		add(btnCancelar);
		
		btnAtras.setName("btnAtrasBilleteComprado");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(705, 570, 145, 61);
		add(btnAtras);
		
		btnSiguiente.setName("btnSiguienteBilleteComprado");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(901, 570, 153, 61);
		add(btnSiguiente);
		
		JLabel lblSusBilletes = DefaultComponentFactory.getInstance().createLabel("Su Billete");
		lblSusBilletes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSusBilletes.setHorizontalAlignment(SwingConstants.CENTER);
		lblSusBilletes.setBounds(166, 133, 177, 37);
		add(lblSusBilletes);
		
		
		MostrarBilleteComprado.setBounds(166, 192, 643, 351);
		add(MostrarBilleteComprado);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("COMPRUEBE EL BILLETE");
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 51, 1080, 47);
		add(lblNewJgoodiesLabel);
		btnBilleteDeIda.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBilleteDeIda.setBounds(874, 207, 145, 102);
		
		add(btnBilleteDeIda);
		btnBilleteDeVuelta.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBilleteDeVuelta.setBounds(874, 363, 145, 102);
		
		add(btnBilleteDeVuelta);

	}
}
