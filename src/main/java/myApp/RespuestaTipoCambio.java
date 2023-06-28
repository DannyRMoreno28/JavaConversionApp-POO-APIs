package myApp;

import java.util.Map;

//Clase que representa la respuesta de la API de tasas de cambio
public class RespuestaTipoCambio {
	// Atributos para almacenar la informaci�n de la respuesta
    private String result; // Almacena el resultado de la consulta (generalmente "success")
    private String base_code; // Almacena el c�digo de la moneda base
    private Map<String, Double> conversion_rates; // Almacena las tasas de conversi�n en un mapa (clave: c�digo de moneda, valor: tasa de cambio)

	// Getters y setters para cada atributo
    
    // M�todo getter para obtener el resultado de la consulta
    public String getResult() {
		return result;
	}
    
    // M�todo setter para establecer el resultado de la consulta
	public void setResult(String result) {
		this.result = result;
	}
    
	// M�todo getter para obtener el c�digo de la moneda base
	public String getBase_code() {
		return base_code;
	}

	// M�todo setter para establecer el c�digo de la moneda base
	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}

    // M�todo getter para obtener las tasas de conversi�n
	public Map<String, Double> getConversion_rates() {
		return conversion_rates;
	}

    // M�todo setter para establecer las tasas de conversi�n
	public void setConversion_rates(Map<String, Double> conversion_rates) {
		this.conversion_rates = conversion_rates;
	}
}
