package ec.edu.monster.controlador;

import ec.edu.monster.modelo.ConversionUnidadesModel;
import ec.edu.monster.vista.ConversionUnidadesVista;
import ec.edu.monster.modelo.ConversionUnidadesModel;
import ec.edu.monster.vista.ConversionUnidadesVista;

/**
 * Controlador principal de la aplicación
 * 
 * @author JOHAN
 */
public class ConversionUnidadesControlador {
    
    private ConversionUnidadesModel modelo;
    private ConversionUnidadesVista vista;
    
    public ConversionUnidadesControlador() {
        this.modelo = new ConversionUnidadesModel();
        this.vista = new ConversionUnidadesVista();
    }
    
    /**
     * Inicia la aplicación
     */
    public void iniciar() {
        vista.mostrarBanner();
        
        // Proceso de login
        if (!realizarLogin()) {
            vista.mostrarDespedida();
            vista.cerrar();
            return;
        }
        
        // Menú principal
        ejecutarMenuPrincipal();
        
        vista.mostrarDespedida();
        vista.cerrar();
    }
    
    /**
     * Realiza el proceso de login
     */
    private boolean realizarLogin() {
        int intentos = 0;
        final int MAX_INTENTOS = 3;
        
        while (intentos < MAX_INTENTOS) {
            String username = vista.obtenerUsuario();
            String password = vista.obtenerPassword();
            
            if (username.isEmpty() || password.isEmpty()) {
                vista.mostrarError("Usuario y contraseña son obligatorios");
                intentos++;
                continue;
            }
            
            // Intentar login
            if (modelo.login(username, password)) {
                vista.mostrarLoginExitoso();
                vista.esperarEnter();
                return true;
            } else {
                vista.mostrarLoginFallido();
                intentos++;
                if (intentos < MAX_INTENTOS) {
                    System.out.println("Intentos restantes: " + (MAX_INTENTOS - intentos));
                }
            }
        }
        
        vista.mostrarError("Número máximo de intentos alcanzado");
        return false;
    }
    
    /**
     * Ejecuta el menú principal
     */
    private void ejecutarMenuPrincipal() {
        boolean continuar = true;
        
        while (continuar) {
            vista.limpiarPantalla();
            int opcion = vista.obtenerOpcionConversion();
            
            switch (opcion) {
                case 1:
                    convertirPulgadasACentimetros();
                    break;
                case 2:
                    convertirCentimetrosAPulgadas();
                    break;
                case 3:
                    convertirKilogramosAGramos();
                    break;
                case 4:
                    convertirGramosAKilogramos();
                    break;
                case 5:
                    convertirCelsiusAKelvin();
                    break;
                case 6:
                    convertirKelvinACelsius();
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    vista.mostrarError("Opción inválida");
                    break;
            }
            
            if (continuar && opcion >= 1 && opcion <= 6) {
                vista.esperarEnter();
            }
        }
    }
    
    /**
     * Convierte pulgadas a centímetros
     */
    private void convertirPulgadasACentimetros() {
        double valor = vista.obtenerPulgadas();
        String resultado = modelo.pulgadasACentimetros(valor);
        vista.mostrarResultadoPulgadasACentimetros(valor, resultado);
    }
    
    /**
     * Convierte centímetros a pulgadas
     */
    private void convertirCentimetrosAPulgadas() {
        double valor = vista.obtenerCentimetros();
        String resultado = modelo.centimetrosAPulgadas(valor);
        vista.mostrarResultadoCentimetrosAPulgadas(valor, resultado);
    }
    
    /**
     * Convierte kilogramos a gramos
     */
    private void convertirKilogramosAGramos() {
        double valor = vista.obtenerKilogramos();
        String resultado = modelo.kilogramosAGramos(valor);
        vista.mostrarResultadoKilogramosAGramos(valor, resultado);
    }
    
    /**
     * Convierte gramos a kilogramos
     */
    private void convertirGramosAKilogramos() {
        double valor = vista.obtenerGramos();
        String resultado = modelo.gramosAKilogramos(valor);
        vista.mostrarResultadoGramosAKilogramos(valor, resultado);
    }
    
    /**
     * Convierte Celsius a Kelvin
     */
    private void convertirCelsiusAKelvin() {
        double valor = vista.obtenerCelsius();
        String resultado = modelo.celsiusAKelvin(valor);
        vista.mostrarResultadoCelsiusAKelvin(valor, resultado);
    }
    
    /**
     * Convierte Kelvin a Celsius
     */
    private void convertirKelvinACelsius() {
        double valor = vista.obtenerKelvin();
        String resultado = modelo.kelvinACelsius(valor);
        vista.mostrarResultadoKelvinACelsius(valor, resultado);
    }
    
    /**
     * Método main para ejecutar la aplicación
     */
    public static void main(String[] args) {
        ConversionUnidadesControlador controlador = new ConversionUnidadesControlador();
        controlador.iniciar();
    }
}