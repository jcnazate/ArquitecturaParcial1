package ec.edu.monster.utils;

/**
 * Constantes utilizadas en la aplicación
 */
public class Constants {
    // URL base del servidor REST - Usar HTTP para desarrollo local
    // IMPORTANTE: En .NET Core:
    //   - Puerto 5000 = HTTP
    //   - Puerto 5001 = HTTPS
    // Asegúrate de que tu servidor esté ejecutándose con:
    //   dotnet run --urls="http://localhost:5000"
    public static final String BASE_URL = "http://10.0.2.2:5000/";
    
    // Para dispositivos físicos, usar la IP de tu máquina:
    // public static final String BASE_URL = "http://192.168.1.XXX:5000/";
    
    // Endpoints de conversión
    public static final String ENDPOINT_PULGADAS_A_CENTIMETROS = "pulgadas-a-centimetros";
    public static final String ENDPOINT_CENTIMETROS_A_PULGADAS = "centimetros-a-pulgadas";
    public static final String ENDPOINT_KELVIN_A_CELSIUS = "kelvin-a-celsius";
    public static final String ENDPOINT_CELSIUS_A_KELVIN = "celsius-a-kelvin";
    public static final String ENDPOINT_KILOGRAMOS_A_GRAMOS = "kilogramos-a-gramos";
    public static final String ENDPOINT_GRAMOS_A_KILOGRAMOS = "gramos-a-kilogramos";
    
    // Endpoint de autenticación
    public static final String ENDPOINT_AUTHENTICATE = "authenticate";
    
    // Timeouts para conexiones HTTP
    public static final int CONNECT_TIMEOUT = 10000; // 10 segundos
    public static final int READ_TIMEOUT = 15000; // 15 segundos
    
    // Mensajes de error comunes
    public static final String ERROR_NETWORK = "Error de conexión. Verifique su conexión a internet.";
    public static final String ERROR_SERVER = "Error del servidor. Intente nuevamente.";
    public static final String ERROR_INVALID_INPUT = "Por favor, ingrese un valor válido.";
    public static final String ERROR_LOGIN_FAILED = "Usuario o contraseña incorrectos.";
}
