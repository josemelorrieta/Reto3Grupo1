package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

/**
 * Clase del panel de devolucion de cambios
 *
 */
public class PanelDevolucion extends JPanel {
	
	private static final long serialVersionUID = 9L;
	
	public JButton btnSiguiente = new JButton("Siguiente");
	public JButton btnImprimirTicket= new JButton("Imprimir Ticket");
	public JButton btnComprarOtroBillete = new JButton("Comprar otro billete");
	public DefaultListModel<String> cambios = new DefaultListModel<String>();	
	public JList<String> devolucion = new JList<String>();
		
		

	/**
	 * Create the panel.
	 */
	public PanelDevolucion() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight); 
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("DEVOLUCIÓN");
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setForeground(new Color(204, 51, 51));
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		add(lblNewJgoodiesLabel); 
		
		
		btnImprimirTicket.setBackground(new Color(248, 248, 255));
		btnImprimirTicket.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnImprimirTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnImprimirTicket.setBounds(48, 551, 195, 70);
		btnImprimirTicket.setName("btnImprimirTicket");
		add(btnImprimirTicket);
		
		
		btnSiguiente.setName("btnSiguienteDevolucion");	
		btnSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnSiguiente.setBackground(new Color(248, 248, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(837, 551, 195, 70);
		add(btnSiguiente);
		
		cambios=new DefaultListModel<String>();
		devolucion = new JList<String>(cambios);
		devolucion.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));
		devolucion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		devolucion.setBackground(new Color(255, 255, 255));
		devolucion.setBounds(195, 134, 696, 385);
		add(devolucion);
		
		JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_5.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_5.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_5);
		
		
		btnComprarOtroBillete.setName("btnComprarOtroBilleteDevolucion");	
		btnComprarOtroBillete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnComprarOtroBillete.setBounds(425, 551, 235, 70);
		btnComprarOtroBillete.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnComprarOtroBillete.setBackground(new Color(248, 248, 255));
		add(btnComprarOtroBillete);
		
		JLabel lblNewLabel = new JLabel("Su/s billete/s ha/n sido comprado/s");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 11, 1065, 75);
		add(lblNewLabel);

	}
}
