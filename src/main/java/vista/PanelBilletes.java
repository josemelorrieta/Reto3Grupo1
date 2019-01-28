package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;

public class PanelBilletes extends JPanel {

	public JButton btnCerrarSesion = new JButton("Cerrar Sesion");
	public JButton btnComprarBillete = new JButton("Comprar Billete");
	public DefaultListModel<String> modeloMostrarBilletes = new DefaultListModel<String>();
	public JList<String> MostrarBilletes = new JList<String>();

	/** 
	 * Create the panel.
	 */
	public PanelBilletes() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("TODOS SUS BILLETES");
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 43, 1080, 71);
		add(lblNewJgoodiesLabel);
		
	
		MostrarBilletes.setBounds(211, 125, 668, 403);
		add(MostrarBilletes);
		btnCerrarSesion.setName("btnCerrarSesionBilletes");

		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCerrarSesion.setBounds(48, 575, 194, 68);
		add(btnCerrarSesion);
		btnComprarBillete.setName("btnComprarBilleteBilletes");
		
		
		btnComprarBillete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprarBillete.setBounds(857, 578, 199, 65);
		add(btnComprarBillete);

	}
}
