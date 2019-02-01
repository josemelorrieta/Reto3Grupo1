package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import modelo.Billete;
import modelo.Cliente;
import modelo.Modelo;
import vista.Ventana;

public class ControladorBilletes implements ActionListener {
	
	FuncionesControlador funciones = new FuncionesControlador();
	FuncionesVarias funcionesModelo = new FuncionesVarias();
	
	//private Controlador miControlador;
	private Ventana miVentana;
	private Modelo miModelo;
	
//	private Cliente cliente;
//	private Billete[] billetes; 
	
	//Constructor
		public ControladorBilletes (Ventana miVentana, Modelo miModelo) {  
			
			this.miVentana = miVentana;
			this.miModelo = miModelo;
			
			miVentana.billetes.btnComprarBillete.addActionListener(this);
			miVentana.billetes.btnCerrarSesion.addActionListener(this);	 		

		}
		
//		public Cliente getCliente() {
//			return cliente;
//		}
//
//		public void setCliente(Cliente cliente) {
//			this.cliente = cliente;
//		}
		
		public void resetear() {
			miVentana.billetes.modeloMostrarBilletes.removeAllElements();
			miVentana.billetes.MostrarBilletes.setModel(miVentana.billetes.modeloMostrarBilletes);
		}
		
		public void actualizarBilletes(Billete[] billetes) {
			
			miVentana.billetes.modeloMostrarBilletes.removeAllElements();
			if (billetes == null) {
				miVentana.billetes.modeloMostrarBilletes.addElement("No hay billetes");
			} else {
				for (int i=0;i<billetes.length;i++) {
					miVentana.billetes.modeloMostrarBilletes.addElement(String.format("%40s%40s%15s", billetes[i].getOrigen(), billetes[i].getDestino(), billetes[i].getFecha()));
				}
			}
			miVentana.billetes.MostrarBilletes.setModel(miVentana.billetes.modeloMostrarBilletes);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((JButton) e.getSource()).getName()) {
				case "btnComprarBilleteBilletes": funciones.cambiarDePanel(miVentana.billetes, miVentana.lineas);
					String[] nombreLineas = funcionesModelo.consultaColumnaString("select distinct Nombre from linea;", "Nombre");
					miVentana.lineas.SeleccionarLinea.setModel(new DefaultComboBoxModel(nombreLineas));
					resetear();
					break;
											 	  
				case "btnCerrarSesionBilletes": funciones.cambiarDePanel(miVentana.billetes, miVentana.login);
					resetear();
					break;

			}
			
		}

		
		

}