package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;

public class PanelBilletes extends JPanel {

	public JButton btnCerrarSesion = new JButton("Cerrar Sesion");
	public JButton btnComprarBillete = new JButton("Comprar Billete");
	public JList MostrarBilletes = new JList();

	/**
	 * Create the panel.
	 */
	public PanelBilletes() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("TODOS SUS BILLETES");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 26, 1080, 71);
		add(lblNewJgoodiesLabel);
		
	
		MostrarBilletes.setBounds(206, 124, 698, 429);
		add(MostrarBilletes);

		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCerrarSesion.setBounds(29, 627, 169, 49);
		add(btnCerrarSesion);
		
		
		btnComprarBillete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprarBillete.setBounds(867, 627, 198, 49);
		add(btnComprarBillete);

	}
}
