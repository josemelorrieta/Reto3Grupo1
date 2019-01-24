package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;


public class Ventana extends JFrame {

	private JPanel contentPane;

	public PanelLogin login;
	public PanelRegistro registro;
	public PanelLineas lineas;
	public PanelBilletes billetes;
	public PanelBilleteComprado billeteComprado;
	public PanelFechas fechas;
	public PanelParadas paradas;
	public PanelDevolucion devolucion;
	public PanelDespedida despedida;
	public PanelSaludo saludo;
	public PanelPago pago;
	
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
		
		saludo = new PanelSaludo();
		contentPane.add(saludo);
		saludo.setLayout(null);
		
		
		login = new PanelLogin();
		contentPane.add(login);
		login.setLayout(null);
		
		registro = new PanelRegistro();
		contentPane.add(registro);
		registro.setLayout(null);
		
		billetes = new PanelBilletes();
		contentPane.add(billetes);
		billetes.setLayout(null);
		
		lineas = new PanelLineas();
		contentPane.add(lineas);
		lineas.setLayout(null);
		
		paradas = new PanelParadas();
		contentPane.add(paradas);
		paradas.setLayout(null);
		
		fechas = new PanelFechas();
		contentPane.add(fechas);
		fechas.setLayout(null);
		
		billeteComprado = new PanelBilleteComprado();
		contentPane.add(billeteComprado);
		billeteComprado.setLayout(null);
		

		devolucion = new PanelDevolucion();
		contentPane.add(devolucion);
		devolucion.setLayout(null);
		
		despedida = new PanelDespedida();
		contentPane.add(despedida);
		despedida.setLayout(null);
		
		pago = new PanelPago();
		contentPane.add(pago);
		pago.setLayout(null);
	}
}
