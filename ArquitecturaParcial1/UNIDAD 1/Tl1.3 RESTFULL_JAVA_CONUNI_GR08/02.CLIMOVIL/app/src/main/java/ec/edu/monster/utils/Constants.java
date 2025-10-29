package ec.edu.monster.utils;

/**
 * Constantes utilizadas en la aplicación
 */
public class Constants {
    // URL base del servidor REST Jakarta EE (ajusta el puerto y el contexto según tu despliegue)
    // Ejemplo típico con Tomcat/Payara desde el emulador Android:
    //   http://10.0.2.2:8080/WS_ConUni_RESTFULLJAVA_GR08-1.0-SNAPSHOT/api/
    public static final String BASE_URL = "http://192.168.1.3:8080/WS_ConUni_RESTFULLJAVA_GR08/api/";

    // Prefijos/segmentos
    public static final String SEGMENT_CONVERSIONES = "conversiones";
    public static final String SEGMENT_LOGIN = "login";
    
    // Timeouts para conexiones HTTP
    public static final int CONNECT_TIMEOUT = 10000; // 10 segundos
    public static final int READ_TIMEOUT = 15000; // 15 segundos
    
    // Mensajes de error comunes
    public static final String ERROR_NETWORK = "Error de conexión. Verifique su conexión a internet.";
    public static final String ERROR_SERVER = "Error del servidor. Intente nuevamente.";
    public static final String ERROR_INVALID_INPUT = "Por favor, ingrese un valor válido.";
    public static final String ERROR_LOGIN_FAILED = "Usuario o contraseña incorrectos.";
}
