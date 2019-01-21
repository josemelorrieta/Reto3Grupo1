package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class PanelBilleteComprado extends JPanel {
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnAtras = new JButton("Atras");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JList MostrarBillete = new JList();
	private final JButton btnBilleteDeIda = new JButton("Billete de Ida");
	private final JButton btnBilleteDeVuelta = new JButton("Billete de Vuelta");

	/**
	 * Create the panel.
	 */
	public PanelBilleteComprado() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		
	
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(36, 627, 122, 47);
		add(btnCancelar);
		
		
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(726, 627, 122, 47);
		add(btnAtras);
		
		
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(913, 627, 145, 47);
		add(btnSiguiente);
		
		JLabel lblSusBilletes = DefaultComponentFactory.getInstance().createLabel("Su Billete");
		lblSusBilletes.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSusBilletes.setHorizontalAlignment(SwingConstants.CENTER);
		lblSusBilletes.setBounds(166, 133, 177, 37);
		add(lblSusBilletes);
		
		
		MostrarBillete.setBounds(166, 192, 643, 351);
		add(MostrarBillete);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Compruebe El Billete");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 43, 1080, 47);
		add(lblNewJgoodiesLabel);
		btnBilleteDeIda.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBilleteDeIda.setBounds(874, 207, 145, 102);
		
		add(btnBilleteDeIda);
		btnBilleteDeVuelta.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBilleteDeVuelta.setBounds(874, 363, 145, 102);
		
		add(btnBilleteDeVuelta);

	}
}
