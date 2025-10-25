package ec.edu.monster.vista;

import java.util.Scanner;

/**
 * Vista para la interfaz de usuario
 * 
 * @author JOHAN
 */
public class ConversionUnidadesVista {
    
    private final Scanner scanner;

    public ConversionUnidadesVista() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el banner de la aplicación
     */
    public void mostrarBanner() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE CONVERSIÓN DE UNIDADES       ║");
        System.out.println("║        Cliente REST - Consola              ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }

    /**
     * Obtiene el usuario
     */
    public String obtenerUsuario() {
        System.out.println("═══════════════════════════════════════════");
        System.out.println("            INICIO DE SESIÓN");
        System.out.println("═══════════════════════════════════════════");
        System.out.print("Ingrese su usuario: ");
        return scanner.nextLine().trim();
    }

    /**
     * Obtiene la contraseña
     */
    public String obtenerPassword() {
        System.out.print("Ingrese su contraseña: ");
        return scanner.nextLine().trim();
    }

    /**
     * Muestra mensaje de login exitoso
     */
    public void mostrarLoginExitoso() {
        System.out.println("\n✓ Login exitoso. ¡Bienvenido!");
    }

    /**
     * Muestra mensaje de login fallido
     */
    public void mostrarLoginFallido() {
        System.out.println("\n✗ Usuario o contraseña incorrectos. Intente de nuevo.");
    }

    /**
     * Muestra el menú y obtiene la opción seleccionada
     */
    public int obtenerOpcionConversion() {
        int opcion = -1;
        while (true) {
            try {
                System.out.println("\n╔════════════════════════════════════════════╗");
                System.out.println("║            MENÚ PRINCIPAL                  ║");
                System.out.println("╠════════════════════════════════════════════╣");
                System.out.println("║  1. Convertir pulgadas a centímetros       ║");
                System.out.println("║  2. Convertir centímetros a pulgadas       ║");
                System.out.println("║  3. Convertir kilogramos a gramos          ║");
                System.out.println("║  4. Convertir gramos a kilogramos          ║");
                System.out.println("║  5. Convertir Celsius a Kelvin             ║");
                System.out.println("║  6. Convertir Kelvin a Celsius             ║");
                System.out.println("║  0. Salir                                  ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.print("\nOpción: ");
                String input = scanner.nextLine().trim();

                opcion = Integer.parseInt(input);

                if (opcion >= 0 && opcion <= 6) {
                    return opcion;
                } else {
                    System.out.println("\n✗ Error: Opción inválida. Ingrese un número entre 0 y 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n✗ Error: Ingrese un número válido.");
            }
        }
    }

    /**
     * Obtiene valor en centímetros
     */
    public double obtenerCentimetros() {
        while (true) {
            System.out.print("\nIngrese la longitud en centímetros: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("✗ Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double centimetros = Double.parseDouble(input);
                if (centimetros > 0) {
                    return centimetros;
                } else {
                    System.out.println("✗ Error: La longitud debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("✗ Error: Ingrese un número válido.");
            }
        }
    }

    /**
     * Obtiene valor en pulgadas
     */
    public double obtenerPulgadas() {
        while (true) {
            try {
                System.out.print("\nIngrese la longitud en pulgadas: ");
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    System.out.println("✗ Error: No puede dejar el campo vacío.");
                    continue;
                }
                
                double pulgadas = Double.parseDouble(input);
                if (pulgadas > 0) {
                    return pulgadas;
                } else {
                    System.out.println("✗ Error: La longitud debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("✗ Error: Ingrese un número válido.");
            }
        }
    }

    /**
     * Obtiene valor en Kelvin
     */
    public double obtenerKelvin() {
        while (true) {
            System.out.print("\nIngrese la temperatura en Kelvin: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("✗ Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double kelvin = Double.parseDouble(input);
                if (kelvin >= 0) {
                    return kelvin;
                } else {
                    System.out.println("✗ Error: La temperatura en Kelvin no puede ser negativa.");
                }
            } catch (NumberFormatException e) {
                System.out.println("✗ Error: Ingrese un número válido.");
            }
        }
    }

    /**
     * Obtiene valor en Celsius
     */
    public double obtenerCelsius() {
        while (true) {
            System.out.print("\nIngrese la temperatura en Celsius: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("✗ Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double celsius = Double.parseDouble(input);
                if (celsius >= -273.15) {
                    return celsius;
                } else {
                    System.out.println("✗ Error: La temperatura no puede ser menor a -273.15°C.");
                }
            } catch (NumberFormatException e) {
                System.out.println("✗ Error: Ingrese un número válido.");
            }
        }
    }
    
    /**
     * Obtiene valor en gramos
     */
    public double obtenerGramos() {
        while (true) {
            System.out.print("\nIngrese el peso en gramos: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("✗ Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double gramos = Double.parseDouble(input);
                if (gramos > 0) {
                    return gramos;
                } else {
                    System.out.println("✗ Error: El peso debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("✗ Error: Ingrese un número válido.");
            }
        }
    }
    
    /**
     * Obtiene valor en kilogramos
     */
    public double obtenerKilogramos() {
        while (true) {
            System.out.print("\nIngrese el peso en kilogramos: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("✗ Error: No puede dejar el campo vacío.");
                continue;
            }
            
            try {
                double kilogramos = Double.parseDouble(input);
                if (kilogramos > 0) {
                    return kilogramos;
                } else {
                    System.out.println("✗ Error: El peso debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("✗ Error: Ingrese un número válido.");
            }
        }
    }

    /**
     * Muestra resultado de conversión de pulgadas a centímetros
     */
    public void mostrarResultadoPulgadasACentimetros(double valorOriginal, String resultado) {
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("  RESULTADO DE LA CONVERSIÓN");
        System.out.println("─────────────────────────────────────────");
        System.out.printf("  %.4f pulgadas = %s centímetros%n", valorOriginal, resultado);
        System.out.println("─────────────────────────────────────────");
    }

    /**
     * Muestra resultado de conversión de centímetros a pulgadas
     */
    public void mostrarResultadoCentimetrosAPulgadas(double valorOriginal, String resultado) {
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("  RESULTADO DE LA CONVERSIÓN");
        System.out.println("─────────────────────────────────────────");
        System.out.printf("  %.4f centímetros = %s pulgadas%n", valorOriginal, resultado);
        System.out.println("─────────────────────────────────────────");
    }

    /**
     * Muestra resultado de conversión de Kelvin a Celsius
     */
    public void mostrarResultadoKelvinACelsius(double valorOriginal, String resultado) {
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("  RESULTADO DE LA CONVERSIÓN");
        System.out.println("─────────────────────────────────────────");
        System.out.printf("  %.4f K = %s °C%n", valorOriginal, resultado);
        System.out.println("─────────────────────────────────────────");
    }

    /**
     * Muestra resultado de conversión de Celsius a Kelvin
     */
    public void mostrarResultadoCelsiusAKelvin(double valorOriginal, String resultado) {
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("  RESULTADO DE LA CONVERSIÓN");
        System.out.println("─────────────────────────────────────────");
        System.out.printf("  %.4f °C = %s K%n", valorOriginal, resultado);
        System.out.println("─────────────────────────────────────────");
    }

    /**
     * Muestra resultado de conversión de gramos a kilogramos
     */
    public void mostrarResultadoGramosAKilogramos(double valorOriginal, String resultado) {
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("  RESULTADO DE LA CONVERSIÓN");
        System.out.println("─────────────────────────────────────────");
        System.out.printf("  %.4f gramos = %s kilogramos%n", valorOriginal, resultado);
        System.out.println("─────────────────────────────────────────");
    }

    /**
     * Muestra resultado de conversión de kilogramos a gramos
     */
    public void mostrarResultadoKilogramosAGramos(double valorOriginal, String resultado) {
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("  RESULTADO DE LA CONVERSIÓN");
        System.out.println("─────────────────────────────────────────");
        System.out.printf("  %.4f kilogramos = %s gramos%n", valorOriginal, resultado);
        System.out.println("─────────────────────────────────────────");
    }

    /**
     * Muestra un mensaje de error
     */
    public void mostrarError(String mensaje) {
        System.out.println("\n✗ Error: " + mensaje);
    }

    /**
     * Espera a que el usuario presione Enter
     */
    public void esperarEnter() {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Muestra mensaje de despedida
     */
    public void mostrarDespedida() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║     ¡Gracias por usar el sistema!          ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }

    /**
     * Limpia la consola (simulado)
     */
    public void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * Cierra el scanner
     */
    public void cerrar() {
        if (scanner != null) {
            scanner.close();
        }
    }
}