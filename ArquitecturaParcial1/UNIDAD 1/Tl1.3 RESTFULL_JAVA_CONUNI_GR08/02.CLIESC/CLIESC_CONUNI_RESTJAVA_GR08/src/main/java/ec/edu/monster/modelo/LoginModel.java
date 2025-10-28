/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Modelo para manejar la lógica de login y consumir servicios REST
 *
 * @author johan
 */
public class LoginModel {
    private static final String BASE_URL = "http://localhost:8080/WS_ConUni_RESTFULLJAVA_GR08/api";
    
    public LoginModel() {
    }

    /**
     * Método para autenticar al usuario contra el servicio REST
     */
    public boolean autenticar(String usuario, String contraseña) {
        try {
            String urlString = BASE_URL + "/login";
            URL obj = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            
            // Configurar la petición POST
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            
            // Preparar datos del formulario
            String datos = "username=" + URLEncoder.encode(usuario, "UTF-8") +
                          "&password=" + URLEncoder.encode(contraseña, "UTF-8");
            
            // Enviar datos
            OutputStream os = conn.getOutputStream();
            os.write(datos.getBytes());
            os.flush();
            os.close();
            
            // Verificar código de respuesta
            int responseCode = conn.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Login exitoso
                return true;
            } else {
                // Leer el mensaje de error
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String errorMessage = br.readLine();
                br.close();
                throw new RuntimeException("Error en login: " + errorMessage);
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Error al autenticar: " + e.getMessage());
        }
    }
}
