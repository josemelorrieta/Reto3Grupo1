package vista;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;

/**
 * Clase de la ventana principarl de la aplicacion
 *
 */
public class Ventana extends JFrame { 

	private static final long serialVersionUID = 12L;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/Imagenes/icono.png"))); 
		setTitle("Gesti\u00F3n de Compra de Billetes");
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBounds(100, 100, 1085, 696);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		saludo = new PanelSaludo();
		contentPane.add(saludo);
		saludo.setLayout(null);
		
		
		login = new PanelLogin();
		login.passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		login.TextDni.setFont(new Font("Tahoma", Font.PLAIN, 20));
		login.setBackground(SystemColor.controlHighlight);
		login.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		contentPane.add(login);
		login.setLayout(null);
		
		registro = new PanelRegistro();
		registro.btnRegistrarse.setSize(195, 70);
		registro.btnRegistrarse.setLocation(837, 551);
		registro.setBackground(SystemColor.controlHighlight);
		contentPane.add(registro);
		registro.setLayout(null);
		
		billetes = new PanelBilletes();
		billetes.setBackground(SystemColor.controlHighlight);
		contentPane.add(billetes);
		billetes.setLayout(null);
		
		lineas = new PanelLineas();
		lineas.listaLineas.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lineas.listaLineas.setBounds(310, 273, 463, 61);
		lineas.listaLineas.setForeground(Color.BLACK);
		lineas.btnSiguiente.setSize(195, 70);
		lineas.btnSiguiente.setLocation(837, 551);
		lineas.listaLineas.setBackground(Color.WHITE);
		contentPane.add(lineas);
		lineas.setLayout(null); 
		
		paradas = new PanelParadas();
		paradas.lblMostrarLinea.setBounds(10, 72, 1049, 48);
		paradas.btnCancelar.setSize(195, 70);
		paradas.btnCancelar.setLocation(48, 551);
		paradas.btnAtras.setLocation(272, 551);
		contentPane.add(paradas);
		paradas.setLayout(null);
		
		fechas = new PanelFechas();
		fechas.btnSiguiente.setBounds(837, 552, 186, 68);
		fechas.btnAtras.setLocation(272, 551);
		fechas.dateVuelta.setBackground(Color.WHITE);
		fechas.dateIda.setBackground(Color.WHITE);
		fechas.btnRadioButton.setBackground(SystemColor.controlHighlight);
		contentPane.add(fechas);
		fechas.setLayout(null);
		
		billeteComprado = new PanelBilleteComprado();
		billeteComprado.btnSiguiente.setBounds(837, 551, 195, 70);
		billeteComprado.btnAtras.setBounds(272, 551, 195, 70);
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
