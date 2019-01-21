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

public class Ventana1 {

	private JFrame frame;

	public JPanel saludo = new JPanel();
	public JPanel login;
	public JPanel billetes = new JPanel();
	/**
	 * @wbp.parser.entryPoint
	 */
	public Ventana1() {
		setBounds(100, 100, 1100, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		login = new JPanel();
		frame.add(saludo);
		add(login);
		frame.add(billetes);
	}

}
