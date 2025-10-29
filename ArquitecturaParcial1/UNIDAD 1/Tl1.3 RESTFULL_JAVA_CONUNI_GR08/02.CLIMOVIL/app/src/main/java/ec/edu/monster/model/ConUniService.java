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
        String url = Constants.BASE_URL + Constants.SEGMENT_CONVERSIONES + "/pulgadasACentimetros/" + pulgadas;
        return makeGetPlainDouble(url);
    }
    
    /**
     * Convierte centímetros a pulgadas
     * @param centimetros Valor en centímetros
     * @return Valor en pulgadas
     * @throws Exception Si hay error en la comunicación
     */
    public double centimetrosAPulgadas(double centimetros) throws Exception {
        String url = Constants.BASE_URL + Constants.SEGMENT_CONVERSIONES + "/centimetrosAPulgadas/" + centimetros;
        return makeGetPlainDouble(url);
    }
    
    /**
     * Convierte Kelvin a Celsius
     * @param kelvin Valor en Kelvin
     * @return Valor en Celsius
     * @throws Exception Si hay error en la comunicación
     */
    public double kelvinACelsius(double kelvin) throws Exception {
        String url = Constants.BASE_URL + Constants.SEGMENT_CONVERSIONES + "/kelvinACelsius/" + kelvin;
        return makeGetPlainDouble(url);
    }
    
    /**
     * Convierte Celsius a Kelvin
     * @param celsius Valor en Celsius
     * @return Valor en Kelvin
     * @throws Exception Si hay error en la comunicación
     */
    public double celsiusAKelvin(double celsius) throws Exception {
        String url = Constants.BASE_URL + Constants.SEGMENT_CONVERSIONES + "/celsiusAKelvin/" + celsius;
        return makeGetPlainDouble(url);
    }
    
    /**
     * Convierte kilogramos a gramos
     * @param kilogramos Valor en kilogramos
     * @return Valor en gramos
     * @throws Exception Si hay error en la comunicación
     */
    public double kilogramosAGramos(double kilogramos) throws Exception {
        String url = Constants.BASE_URL + Constants.SEGMENT_CONVERSIONES + "/kilogramosAGramos/" + kilogramos;
        return makeGetPlainDouble(url);
    }
    
    /**
     * Convierte gramos a kilogramos
     * @param gramos Valor en gramos
     * @return Valor en kilogramos
     * @throws Exception Si hay error en la comunicación
     */
    public double gramosAKilogramos(double gramos) throws Exception {
        String url = Constants.BASE_URL + Constants.SEGMENT_CONVERSIONES + "/gramosAKilogramos/" + gramos;
        return makeGetPlainDouble(url);
    }
    
    /**
     * Autentica un usuario
     * @param username Nombre de usuario
     * @param password Contraseña
     * @return true si la autenticación es exitosa
     * @throws Exception Si hay error en la comunicación
     */
    public boolean authenticate(String username, String password) throws Exception {
        String url = Constants.BASE_URL + Constants.SEGMENT_LOGIN;

        HttpURLConnection connection = null;
        try {
            URL requestUrl = new URL(url);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            connection.setRequestProperty("Accept", "text/plain");
            connection.setConnectTimeout(Constants.CONNECT_TIMEOUT);
            connection.setReadTimeout(Constants.READ_TIMEOUT);
            connection.setDoOutput(true);

            String form = "username=" + encode(username) + "&password=" + encode(password);
            try (OutputStream os = connection.getOutputStream()) {
                os.write(form.getBytes(StandardCharsets.UTF_8));
            }

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
                return responseStr != null && responseStr.toLowerCase().contains("exitoso");
            } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED || responseCode == HttpURLConnection.HTTP_FORBIDDEN) {
                return false;
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
                }
                throw new Exception(errorMessage);
            }

        } finally {
            if (connection != null) {
                connection.disconnect();
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
     * Realiza una petición GET y parsea un double cuando el servidor responde text/plain
     */
    private double makeGetPlainDouble(String urlString) throws Exception {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "text/plain");
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
                String responseStr = response.toString().trim();
                if (responseStr.isEmpty()) {
                    throw new Exception("El servidor respondió con contenido vacío");
                }
                return Double.parseDouble(responseStr);
            } else {
                throw new Exception("Error del servidor: " + responseCode);
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private String encode(String value) {
        try {
            return java.net.URLEncoder.encode(value, "UTF-8");
        } catch (Exception e) {
            return value;
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
