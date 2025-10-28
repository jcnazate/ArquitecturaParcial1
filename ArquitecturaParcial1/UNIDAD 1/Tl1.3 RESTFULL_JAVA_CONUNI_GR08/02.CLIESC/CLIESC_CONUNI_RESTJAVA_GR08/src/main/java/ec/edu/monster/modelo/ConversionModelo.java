/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Modelo para manejar la lógica de conversión y consumir servicios REST
 *
 * @author johan
 */
public class ConversionModelo {
    private static final String BASE_URL = "http://localhost:8080/WS_ConUni_RESTFULLJAVA_GR08/api";
    
    public ConversionModelo() {
    }
    
    public double centimetrosAPulgadas(double centimetros) {
        return hacerPeticionGET("/conversiones/centimetrosAPulgadas/" + centimetros);
    }

    public double pulgadasACentimetros(double pulgadas) {
        return hacerPeticionGET("/conversiones/pulgadasACentimetros/" + pulgadas);
    }
    
    public double kelvinACelsius(double kelvin) {
        return hacerPeticionGET("/conversiones/kelvinACelsius/" + kelvin);
    }
    
    public double celsiusAKelvin(double celsius) {
        return hacerPeticionGET("/conversiones/celsiusAKelvin/" + celsius);
    }
    
    public double gramosAKilogramos(double gramos) {
        return hacerPeticionGET("/conversiones/gramosAKilogramos/" + gramos);
    }
    
    public double kilogramosAGramos(double kilogramos) {
        return hacerPeticionGET("/conversiones/kilogramosAGramos/" + kilogramos);
    }
    
    /**
     * Método genérico para hacer peticiones GET al servidor REST
     */
    private double hacerPeticionGET(String endpoint) {
        try {
            String urlCompleta = BASE_URL + endpoint;
            URL url = new URL(urlCompleta);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "text/plain");
            
            int responseCode = conn.getResponseCode();
            
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Error HTTP: " + responseCode);
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output = br.readLine();
            conn.disconnect();
            
            if (output == null || output.trim().isEmpty()) {
                throw new RuntimeException("Respuesta vacía del servidor");
            }
            
            return Double.parseDouble(output);
            
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error al parsear respuesta numérica: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error al realizar conversión: " + e.getMessage());
        }
    }
}

