package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

/**
 * Clase de la ventana principarl de la aplicacion
 *
 */
public class Ventana extends JFrame { 

	private JPanel contentPane;

	//Instancias de todos los paneles de la aplicacion
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
		setTitle("Gesti\u00F3n de Compra de Billetes");
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 1100, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		saludo = new PanelSaludo();
		contentPane.add(saludo);
		saludo.setLayout(null);
		
		
		login = new PanelLogin();
		login.setBackground(SystemColor.controlHighlight);
		login.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		contentPane.add(login);
		login.setLayout(null);
		
		registro = new PanelRegistro();
		registro.setBackground(Color.CYAN);
		contentPane.add(registro);
		registro.setLayout(null);
		
		billetes = new PanelBilletes();
		contentPane.add(billetes);
		billetes.setLayout(null);
		
		lineas = new PanelLineas();
		lineas.btnSiguiente.setSize(234, 68);
		lineas.btnSiguiente.setLocation(780, 549);
		lineas.listaLineas.setBackground(Color.WHITE);
		contentPane.add(lineas);
		lineas.setLayout(null); 
		
		paradas = new PanelParadas();
		paradas.btnAtras.setLocation(654, 575);
		contentPane.add(paradas);
		paradas.setLayout(null);
		
		fechas = new PanelFechas();
		fechas.btnSiguiente.setBounds(858, 575, 186, 68);
		fechas.btnAtras.setLocation(662, 575);
		fechas.dateVuelta.setBackground(Color.WHITE);
		fechas.dateIda.setBackground(Color.WHITE);
		fechas.btnRadioButton.setBackground(Color.CYAN);
		contentPane.add(fechas);
		fechas.setLayout(null);
		
		billeteComprado = new PanelBilleteComprado();
		billeteComprado.btnSiguiente.setBounds(889, 570, 165, 61);
		billeteComprado.btnAtras.setBounds(691, 570, 171, 61);
		contentPane.add(billeteComprado);
		billeteComprado.setLayout(null);
		
		pago = new PanelPago();
		contentPane.add(pago, "name_360122149477200");
		pago.pagado.setText("0");
		pago.setLayout(null);
		

		devolucion = new PanelDevolucion();
		contentPane.add(devolucion);
		devolucion.setLayout(null);
		
		despedida = new PanelDespedida();
		contentPane.add(despedida);
		despedida.setLayout(null);
		
	}
}
