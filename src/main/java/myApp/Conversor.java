package myApp;

//Declarar la clase abstracta "Conversor"
public abstract class Conversor {
	public abstract double convertir(double cantidad);
}

//La clase Conversor tiene un método abstracto llamado convertir que debe ser implementado 
//en cada una de las subclases de Conversor. Este método es el que realiza la conversión de 
//unidades específica de cada tipo de conversor.

//Definir una clase abstracta sirve como base para implementar diferentes tipos de
//conversores de unidades. La clase contiene un método abstracto "convertir" que debe 
//ser implementado por las clases hijas para realizar la conversión específica de la unidad.