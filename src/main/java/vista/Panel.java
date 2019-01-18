package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel window = new Panel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Panel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panelLogin = new JPanel();
		
		JPanel panelSaludo = new JPanel();
		panelSaludo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panelSaludo.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		frame.getContentPane().add(panelSaludo, "name_698243167398200");
		panelSaludo.setLayout(null);
		
		JPanel panelDespedida = new JPanel();
		frame.getContentPane().add(panelDespedida, "name_698243176000200");
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_1.setIcon(new ImageIcon(Panel.class.getResource("/Imagenes/Gracias.png")));
		panelDespedida.add(lblNewJgoodiesLabel_1);
		
		
		frame.getContentPane().add(panelLogin, "name_698243183741800");
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
		panelLogin.add(lblNewJgoodiesLabel_2);
	}

}
