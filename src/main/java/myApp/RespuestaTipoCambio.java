package myApp;

import java.util.Map;

//Clase que representa la respuesta de la API de tasas de cambio
public class RespuestaTipoCambio {
	// Atributos para almacenar la información de la respuesta
    private String result; // Almacena el resultado de la consulta (generalmente "success")
    private String base_code; // Almacena el código de la moneda base
    private Map<String, Double> conversion_rates; // Almacena las tasas de conversión en un mapa (clave: código de moneda, valor: tasa de cambio)

	// Getters y setters para cada atributo
    
    // Método getter para obtener el resultado de la consulta
    public String getResult() {
		return result;
	}
    
    // Método setter para establecer el resultado de la consulta
	public void setResult(String result) {
		this.result = result;
	}
    
	// Método getter para obtener el código de la moneda base
	public String getBase_code() {
		return base_code;
	}

	// Método setter para establecer el código de la moneda base
	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}

    // Método getter para obtener las tasas de conversión
	public Map<String, Double> getConversion_rates() {
		return conversion_rates;
	}

    // Método setter para establecer las tasas de conversión
	public void setConversion_rates(Map<String, Double> conversion_rates) {
		this.conversion_rates = conversion_rates;
	}
}
