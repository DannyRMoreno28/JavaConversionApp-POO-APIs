package myApp;

//import convertidor_de_unidades.Conversor;
//import convertidor_de_unidades.ConversorTemperatura.UnidadTemperatura;

//Crear la clase "ConversorTemperatura" la cual sera una extencion de la super clase "Coversor"
public class ConversorTemperatura extends Conversor {
	// Definir la diferencia de temperatura entre °C y °K
	private static final double CELSIUS_KELVIN = 273.15;

	// Definir la enumeración para las unidades de temperatura: Celsius, Kelvin y Fahrenheit en la variable "UnidadTemperatura"	
	// Indicar internamente al programa cuál es la unidad de temperatura de origen y cuál es la unidad de temperatura de destino
	// seleccionada por el usuario para realizar la conversión.
	public enum UnidadTemperatura { //tipo de dato enum que permite definir un conjunto fijo de valores constantes.
		CELSIUS, KELVIN, FAHRENHEIT 
	}

	// Definir variables de instancia (unidadOrigen y unidadDestino) que almacenara las unidades de tempratura de origen y destino
	private UnidadTemperatura unidadOrigen;
	private UnidadTemperatura unidadDestino;

	// Constructor de la clase "ConversorTemperatura". Toma como parámetros dos objetos de tipo UnidadTemperatura, 
	// que representan la unidad de origen y la unidad de destino de la conversión. 
	public ConversorTemperatura(UnidadTemperatura unidadOrigen, UnidadTemperatura unidadDestino) {
		this.unidadOrigen = unidadOrigen;
		this.unidadDestino = unidadDestino;
	}
	
	// Metodo "convertir" que tiene por función transforman una terperatura dada a otra 
	public double convertir(double cantidad) { //inicializamos la variable cantidad (valo ingresado por usuario) y resultado (conversión)
		double resultado = 0; 
		
		// Estructura de control switch con dos niveles de anidamiento ("nested switch statement" o "switch dentro de otro switch")
		switch (unidadOrigen) { //unidad inicial de la temperatura ingresada por el usuario
		case CELSIUS: // CASO 1
			
			switch (unidadDestino) { // unidad de temperatura a ser convertida por el programa
			case CELSIUS:
				resultado = cantidad;
				break;
			case KELVIN:
				resultado = cantidad + CELSIUS_KELVIN;
				break;
			case FAHRENHEIT:
				resultado = cantidad * 9 / 5 + 32;
				break;
			}
			break;
		
		case KELVIN: // CASO 2
			
			switch (unidadDestino) {
			case CELSIUS:
				resultado = cantidad - CELSIUS_KELVIN;
				break;
			case KELVIN:
				resultado = cantidad;
				break;
			case FAHRENHEIT:
				resultado = (cantidad - CELSIUS_KELVIN) * 9 / 5 + 32;
				break;
			}
			break;
		
		case FAHRENHEIT: // CASO 3
			
			switch (unidadDestino) {
			case CELSIUS:
				resultado = (cantidad - 32) * 5 / 9;
				break;
			case KELVIN:
				resultado = (cantidad - 32) * 5 / 9 + CELSIUS_KELVIN;
				break;
			case FAHRENHEIT:
				resultado = cantidad;
				break;
			}
			break;
		}
		
		// retornamos el valor de la converción
		return resultado;
	}
}
