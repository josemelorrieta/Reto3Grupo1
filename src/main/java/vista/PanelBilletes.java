package vista;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

/**
 * Clase del panel que muestra los billetes del cliente logeado
 *
 */
public class PanelBilletes extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JButton btnCerrarSesion = new JButton("Cerrar Sesion");
	public JButton btnComprarBillete = new JButton("Comprar Billete");
	public DefaultListModel<String> modeloMostrarBilletes = new DefaultListModel<String>();
	public JList<String> MostrarBilletes = new JList<String>();

	/** 
	 * Create the panel.
	 */ 
	public PanelBilletes() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_1.setIcon(new ImageIcon(PanelBilletes.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_1.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_1);
		

		MostrarBilletes.setFont(new Font("Consolas", Font.PLAIN, 22));
		MostrarBilletes.setBounds(119, 166, 846, 336);
		add(MostrarBilletes);
		
		btnCerrarSesion.setName("btnCerrarSesionBilletes");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCerrarSesion.setBackground(new Color(248, 248, 255));
		btnCerrarSesion.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCerrarSesion.setBounds(48, 551, 195, 70);
		add(btnCerrarSesion);
		
		btnComprarBillete.setName("btnComprarBilleteBilletes");
		btnComprarBillete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprarBillete.setBackground(new Color(248, 248, 255));
		btnComprarBillete.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnComprarBillete.setBounds(837, 551, 195, 70);
		add(btnComprarBillete);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("TODOS SUS BILLETES");
		lblNewJgoodiesLabel.setForeground(new Color(255, 255, 0));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setForeground(new Color(204, 51, 51));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		add(lblNewJgoodiesLabel);

	}
}
