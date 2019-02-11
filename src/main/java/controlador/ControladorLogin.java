package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import modelo.FuncionesLogin;
import modelo.Modelo;
import vista.Ventana;

/**
 * Clase que controla el panel de login de un usuario
 *
 */
public class ControladorLogin implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	FuncionesLogin funcionesLogin = new FuncionesLogin();
		
	private Controlador miControlador; 
	private Ventana miVentana;
	private Modelo miModelo;
		
	/** 
	 * Constructor de la clase
	 * @param miControlador instancia del controlador para poder acceder a otros paneles
	 * @param miVentana instancia de la ventana principal
	 * @param miModelo instancia del modelo para poder acceder a las funciones
	 */
	public ControladorLogin(Controlador miControlador, Ventana miVentana, Modelo miModelo) {  
		
		this.miControlador = miControlador;
		this.miVentana = miVentana;
		this.miModelo = miModelo;
		
		//Definicion de los listeners para cada boton
		miVentana.login.btnAtras.addActionListener(this);
		miVentana.login.btnRegistrarse.addActionListener(this);
		miVentana.login.btnLogin.addActionListener(this);
	}
	
	/**
	 * Método para cerrar sesión automáticamente después de un tiempo
	 */
	public void pasarDeBilletesALogin() {
		Timer timer = new Timer();
		TimerTask esperar = new TimerTask() {
			@Override
			public void run() {
				miVentana.billetes.setVisible(false);
				miVentana.login.setVisible(true);
			}
		};
		timer.schedule(esperar, 10000000);
	}
	
	/**
	 * Metodo para las llamadas a los botones de la ventana login
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//accion dependiendo del boton del que viene el evento
		switch (((JButton) e.getSource()).getName()) {

			case "btnAtrasLogin":   funciones.cambiarDePanel(miVentana.login, miVentana.saludo);
				resetear();  
				break;
			case "btnRegistrarseLogin":	funciones.cambiarDePanel(miVentana.login, miVentana.registro);
				resetear();
				break;
			case "btnLogin":
				try {
					miModelo.cliente = null;
					//Comprobar si existe el DNI introducido y si la contraseña es correcta
					miModelo.cliente = funcionesLogin.comprobarDNI(miVentana.login.TextDni.getText(), miVentana.login.passwordField.getPassword(), miModelo.cliente, miVentana);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Si los datos son correctos el objeto cliente no es nulo: pasamos de panel y cargamos su billetes
				if(miModelo.cliente != null) {
					funciones.cambiarDePanel(miVentana.login, miVentana.billetes);
					resetear();
					//Cargamos array de nombres lineas para mostrar en el siguiente panel
					try {
						miModelo.nombreLineas = miModelo.misFuncionesLineas.cargarNombreLineas(miModelo.nombreLineas);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					//Mostramos array de nombres de lineas en pantalla de lineas
					miVentana.lineas.modeloLineas.removeAllElements();
					for(int i=0;i<miModelo.nombreLineas.length;i++) {
						miVentana.lineas.modeloLineas.addElement(miModelo.nombreLineas[i]);
					}
					miVentana.lineas.listaLineas.setModel(miVentana.lineas.modeloLineas);
					
					//Cargamos los billetes del cliente logeado
					try {
						miModelo.billetes = miModelo.misFuncionesBilletes.billetesCliente(miModelo.cliente, miModelo.billetes);
						miControlador.miControladorBilletes.actualizarBilletes(miModelo.billetes);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					pasarDeBilletesALogin();
				}
			
				break;				
		}
	}
		
	/** 
	 * Metodo para resetear los valores de la ventana login 	
	 */
	public void resetear() {
		miVentana.login.TextDni.setText(""); 
		miVentana.login.passwordField.setText("");
	}

}