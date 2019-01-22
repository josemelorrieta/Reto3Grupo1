package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Ventana extends JFrame {

	private JPanel contentPane;

	public PanelLogin login;
	public PanelRegistro registro;
	public PanelLineas lineas;
	public PanelBilletes billetes;
	public PanelBilleteComprado billeteComprado;
	public PanelFechas fechas;
	
	/**
	 * Create the frame.
	 */
	public Ventana() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 1100, 700);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		
		login = new PanelLogin();
		contentPane.add(login);
		login.setLayout(null);
		
		registro = new PanelRegistro();
		contentPane.add(registro);
		registro.setLayout(null);
		
		billeteComprado = new PanelBilleteComprado();
		contentPane.add(billeteComprado);
		billeteComprado.setLayout(null);
		
		lineas = new PanelLineas();
		contentPane.add(lineas);
		lineas.setLayout(null);
		
		billetes = new PanelBilletes();
		contentPane.add(billetes);
		billetes.setLayout(null);
		
		fechas = new PanelFechas();
		contentPane.add(fechas);
		fechas.setLayout(null);
	}
}
