package vista;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;


/**
 * Calse del panel que muestra el resumen del billete comprado
 *
 */
public class PanelBilleteComprado extends JPanel {
	
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
		setBackground(Color.CYAN);
		setLayout(null);
		btnCancelar.setName("btnCancelarBilleteComprado");
		
	
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(37, 570, 145, 61);
		add(btnCancelar);
		
		btnAtras.setName("btnAtrasBilleteComprado");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(705, 570, 145, 61);
		add(btnAtras);
		
		btnSiguiente.setName("btnSiguienteBilleteComprado");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(901, 570, 153, 61);
		add(btnSiguiente);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("COMPRUEBE EL BILLETE");
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setBounds(10, 36, 1080, 47);
		add(lblNewJgoodiesLabel);
		
		JLabel lblIda = new JLabel("Billete de Ida");
		lblIda.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIda.setBounds(101, 135, 212, 47);
		add(lblIda);
		
		JLabel lblVuelta = new JLabel("Billete de Vuelta");
		lblVuelta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblVuelta.setBounds(101, 300, 286, 47);
		add(lblVuelta);
		
		txtIda = new JLabel();
		txtIda.setOpaque(true);
		txtIda.setBackground(Color.WHITE);
		txtIda.setHorizontalAlignment(SwingConstants.CENTER);
		txtIda.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtIda.setBounds(101, 193, 914, 61);
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
		lblPrecioTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblPrecioTotal.setBounds(554, 462, 153, 55);
		add(lblPrecioTotal);
		
		JLabel lblIvaIncluido = new JLabel("(IVA incluido)");
		lblIvaIncluido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIvaIncluido.setBounds(717, 478, 298, 34);
		add(lblIvaIncluido);

	}
}
