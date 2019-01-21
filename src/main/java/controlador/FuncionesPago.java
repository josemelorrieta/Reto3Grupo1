package controlador;

public class FuncionesPago {

	static DatosPrecio datos = new DatosPrecio();
	
	public float CalcularPrecio(float distancia) {
		float precio = 0;
		
		return precio = (distancia * datos.precioGasolina * datos.beneficio * datos.IVA);
	}
	
	public int[] Cambios(float dinero) {
		int euros = (int) dinero;
		int decimales = Math.round((dinero - euros) * 100);
		int[] billetesMonedas = {500, 200, 100, 50, 20, 10, 5, 2, 1};
		int[] cambios = new int[15];
		
		for (int i=0, f=0, fake=1; i<billetesMonedas.length+fake; i++, f++) {
			//Mira si tiene que pasar a calcular los decimales
			if (f==9) {
				i=3;
				fake=0;
			}
			//Calcula los euros
			if (euros >= billetesMonedas[i] && f < 9) {
				cambios[f] = (int) (euros / billetesMonedas[i]);
				euros = euros % billetesMonedas[i];
			}
			//Calcula los centimos si ha acabado con los euros
			else if (decimales >= billetesMonedas[i] && f >= 9) {
				cambios[f] = (int) ((billetesMonedas[i]/100f) + (decimales / billetesMonedas[i]));
				decimales = decimales % billetesMonedas[i];
			}
		}
		
		return cambios;
	}
}
