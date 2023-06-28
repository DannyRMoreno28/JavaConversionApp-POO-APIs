package myApp;

//Declarar la clase abstracta "Conversor"
public abstract class Conversor {
	public abstract double convertir(double cantidad);
}

//La clase Conversor tiene un m�todo abstracto llamado convertir que debe ser implementado 
//en cada una de las subclases de Conversor. Este m�todo es el que realiza la conversi�n de 
//unidades espec�fica de cada tipo de conversor.

//Definir una clase abstracta sirve como base para implementar diferentes tipos de
//conversores de unidades. La clase contiene un m�todo abstracto "convertir" que debe 
//ser implementado por las clases hijas para realizar la conversi�n espec�fica de la unidad.