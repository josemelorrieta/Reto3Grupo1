package vista;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


/**
 * Calse del panel que muestra el resumen del billete comprado
 *
 */
public class PanelBilleteComprado extends JPanel {
	
	private static final long serialVersionUID = 10L;
	
	public JButton btnCancelar = new JButton("Cancelar");
	public JButton btnAtras = new JButton("Atrás");
	public JButton btnSiguiente = new JButton("Siguiente");
	public JLabel txtIda;
	public JLabel txtVuelta;
	public JLabel lblPrecioTotal;

	/**
	 * Create the panel.
	 */ 
	public PanelBilleteComprado() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(SystemColor.controlHighlight);
		setLayout(null);
		
		btnCancelar.setName("btnCancelarBilleteComprado");
		btnCancelar.setBackground(new Color(248, 248, 255));
		btnCancelar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 239, 213), new Color(255, 239, 213), null, null));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(48, 551, 195, 70);	
		add(btnCancelar);
		
		btnAtras.setName("btnAtrasBilleteComprado");
		btnAtras.setSize(195, 70);
		btnAtras.setLocation(270, 551);
		btnAtras.setName("btnAtrasFechas");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnAtras.setBackground(new Color(248, 248, 255));
		add(btnAtras);
		
		btnSiguiente.setName("btnSiguienteBilleteComprado");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 248, 220), new Color(255, 248, 220), null, null));
		btnSiguiente.setBackground(new Color(248, 248, 255));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(837, 551, 195, 70);
		add(btnSiguiente);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("COMPRUEBE EL BILLETE");
		lblNewJgoodiesLabel.setForeground(new Color(204, 51, 51));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewJgoodiesLabel.setBackground(new Color(204, 51, 153));
		lblNewJgoodiesLabel.setBounds(10, 72, 1065, 48);
		add(lblNewJgoodiesLabel);
		
		JLabel lblIda = new JLabel("Billete de Ida :");
		lblIda.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblIda.setBounds(101, 145, 239, 47);
		add(lblIda);
		
		JLabel lblVuelta = new JLabel("Billete de Vuelta :");
		lblVuelta.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblVuelta.setBounds(101, 300, 286, 47);
		add(lblVuelta);
		
		txtIda = new JLabel();
		txtIda.setOpaque(true);
		txtIda.setBackground(Color.WHITE);
		txtIda.setHorizontalAlignment(SwingConstants.CENTER);
		txtIda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtIda.setBounds(101, 207, 914, 61);
		add(txtIda);
		
		txtVuelta = new JLabel();
		txtVuelta.setBackground(Color.WHITE);
		txtVuelta.setOpaque(true);
		txtVuelta.setHorizontalAlignment(SwingConstants.CENTER);
		txtVuelta.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtVuelta.setBounds(101, 358, 914, 61);
		add(txtVuelta);
		
		JLabel lblPrecio = new JLabel("Precio Total:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrecio.setBounds(360, 462, 184, 55);
		add(lblPrecio);
		
		lblPrecioTotal = new JLabel("");
		lblPrecioTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioTotal.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblPrecioTotal.setBounds(542, 462, 150, 55);
		add(lblPrecioTotal);
		
		JLabel lblIvaIncluido = new JLabel("(IVA incluido)");
		lblIvaIncluido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIvaIncluido.setBounds(717, 478, 103, 34);
		add(lblIvaIncluido);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel_2.setIcon(new ImageIcon(PanelLogin.class.getResource("/imagenes/logo-termibus2.jpg")));
		lblNewJgoodiesLabel_2.setBounds(26, 26, 211, 82);
		add(lblNewJgoodiesLabel_2);

	}
}
