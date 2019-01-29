package vista;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPago extends JPanel {
	
		public JButton btnCancelar = new JButton("Cancelar");
		public JButton btnAtras = new JButton("Atras");
		public JButton btnSiguiente = new JButton("Siguiente");
		
		public JTextField total = new JTextField();
		public JTextField pagado = new JTextField();
		public JTextField restante = new JTextField();
	
		public JButton btn500;
		public JButton btn200;
		public JButton btn100;
		public JButton btn50;
		public JButton btn20;
		public JButton btn10;
		public JButton btn5;
		public JButton btn2;
		public JButton btn1;
		public JButton btn050;
		public JButton btn020;
		public JButton btn010;
		public JButton btn005;
		public JButton btn002;
		public JButton btn001;
		

	/**
	 * Create the panel.
	 */
	public PanelPago() {
		setBorder(new LineBorder(new Color(0, 0, 0), 4));
		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("PAGO");
		lblNewJgoodiesLabel.setForeground(Color.ORANGE);
		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblNewJgoodiesLabel.setBounds(10, 36, 1080, 47);
		add(lblNewJgoodiesLabel);
		btnCancelar.setName("btnCancelarPago");
		
		
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelar.setBounds(51, 553, 156, 70);
		add(btnCancelar);
		btnAtras.setName("btnAtrasPago");
		
		
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAtras.setBounds(658, 553, 156, 70);
		add(btnAtras);
		btnSiguiente.setEnabled(false);
		btnSiguiente.setName("btnSiguientePago");
		
		
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSiguiente.setBounds(877, 553, 156, 70);
		add(btnSiguiente);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("TOTAL:");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewJgoodiesLabel_1.setBounds(672, 199, 127, 47);
		add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("PAGADO:");
		lblNewJgoodiesLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewJgoodiesLabel_2.setBounds(658, 303, 127, 30);
		add(lblNewJgoodiesLabel_2);
		
		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("RESTANTE:");
		lblNewJgoodiesLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewJgoodiesLabel_3.setBounds(629, 390, 156, 47);
		add(lblNewJgoodiesLabel_3);		
		total.setFont(new Font("Tahoma", Font.PLAIN, 17));
		total.setEditable(false);
	
		total.setBounds(795, 206, 186, 30);
		add(total);
		pagado.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pagado.setEditable(false);
		
		
		pagado.setBounds(795, 303, 186, 30);
		add(pagado);
		restante.setEditable(false);
		
		
		restante.setBounds(795, 397, 186, 30);
		add(restante);
		

		btn5 = new JButton("5");
		btn5.setName("btn5");
		btn5.setBackground(Color.GREEN);
		btn5.setFont(btn5.getFont().deriveFont(0f));
		btn5.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5euros.jpg")));
		btn5.setBounds(100, 302, 123, 54);
		add(btn5);

		btn2 = new JButton("2");
		btn2.setName("btn2");
		btn2.setBackground(Color.GREEN);
		btn2.setFont(btn2.getFont().deriveFont(0f));
		btn2.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2euros.png")));
		btn2.setBounds(260, 302, 123, 54);
		add(btn2);

		btn10 = new JButton("10");
		btn10.setName("btn10");
		btn10.setBackground(Color.GREEN);
		btn10.setFont(btn10.getFont().deriveFont(0f));
		btn10.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10euros.jpg")));
		btn10.setBounds(420, 238, 123, 54);
		add(btn10);

		btn200 = new JButton("200");
		btn200.setName("btn200");
		btn200.setBackground(Color.GREEN);
		btn200.setFont(btn200.getFont().deriveFont(0f));
		btn200.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/200euros.jpg")));
		btn200.setBounds(260, 174, 123, 54);
		add(btn200);

		btn20 = new JButton("20");
		btn20.setName("btn20");
		btn20.setBackground(Color.GREEN);
		btn20.setFont(btn20.getFont().deriveFont(0f));
		btn20.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20euros.jpg")));
		btn20.setBounds(260, 238, 123, 54);
		add(btn20);

		btn500 = new JButton("500");
		btn500.setName("btn500");
		btn500.setBackground(Color.GREEN);
		btn500.setFont(btn500.getFont().deriveFont(0f));
		btn500.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/500euros.jpg")));
		btn500.setBounds(100, 174, 123, 54);
		add(btn500);
		
		btn100 = new JButton("100");
		btn100.setName("btn100");
		btn100.setBackground(Color.GREEN);
		btn100.setFont(btn100.getFont().deriveFont(0f));
		btn100.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/100euros.jpg")));
		btn100.setBounds(420, 174, 123, 54);
		add(btn100);

		btn50 = new JButton("50");
		btn50.setName("btn50");
		btn50.setBackground(Color.GREEN);
		btn50.setFont(btn50.getFont().deriveFont(0f));
		btn50.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50euros.jpg")));
		btn50.setBounds(100, 238, 123, 54);
		add(btn50);

		btn1 = new JButton("1");
		btn1.setName("btn1");
		btn1.setBackground(Color.GREEN);
		btn1.setFont(btn1.getFont().deriveFont(0f));
		btn1.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1euro.png")));
		btn1.setBounds(420, 302, 123, 54);
		add(btn1);

		btn050 = new JButton("0.50");
		btn050.setName("btn050");
		btn050.setBackground(Color.GREEN);
		btn050.setFont(btn050.getFont().deriveFont(0f));
		btn050.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/50centimos.png")));
		btn050.setBounds(100, 364, 123, 54);
		add(btn050);

		btn020 = new JButton("0.20");
		btn020.setName("btn020");
		btn020.setBackground(Color.GREEN);
		btn020.setFont(btn020.getFont().deriveFont(0f));
		btn020.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/20centimos.png")));
		btn020.setBounds(260, 364, 123, 54);
		add(btn020);

		btn010 = new JButton("0.10");
		btn010.setName("btn010");
		btn010.setBackground(Color.GREEN);
		btn010.setFont(btn010.getFont().deriveFont(0f));
		btn010.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/10centimos.png")));
		btn010.setBounds(420, 364, 123, 54);
		add(btn010);

		btn005 = new JButton("0.05");
		btn005.setName("btn005");
		btn005.setBackground(Color.GREEN);
		btn005.setFont(btn005.getFont().deriveFont(0f));
		btn005.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/5centimos.png")));
		btn005.setBounds(100, 429, 123, 54);
		add(btn005);

		btn002 = new JButton("0.02");
		btn002.setName("btn002");
		btn002.setBackground(Color.GREEN);
		btn002.setFont(btn002.getFont().deriveFont(0f));
		btn002.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/2centimos.png")));
		btn002.setBounds(260, 429, 123, 54);
		add(btn002);

		btn001 = new JButton("0.01");
		btn001.setName("btn001");
		btn001.setBackground(Color.GREEN);
		btn001.setFont(btn001.getFont().deriveFont(0f));
		btn001.setIcon(new ImageIcon(PanelPago.class.getResource("/imagenes/1centimo.png")));
		btn001.setBounds(420, 429, 123, 54);
		add(btn001);
		
		
		
		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Haz clic en los billetes o monedas para introducir el dinero");
		lblNewJgoodiesLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewJgoodiesLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesLabel_4.setBounds(20, 94, 1070, 25);
		add(lblNewJgoodiesLabel_4);
	

	}
}
