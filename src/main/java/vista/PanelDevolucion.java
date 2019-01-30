package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class PanelDevolucion extends JPanel {
	
		public JButton btnSiguiente = new JButton("Siguiente");
		public JButton btnImprimirTicket= new JButton("Imprimir Ticket");
		
		public DefaultListModel<String> cambios = new DefaultListModel<String>();	
		public JList<String> Devolucion = new JList<String>();

	/**
	 * Create the panel.
	 */
	public PanelDevolucion() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("DEVOLUCION");
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblNewJgoodiesLabel.setBounds(10, 52, 1080, 48);
		add(lblNewJgoodiesLabel);
		
		
		btnImprimirTicket.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnImprimirTicket.setBounds(39, 577, 213, 65);
		add(btnImprimirTicket);
		
		
		btnSiguiente.setName("btnSiguienteDevolucion");	
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(858, 575, 194, 68);
		add(btnSiguiente);
		
		cambios=new DefaultListModel();
		Devolucion = new JList(cambios);
		Devolucion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Devolucion.setBackground(new Color(255, 255, 255));
		Devolucion.setBounds(367, 103, 282, 263);
//		PanelDevolucion.add(Devolucion);
		


	}

}
