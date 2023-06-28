package myApp;

//Importar clases necesarias
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

//Clase principal ConversorMoneda
public class ConversorMoneda {

    // Constructor vac�o de la clase ConversorMoneda
    public ConversorMoneda() {
    }

    // M�todo para convertir entre monedas utilizando una API de tasas de cambio
    public double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        try {
            // Obtener la respuesta de la API para la moneda base
            RespuestaTipoCambio response = obtenerRespuesta(baseCurrency);

            // Verificar si la moneda base de la respuesta coincide con la moneda base solicitada
            if (response.getBase_code().equals(baseCurrency)) {
                
            	// Obtener la tasa de cambio para la moneda objetivo
                Double targetRate = response.getConversion_rates().get(targetCurrency);

                // Verificar si se encontr� la tasa de cambio para la moneda objetivo
                if (targetRate != null) {

                	// Realizar la conversi�n y devolver el resultado
                    return amount * targetRate;
                } else {
                    throw new RuntimeException("Moneda objetivo no encontrada en la respuesta.");
                }
            } else {
                throw new RuntimeException("La moneda base de la respuesta no coincide con la moneda base solicitada.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar la conversi�n: " + e.getMessage());
        }
    }
    
    // M�todo privado para obtener la respuesta de la API de tasas de cambio en funci�n de la moneda base
    // pagina fuente de la API --> https://app.exchangerate-api.com
    private RespuestaTipoCambio obtenerRespuesta(String baseCurrency) throws Exception {
    	// Clave API para acceder a la API de tasas de cambio
        String apiKey = "61fc76490048584982cbacc3"; 
        // Construir la URL de la API utilizando la clave API y la moneda base
        URL url = new URL("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency);
        
    	// Establecer y abrir una conexi�n HTTP con la URL
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
    
        // Obtener el c�digo de respuesta de la conexi�n
        int responseCode = conn.getResponseCode();

        // Verificar si el c�digo de respuesta es 200 (�xito)
        if (responseCode != 200) {
            throw new RuntimeException("Ocurrio un error " + responseCode);
        } else {
            // Crear un objeto StringBuilder para almacenar la informaci�n de la respuesta
            StringBuilder informationString = new StringBuilder();
            
        	// Leer la informaci�n de la respuesta utilizando un InputStream y un Scanner
            try (InputStream inputStream = conn.getInputStream(); Scanner scanner = new Scanner(inputStream)) {
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
            }
            // Crear una instancia de Gson para deserializar la informaci�n de la respuesta
            Gson gson = new Gson();
            
            // Deserializar la informaci�n de la respuesta en un objeto RespuestaTipoCambio         
            RespuestaTipoCambio response = gson.fromJson(informationString.toString(), RespuestaTipoCambio.class);
            
            // Devolver el objeto RespuestaTipoCambio
            return response;
        }
    }
}
