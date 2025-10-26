/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author crist
 */
public class RestClient {
    private static final String BASE_URL_CONVERSIONES = "http://localhost:8080/WS_ConUni_RESTFULLJAVA_GR08/api/conversiones";
    private static final String BASE_URL_LOGIN = "http://localhost:8080/WS_ConUni_RESTFULLJAVA_GR08/api/generic";
    
    /**
     * Realiza una petición GET al servicio REST de conversiones
     * @param endpoint endpoint del servicio
     * @return respuesta del servicio
     * @throws IOException si hay error en la conexión
     */
    public static String realizarPeticion(String endpoint) throws IOException {
        URL url = new URL(BASE_URL_CONVERSIONES + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        try {
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
                );
                
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                return response.toString();
            } else {
                throw new IOException("Error en la respuesta del servidor: " + responseCode);
            }
        } finally {
            connection.disconnect();
        }
    }
    
    /**
     * Convierte pulgadas a centímetros
     * @param pulgadas valor en pulgadas
     * @return resultado de la conversión
     */
    public static double pulgadasACentimetros(double pulgadas) throws IOException {
        String response = realizarPeticion("/pulgadasACentimetros/" + pulgadas);
        return Double.parseDouble(response);
    }
    
    /**
     * Convierte centímetros a pulgadas
     * @param centimetros valor en centímetros
     * @return resultado de la conversión
     */
    public static double centimetrosAPulgadas(double centimetros) throws IOException {
        String response = realizarPeticion("/centimetrosAPulgadas/" + centimetros);
        return Double.parseDouble(response);
    }
    
    /**
     * Convierte kilogramos a gramos
     * @param kilogramos valor en kilogramos
     * @return resultado de la conversión
     */
    public static double kilogramosAGramos(double kilogramos) throws IOException {
        String response = realizarPeticion("/kilogramosAGramos/" + kilogramos);
        return Double.parseDouble(response);
    }
    
    /**
     * Convierte gramos a kilogramos
     * @param gramos valor en gramos
     * @return resultado de la conversión
     */
    public static double gramosAKilogramos(double gramos) throws IOException {
        String response = realizarPeticion("/gramosAKilogramos/" + gramos);
        return Double.parseDouble(response);
    }
    
    /**
     * Convierte Celsius a Kelvin
     * @param celsius valor en Celsius
     * @return resultado de la conversión
     */
    public static double celsiusAKelvin(double celsius) throws IOException {
        String response = realizarPeticion("/celsiusAKelvin/" + celsius);
        return Double.parseDouble(response);
    }
    
    /**
     * Convierte Kelvin a Celsius
     * @param kelvin valor en Kelvin
     * @return resultado de la conversión
     */
    public static double kelvinACelsius(double kelvin) throws IOException {
        String response = realizarPeticion("/kelvinACelsius/" + kelvin);
        return Double.parseDouble(response);
    }
    
    /**
     * Realiza el login del usuario
     * @param username nombre de usuario
     * @param password contraseña
     * @return true si el login es exitoso, false en caso contrario
     * @throws IOException si hay error en la conexión
     */
    public static boolean login(String username, String password) throws IOException {
        URL url = new URL(BASE_URL_LOGIN);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        try {
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            // Crear los datos del formulario
            String formData = "username=" + URLEncoder.encode(username, StandardCharsets.UTF_8.toString()) +
                             "&password=" + URLEncoder.encode(password, StandardCharsets.UTF_8.toString());
            
            // Enviar los datos
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = formData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            
            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
                );
                
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                // Verificar si la respuesta indica login exitoso
                return response.toString().contains("exitoso");
            } else {
                return false;
            }
        } finally {
            connection.disconnect();
        }
    }
}
