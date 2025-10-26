package ec.edu.monster.controller;

import android.content.Context;

import ec.edu.monster.model.ConUniService;
import ec.edu.monster.utils.Constants;
import ec.edu.monster.utils.NetworkUtils;

/**
 * Controlador principal de la aplicación que maneja la lógica de negocio
 * y actúa como intermediario entre las vistas y el modelo
 */
public class AppController {
    
    private ConUniService conUniService;
    private Context context;
    
    public AppController() {
        this.conUniService = new ConUniService();
    }
    
    public AppController(Context context) {
        this.conUniService = new ConUniService();
        this.context = context;
    }
    
    /**
     * Autentica un usuario
     * @param username Nombre de usuario
     * @param password Contraseña
     * @return true si la autenticación es exitosa
     * @throws Exception Si hay error en la comunicación
     */
    public boolean login(String username, String password) throws Exception {
        // Validar entrada
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        
        // Verificar conectividad si tenemos contexto
        if (context != null && !NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception(Constants.ERROR_NETWORK);
        }
        
        try {
            return conUniService.authenticate(username.trim(), password.trim());
        } catch (Exception e) {
            // Manejar errores específicos
            if (e.getMessage() != null && e.getMessage().contains("Error del servidor")) {
                throw new Exception(Constants.ERROR_SERVER);
            }
            throw e;
        }
    }
    
    /**
     * Convierte pulgadas a centímetros
     * @param pulgadas Valor en pulgadas
     * @return Valor en centímetros
     * @throws Exception Si hay error en la comunicación
     */
    public double pulgadasACentimetros(double pulgadas) throws Exception {
        validateInput(pulgadas);
        
        if (context != null && !NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception(Constants.ERROR_NETWORK);
        }
        
        try {
            return conUniService.pulgadasACentimetros(pulgadas);
        } catch (Exception e) {
            handleConversionError(e);
            throw e;
        }
    }
    
    /**
     * Convierte centímetros a pulgadas
     * @param centimetros Valor en centímetros
     * @return Valor en pulgadas
     * @throws Exception Si hay error en la comunicación
     */
    public double centimetrosAPulgadas(double centimetros) throws Exception {
        validateInput(centimetros);
        
        if (context != null && !NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception(Constants.ERROR_NETWORK);
        }
        
        try {
            return conUniService.centimetrosAPulgadas(centimetros);
        } catch (Exception e) {
            handleConversionError(e);
            throw e;
        }
    }
    
    /**
     * Convierte Kelvin a Celsius
     * @param kelvin Valor en Kelvin
     * @return Valor en Celsius
     * @throws Exception Si hay error en la comunicación
     */
    public double kelvinACelsius(double kelvin) throws Exception {
        validateInput(kelvin);
        
        if (context != null && !NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception(Constants.ERROR_NETWORK);
        }
        
        try {
            return conUniService.kelvinACelsius(kelvin);
        } catch (Exception e) {
            handleConversionError(e);
            throw e;
        }
    }
    
    /**
     * Convierte Celsius a Kelvin
     * @param celsius Valor en Celsius
     * @return Valor en Kelvin
     * @throws Exception Si hay error en la comunicación
     */
    public double celsiusAKelvin(double celsius) throws Exception {
        validateInput(celsius);
        
        if (context != null && !NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception(Constants.ERROR_NETWORK);
        }
        
        try {
            return conUniService.celsiusAKelvin(celsius);
        } catch (Exception e) {
            handleConversionError(e);
            throw e;
        }
    }
    
    /**
     * Convierte kilogramos a gramos
     * @param kilogramos Valor en kilogramos
     * @return Valor en gramos
     * @throws Exception Si hay error en la comunicación
     */
    public double kilogramosAGramos(double kilogramos) throws Exception {
        validateInput(kilogramos);
        
        if (context != null && !NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception(Constants.ERROR_NETWORK);
        }
        
        try {
            return conUniService.kilogramosAGramos(kilogramos);
        } catch (Exception e) {
            handleConversionError(e);
            throw e;
        }
    }
    
    /**
     * Convierte gramos a kilogramos
     * @param gramos Valor en gramos
     * @return Valor en kilogramos
     * @throws Exception Si hay error en la comunicación
     */
    public double gramosAKilogramos(double gramos) throws Exception {
        validateInput(gramos);
        
        if (context != null && !NetworkUtils.isNetworkAvailable(context)) {
            throw new Exception(Constants.ERROR_NETWORK);
        }
        
        try {
            return conUniService.gramosAKilogramos(gramos);
        } catch (Exception e) {
            handleConversionError(e);
            throw e;
        }
    }
    
    /**
     * Valida que el valor de entrada sea válido
     * @param value Valor a validar
     * @throws IllegalArgumentException Si el valor no es válido
     */
    private void validateInput(double value) throws IllegalArgumentException {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_INPUT);
        }
        if (Double.isInfinite(value)) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_INPUT);
        }
        if (value < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
    }
    
    /**
     * Maneja errores específicos de conversión
     * @param e Excepción original
     * @throws Exception Excepción procesada
     */
    private void handleConversionError(Exception e) throws Exception {
        if (e.getMessage() != null) {
            if (e.getMessage().contains("Error del servidor")) {
                throw new Exception(Constants.ERROR_SERVER);
            } else if (e.getMessage().contains("Connection")) {
                throw new Exception(Constants.ERROR_NETWORK);
            }
        }
        throw e;
    }
    
    /**
     * Establece el contexto de la aplicación
     * @param context Contexto de Android
     */
    public void setContext(Context context) {
        this.context = context;
    }
}
