package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Vista extends JFrame {
	private Controlador miControlador;
	
	private JPanel contentPane;
	public JButton btnPincha;
	public JTextField textField;
	
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
	
//	public JButton getBtnNewButton() {
//		return this.btnNewButton;
//	}

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista frame = new Vista();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(111, 49, 191, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnPincha = new JButton("Pincha!");
		btnPincha.setBounds(163, 193, 89, 23);
		contentPane.add(btnPincha);
	}
}
