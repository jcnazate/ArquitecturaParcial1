package ec.edu.monster.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ec.edu.monster.utils.Constants;

/**
 * Servicio para consumir la API REST de conversión de unidades
 */
public class ConUniService {
    
    private static final String TAG = "ConUniService";
    
    public ConUniService() {
        // Constructor sin dependencias externas
    }
    
    /**
     * Convierte pulgadas a centímetros
     * @param pulgadas Valor en pulgadas
     * @return Valor en centímetros
     * @throws Exception Si hay error en la comunicación
     */
    public double pulgadasACentimetros(double pulgadas) throws Exception {
        String url = Constants.BASE_URL + Constants.ENDPOINT_PULGADAS_A_CENTIMETROS + "?pulgadas=" + pulgadas;
        return makeGetRequestAndParseDouble(url, "centimetros");
    }
    
    /**
     * Convierte centímetros a pulgadas
     * @param centimetros Valor en centímetros
     * @return Valor en pulgadas
     * @throws Exception Si hay error en la comunicación
     */
    public double centimetrosAPulgadas(double centimetros) throws Exception {
        String url = Constants.BASE_URL + Constants.ENDPOINT_CENTIMETROS_A_PULGADAS + "?centimetros=" + centimetros;
        return makeGetRequestAndParseDouble(url, "pulgadas");
    }
    
    /**
     * Convierte Kelvin a Celsius
     * @param kelvin Valor en Kelvin
     * @return Valor en Celsius
     * @throws Exception Si hay error en la comunicación
     */
    public double kelvinACelsius(double kelvin) throws Exception {
        String url = Constants.BASE_URL + Constants.ENDPOINT_KELVIN_A_CELSIUS + "?kelvin=" + kelvin;
        return makeGetRequestAndParseDouble(url, "celsius");
    }
    
    /**
     * Convierte Celsius a Kelvin
     * @param celsius Valor en Celsius
     * @return Valor en Kelvin
     * @throws Exception Si hay error en la comunicación
     */
    public double celsiusAKelvin(double celsius) throws Exception {
        String url = Constants.BASE_URL + Constants.ENDPOINT_CELSIUS_A_KELVIN + "?celsius=" + celsius;
        return makeGetRequestAndParseDouble(url, "kelvin");
    }
    
    /**
     * Convierte kilogramos a gramos
     * @param kilogramos Valor en kilogramos
     * @return Valor en gramos
     * @throws Exception Si hay error en la comunicación
     */
    public double kilogramosAGramos(double kilogramos) throws Exception {
        String url = Constants.BASE_URL + Constants.ENDPOINT_KILOGRAMOS_A_GRAMOS + "?kilogramos=" + kilogramos;
        return makeGetRequestAndParseDouble(url, "gramos");
    }
    
    /**
     * Convierte gramos a kilogramos
     * @param gramos Valor en gramos
     * @return Valor en kilogramos
     * @throws Exception Si hay error en la comunicación
     */
    public double gramosAKilogramos(double gramos) throws Exception {
        String url = Constants.BASE_URL + Constants.ENDPOINT_GRAMOS_A_KILOGRAMOS + "?gramos=" + gramos;
        return makeGetRequestAndParseDouble(url, "kilogramos");
    }
    
    /**
     * Autentica un usuario
     * @param username Nombre de usuario
     * @param password Contraseña
     * @return true si la autenticación es exitosa
     * @throws Exception Si hay error en la comunicación
     */
    public boolean authenticate(String username, String password) throws Exception {
        String url = Constants.BASE_URL + Constants.ENDPOINT_AUTHENTICATE + 
                     "?user=" + username + "&password=" + password;
        
        System.out.println("🔍 [DEBUG] Intentando autenticar en: " + url);
        
        HttpURLConnection connection = null;
        try {
            URL requestUrl = new URL(url);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "Android-App");
            connection.setRequestProperty("Connection", "close"); // Evitar reutilización de socket
            connection.setRequestProperty("Cache-Control", "no-cache");
            connection.setConnectTimeout(Constants.CONNECT_TIMEOUT);
            connection.setReadTimeout(Constants.READ_TIMEOUT);
            
            System.out.println("🔍 [DEBUG] Conectando al servidor...");
            
            int responseCode = connection.getResponseCode();
            System.out.println("🔍 [DEBUG] Código de respuesta: " + responseCode);
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("🔍 [DEBUG] Leyendo respuesta del servidor...");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                String responseStr = response.toString();
                System.out.println("🔍 [DEBUG] Respuesta completa: " + responseStr);
                
                if (responseStr.trim().isEmpty()) {
                    throw new Exception("El servidor respondió con contenido vacío");
                }
                
                // Parsear respuesta JSON - buscar "message": "Login exitoso"
                boolean success = responseStr.contains("\"message\"") && 
                                 responseStr.contains("Login exitoso");
                System.out.println("🔍 [DEBUG] Autenticación exitosa: " + success);
                return success;
            } else {
                String errorMessage = "Error del servidor: " + responseCode;
                try {
                    BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    StringBuilder errorResponse = new StringBuilder();
                    String errorLine;
                    while ((errorLine = errorReader.readLine()) != null) {
                        errorResponse.append(errorLine);
                    }
                    errorReader.close();
                    if (errorResponse.length() > 0) {
                        errorMessage += " - " + errorResponse.toString();
                        System.out.println("🔍 [DEBUG] Error del servidor: " + errorResponse.toString());
                    }
                } catch (Exception e) {
                    System.out.println("🔍 [DEBUG] No se pudo leer el error stream: " + e.getMessage());
                }
                throw new Exception(errorMessage);
            }
            
        } catch (java.net.ConnectException e) {
            System.out.println("🔍 [DEBUG] Error de conexión: " + e.getMessage());
            throw new Exception("No se puede conectar al servidor. Verifique que esté ejecutándose en " + url);
        } catch (java.net.SocketTimeoutException e) {
            System.out.println("🔍 [DEBUG] Timeout de conexión: " + e.getMessage());
            throw new Exception("Timeout de conexión. El servidor no respondió a tiempo");
        } catch (java.io.EOFException e) {
            System.out.println("🔍 [DEBUG] EOF Exception: " + e.getMessage());
            throw new Exception("El servidor cerró la conexión inesperadamente. Verifique que el endpoint existe");
        } catch (Exception e) {
            System.out.println("🔍 [DEBUG] Error general: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            if (e.getMessage() != null && !e.getMessage().startsWith("Error del servidor")) {
                throw new Exception("Error de conexión: " + e.getMessage());
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.disconnect();
                System.out.println("🔍 [DEBUG] Conexión cerrada");
            }
        }
    }
    
    /**
     * Realiza una petición GET a la API y parsea un valor double específico
     * @param urlString URL completa de la petición
     * @param key Clave del valor a extraer del JSON
     * @return Valor double extraído
     * @throws Exception Si hay error en la comunicación
     */
    private double makeGetRequestAndParseDouble(String urlString, String key) throws Exception {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "Android-App");
            connection.setConnectTimeout(Constants.CONNECT_TIMEOUT);
            connection.setReadTimeout(Constants.READ_TIMEOUT);
            
            int responseCode = connection.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                String responseStr = response.toString();
                if (responseStr.trim().isEmpty()) {
                    throw new Exception("El servidor respondió con contenido vacío");
                }
                
                // Parsear solo el valor específico que necesitamos
                return parseDoubleFromJson(responseStr, key);
            } else {
                String errorMessage = "Error del servidor: " + responseCode;
                try {
                    BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    StringBuilder errorResponse = new StringBuilder();
                    String errorLine;
                    while ((errorLine = errorReader.readLine()) != null) {
                        errorResponse.append(errorLine);
                    }
                    errorReader.close();
                    if (errorResponse.length() > 0) {
                        errorMessage += " - " + errorResponse.toString();
                    }
                } catch (Exception e) {
                    // Si no se puede leer el error stream, usar el mensaje básico
                }
                throw new Exception(errorMessage);
            }
            
        } catch (java.net.ConnectException e) {
            throw new Exception("No se puede conectar al servidor. Verifique que esté ejecutándose en " + urlString);
        } catch (java.net.SocketTimeoutException e) {
            throw new Exception("Timeout de conexión. El servidor no respondió a tiempo");
        } catch (java.io.EOFException e) {
            throw new Exception("El servidor cerró la conexión inesperadamente. Verifique que el endpoint existe");
        } catch (Exception e) {
            if (e.getMessage() != null && !e.getMessage().startsWith("Error del servidor")) {
                throw new Exception("Error de conexión: " + e.getMessage());
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
    /**
     * Extrae un valor double de un JSON usando regex
     * @param json String JSON
     * @param key Clave a buscar
     * @return Valor double o 0.0 si no se encuentra
     */
    private double parseDoubleFromJson(String json, String key) {
        try {
            Pattern pattern = Pattern.compile("\"" + key + "\"\\s*:\\s*([0-9.-]+)");
            Matcher matcher = pattern.matcher(json);
            if (matcher.find()) {
                return Double.parseDouble(matcher.group(1));
            }
        } catch (Exception e) {
            // Si hay error, retornar 0.0
        }
        return 0.0;
    }
    
    /**
     * Extrae un valor boolean de un JSON usando regex
     * @param json String JSON
     * @param key Clave a buscar
     * @return Valor boolean o false si no se encuentra
     */
    private boolean parseBooleanFromJson(String json, String key) {
        try {
            Pattern pattern = Pattern.compile("\"" + key + "\"\\s*:\\s*(true|false)");
            Matcher matcher = pattern.matcher(json);
            if (matcher.find()) {
                return Boolean.parseBoolean(matcher.group(1));
            }
        } catch (Exception e) {
            // Si hay error, retornar false
        }
        return false;
    }
}
