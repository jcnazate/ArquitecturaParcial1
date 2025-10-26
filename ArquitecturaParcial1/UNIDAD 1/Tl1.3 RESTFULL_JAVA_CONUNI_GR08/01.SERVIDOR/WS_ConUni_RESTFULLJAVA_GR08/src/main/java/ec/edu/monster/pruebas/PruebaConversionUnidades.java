package ec.edu.monster.pruebas;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

/**
 * Clase de pruebas para el servicio REST de conversión de unidades
 * 
 * @author JOHAN
 */
public class PruebaConversionUnidades {
    
    public static void main(String[] args) {
        // Crear un cliente para consumir los servicios REST
        Client client = ClientBuilder.newClient();
        
        // URL base de tu API REST (ajusta según tu configuración)
        String baseUrl = "http://localhost:8080/WS_ConUni_RESTFULLJAVA_GR08/api/conversiones";
        
        System.out.println("=== PRUEBAS DE CONVERSIÓN DE UNIDADES ===\n");
        
        // Pruebas de conversión de longitud
        System.out.println("--- CONVERSIONES DE LONGITUD ---");
        probarPulgadasACentimetros(client, baseUrl, 10);
        probarCentimetrosAPulgadas(client, baseUrl, 25.4);
        
        System.out.println("\n--- CONVERSIONES DE MASA ---");
        // Pruebas de conversión de masa
        probarKilogramosAGramos(client, baseUrl, 1.5);
        probarGramosAKilogramos(client, baseUrl, 1500);
        
        System.out.println("\n--- CONVERSIONES DE TEMPERATURA ---");
        // Pruebas de conversión de temperatura
        probarCelsiusAKelvin(client, baseUrl, 25);
        probarKelvinACelsius(client, baseUrl, 298.15);
        
        System.out.println("\n=== FIN DE LAS PRUEBAS ===");
        
        // Cerrar el cliente
        client.close();
    }
    
    /**
     * Prueba la conversión de pulgadas a centímetros
     */
    private static void probarPulgadasACentimetros(Client client, String baseUrl, double pulgadas) {
        WebTarget target = client.target(baseUrl + "/pulgadasACentimetros/" + pulgadas);
        Response response = target.request().get();
        System.out.println("Pulgadas a centímetros (" + pulgadas + " in): " + response.readEntity(String.class) + " cm");
        response.close();
    }
    
    /**
     * Prueba la conversión de centímetros a pulgadas
     */
    private static void probarCentimetrosAPulgadas(Client client, String baseUrl, double centimetros) {
        WebTarget target = client.target(baseUrl + "/centimetrosAPulgadas/" + centimetros);
        Response response = target.request().get();
        System.out.println("Centímetros a pulgadas (" + centimetros + " cm): " + response.readEntity(String.class) + " in");
        response.close();
    }
    
    /**
     * Prueba la conversión de kilogramos a gramos
     */
    private static void probarKilogramosAGramos(Client client, String baseUrl, double kilogramos) {
        WebTarget target = client.target(baseUrl + "/kilogramosAGramos/" + kilogramos);
        Response response = target.request().get();
        System.out.println("Kilogramos a gramos (" + kilogramos + " kg): " + response.readEntity(String.class) + " g");
        response.close();
    }
    
    /**
     * Prueba la conversión de gramos a kilogramos
     */
    private static void probarGramosAKilogramos(Client client, String baseUrl, double gramos) {
        WebTarget target = client.target(baseUrl + "/gramosAKilogramos/" + gramos);
        Response response = target.request().get();
        System.out.println("Gramos a kilogramos (" + gramos + " g): " + response.readEntity(String.class) + " kg");
        response.close();
    }
    
    /**
     * Prueba la conversión de Celsius a Kelvin
     */
    private static void probarCelsiusAKelvin(Client client, String baseUrl, double celsius) {
        WebTarget target = client.target(baseUrl + "/celsiusAKelvin/" + celsius);
        Response response = target.request().get();
        System.out.println("Celsius a Kelvin (" + celsius + " °C): " + response.readEntity(String.class) + " K");
        response.close();
    }
    
    /**
     * Prueba la conversión de Kelvin a Celsius
     */
    private static void probarKelvinACelsius(Client client, String baseUrl, double kelvin) {
        WebTarget target = client.target(baseUrl + "/kelvinACelsius/" + kelvin);
        Response response = target.request().get();
        System.out.println("Kelvin a Celsius (" + kelvin + " K): " + response.readEntity(String.class) + " °C");
        response.close();
    }
}
