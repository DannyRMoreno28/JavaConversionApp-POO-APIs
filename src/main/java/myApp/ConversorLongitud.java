package myApp;

//import convertidor_de_unidades.Conversor;
//import convertidor_de_unidades.ConversorLongitud.UnidadLongitud;

public class ConversorLongitud extends Conversor {
	
	// Definir el conjunto fijo de unidades de longitud que se puedran convertir con el programa (unicamente se trabajar con estas unidades)
	public enum UnidadLongitud {
		METRO, KILOMETRO, CENTIMETRO, MILLA, PIE, PULGADA
	}

	// Definir variables de instancia (unidadOrigen y unidadDestino) que almacenara las unidades de longitu de origen y destino (ambas escogidas por el usuario)
	private UnidadLongitud unidadOrigen;
	private UnidadLongitud unidadDestino;

	// Constructor de la clase "ConversorLongitud". Toma como parámetros dos objetos de tipo UnidadLongitud, 
	// que representan la unidad de origen y la unidad de destino de la conversión.
	public ConversorLongitud(UnidadLongitud unidadOrigen, UnidadLongitud unidadDestino) {
		this.unidadOrigen = unidadOrigen;
		this.unidadDestino = unidadDestino;
	}

	// Metodo "convertir" que tiene por función transforman una longitud dada a otra 
	public double convertir(double cantidad) {
		double resultado = 0;

		switch (unidadOrigen) {
		case METRO: // CASO 1
			
			switch (unidadDestino) {
			case METRO:
				resultado = cantidad;
				break;
			case KILOMETRO:
				resultado = cantidad / 1000;
				break;
			case CENTIMETRO:
				resultado = cantidad * 100;
				break;
			case MILLA:
				resultado = cantidad / 1609.34;
				break;
			case PIE:
				resultado = cantidad * 3.28084;
				break;
			case PULGADA:
				resultado = cantidad * 39.3701;
				break;
			}
			break;
		
		case KILOMETRO: // CASO 2
		
			switch (unidadDestino) {
			case METRO:
				resultado = cantidad * 1000;
				break;
			case KILOMETRO:
				resultado = cantidad;
				break;
			case CENTIMETRO:
				resultado = cantidad * 100000;
				break;
			case MILLA:
				resultado = cantidad / 1.60934;
				break;
			case PIE:
				resultado = cantidad * 3280.84;
				break;
			case PULGADA:
				resultado = cantidad * 39370.1;
				break;
			}
			break;
		
		case CENTIMETRO: // CASO 3
			
			switch (unidadDestino) {
			case METRO:
				resultado = cantidad / 100;
				break;
			case KILOMETRO:
				resultado = cantidad / 100000;
				break;
			case CENTIMETRO:
				resultado = cantidad;
				break;
			case MILLA:
				resultado = cantidad / 160934;
				break;
			case PIE:
				resultado = cantidad / 30.48;
				break;
			case PULGADA:
				resultado = cantidad / 2.54;
				break;
			}
			break;
		
		case MILLA: // CASO 4
			
			switch (unidadDestino) {
			case METRO:
				resultado = cantidad * 1609.34;
				break;
			case KILOMETRO:
				resultado = cantidad * 1.60934;
				break;
			case CENTIMETRO:
				resultado = cantidad * 160934;
				break;
			case MILLA:
				resultado = cantidad;
				break;
			case PIE:
				resultado = cantidad * 5280;
				break;
			case PULGADA:
				resultado = cantidad * 63360;
				break;
			}
			break;
		
		case PIE: // CASO 5
			
			switch (unidadDestino) {
			case METRO:
				resultado = cantidad / 3.28084;
				break;
			case KILOMETRO:
				resultado = cantidad / 3280.84;
				break;
			case CENTIMETRO:
				resultado = cantidad * 30.48;
				break;
			case MILLA:
				resultado = cantidad / 5280;
			case PIE:
				resultado = cantidad;
				break;
			case PULGADA:
				resultado = cantidad * 12;
				break;
			}
			break;
		
		case PULGADA: // CASO 6
			
			switch (unidadDestino) {
			case METRO:
				resultado = cantidad / 39.3701;
				break;
			case KILOMETRO:
				resultado = cantidad / 39370.1;
				break;
			case CENTIMETRO:
				resultado = cantidad * 2.54;
				break;
			case MILLA:
				resultado = cantidad / 63360;
				break;
			case PIE:
				resultado = cantidad / 12;
				break;
			case PULGADA:
				resultado = cantidad;
				break;
			}
			break;
		}

		return resultado;
	}
}
