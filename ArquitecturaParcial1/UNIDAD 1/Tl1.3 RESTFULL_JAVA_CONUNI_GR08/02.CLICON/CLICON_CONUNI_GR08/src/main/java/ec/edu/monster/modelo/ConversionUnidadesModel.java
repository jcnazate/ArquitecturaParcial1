package ec.edu.monster.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Modelo para manejar la lógica de negocio y consumir servicios REST
 * 
 * @author JOHAN
 */
public class ConversionUnidadesModel {
    
    private static final String BASE_URL = "http://localhost:8080/WS_ConUni_RESTFULLJAVA_GR08/api";
    private String usuarioActual;
    private boolean autenticado;
    
    public ConversionUnidadesModel() {
        this.autenticado = false;
    }
    
    /**
     * Realiza el login contra el servicio REST
     */
    public boolean login(String username, String password) {
        try {
            String url = BASE_URL + "/generic";
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            
            // Preparar datos del formulario
            String datos = "username=" + URLEncoder.encode(username, "UTF-8") +
                          "&password=" + URLEncoder.encode(password, "UTF-8");
            
            // Enviar datos
            OutputStream os = conn.getOutputStream();
            os.write(datos.getBytes());
            os.flush();
            os.close();
            
            int responseCode = conn.getResponseCode();
            
            if (responseCode == 200) {
                this.usuarioActual = username;
                this.autenticado = true;
                return true;
            } else {
                this.autenticado = false;
                return false;
            }
            
        } catch (Exception e) {
            this.autenticado = false;
            return false;
        }
    }
    
    /**
     * Convierte pulgadas a centímetros
     */
    public String pulgadasACentimetros(double pulgadas) {
        return hacerPeticionGET("/conversiones/pulgadasACentimetros/" + pulgadas);
    }
    
    /**
     * Convierte centímetros a pulgadas
     */
    public String centimetrosAPulgadas(double centimetros) {
        return hacerPeticionGET("/conversiones/centimetrosAPulgadas/" + centimetros);
    }
    
    /**
     * Convierte kilogramos a gramos
     */
    public String kilogramosAGramos(double kilogramos) {
        return hacerPeticionGET("/conversiones/kilogramosAGramos/" + kilogramos);
    }
    
    /**
     * Convierte gramos a kilogramos
     */
    public String gramosAKilogramos(double gramos) {
        return hacerPeticionGET("/conversiones/gramosAKilogramos/" + gramos);
    }
    
    /**
     * Convierte Celsius a Kelvin
     */
    public String celsiusAKelvin(double celsius) {
        return hacerPeticionGET("/conversiones/celsiusAKelvin/" + celsius);
    }
    
    /**
     * Convierte Kelvin a Celsius
     */
    public String kelvinACelsius(double kelvin) {
        return hacerPeticionGET("/conversiones/kelvinACelsius/" + kelvin);
    }
    
    /**
     * Método genérico para hacer peticiones GET
     */
    private String hacerPeticionGET(String endpoint) {
        try {
            String urlCompleta = BASE_URL + endpoint;
            URL url = new URL(urlCompleta);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");
            
            if (conn.getResponseCode() != 200) {
                return "Error: HTTP " + conn.getResponseCode();
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output = br.readLine();
            conn.disconnect();
            
            return output;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
    
    // Getters
    public String getUsuarioActual() {
        return usuarioActual;
    }
    
    public boolean isAutenticado() {
        return autenticado;
    }
}