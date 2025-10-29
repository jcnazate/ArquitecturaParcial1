package ec.edu.monster.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

/**
 * Utilidades para manejar conexiones SSL en desarrollo
 */
public class SSLUtils {
    
    /**
     * Configura el HttpURLConnection para aceptar certificados no confiables
     * Solo usar en desarrollo, NO en producción
     */
    public static void configureForDevelopment(HttpURLConnection connection) {
        if (connection instanceof HttpsURLConnection) {
            try {
                // Crear un TrustManager que acepta todos los certificados
                TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
                };
                
                // Instalar el TrustManager
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                ((HttpsURLConnection) connection).setSSLSocketFactory(sc.getSocketFactory());
                
                // Deshabilitar verificación de hostname
                ((HttpsURLConnection) connection).setHostnameVerifier((hostname, session) -> true);
                
            } catch (Exception e) {
                // Si hay error, continuar sin configuración SSL especial
            }
        }
    }
    
    /**
     * Verifica si una URL es HTTPS
     */
    public static boolean isHttps(String urlString) {
        return urlString.toLowerCase().startsWith("https://");
    }
}
