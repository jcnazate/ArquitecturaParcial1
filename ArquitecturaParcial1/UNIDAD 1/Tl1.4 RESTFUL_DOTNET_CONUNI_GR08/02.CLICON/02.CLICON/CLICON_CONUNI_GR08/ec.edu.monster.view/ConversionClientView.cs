using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLICON_CONUNI_GR08.ec.edu.monster.view
{
    internal class ConversionClientView
    {
        // Sin colores - diseño en blanco y negro

        public (string user, string password) GetCredentials()
        {
            Console.Clear();
            DrawHeader();
            DrawBox(" AUTENTICACIÓN");
            
            Console.Write(" Usuario: ");
            string user = Console.ReadLine() ?? "";
            
            Console.Write(" Contraseña: ");
            string password = Console.ReadLine() ?? "";
            
            return (user, password);
        }

        public void ShowLoginError()
        {
            DrawBox(" ERROR DE AUTENTICACIÓN");
            Console.WriteLine("Usuario o contraseña incorrectos.");
            Console.WriteLine("Presione cualquier tecla para continuar...");
            Console.ReadKey();
        }

        public void ShowMenu()
        {
            Console.Clear();
            DrawHeader();
            DrawBox(" MENÚ DE CONVERSIÓN");
            
            Console.WriteLine("┌─────────────────────────────────────────────────────────┐");
            Console.WriteLine("│  Seleccione una opción de conversión:                  │");
            Console.WriteLine("├─────────────────────────────────────────────────────────┤");
            
            string[] options = {
                " Pulgadas a Centímetros",
                " Centímetros a Pulgadas", 
                " Celsius a Kelvin",
                " Kelvin a Celsius",
                " Kilogramos a Gramos",
                " Gramos a Kilogramos",
                " Salir"
            };

            for (int i = 0; i < options.Length; i++)
            {
                Console.WriteLine($"│  {i + 1}. {options[i],-45} │");
            }
            
            Console.WriteLine("└─────────────────────────────────────────────────────────┘");
            Console.Write(" Su opción: ");
        }

        public double GetInputValue(string unit)
        {
            Console.Write($" Ingrese el valor en {unit}: ");
            
            while (true)
            {
                string input = Console.ReadLine()?.Trim() ?? "";
                if (double.TryParse(input, NumberStyles.Any, CultureInfo.InvariantCulture, out double value))
                {
                    return value;
                }
                
                Console.WriteLine(" Por favor, ingrese un número válido (use punto como separador decimal, ej. 5.08).");
                Console.Write($" Ingrese el valor en {unit}: ");
            }
        }

        public void ShowConversionResult(string fromUnit, double fromValue, string toUnit, double toValue)
        {
            Console.WriteLine();
            DrawBox(" RESULTADO DE CONVERSIÓN");
            
            Console.WriteLine("┌─────────────────────────────────────────────────────────┐");
            Console.WriteLine("│                                                         │");
            
            // Formatear el resultado con mejor presentación
            string fromFormatted = fromValue.ToString("F2", CultureInfo.InvariantCulture);
            string toFormatted = toValue.ToString("F2", CultureInfo.InvariantCulture);
            
            Console.WriteLine($"│  {fromFormatted,10} {fromUnit,-15} = {toFormatted,10} {toUnit,-15}  │");
            
            Console.WriteLine("│                                                         │");
            Console.WriteLine("└─────────────────────────────────────────────────────────┘");
            
            Console.WriteLine("Presione cualquier tecla para continuar...");
            Console.ReadKey();
        }

        public void ShowError(string message)
        {
            DrawBox(" ERROR");
            Console.WriteLine($" {message}");
            Console.WriteLine("Presione cualquier tecla para continuar...");
            Console.ReadKey();
        }

        public int GetMenuOption()
        {
            while (true)
            {
                if (int.TryParse(Console.ReadLine(), out int option))
                {
                    return option;
                }
                
                Console.WriteLine(" Por favor, ingrese un número válido.");
                ShowMenu();
            }
        }

        private void DrawHeader()
        {
            Console.WriteLine("╔══════════════════════════════════════════════════════════════╗");
            Console.WriteLine("║                                                              ║");
            Console.WriteLine("║              CONVERSOR DE UNIDADES MONSTER                   ║");
            Console.WriteLine("║                                                              ║");
            Console.WriteLine("║              Sistema de Conversión Avanzado                  ║");
            Console.WriteLine("║                                                              ║");
            Console.WriteLine("╚══════════════════════════════════════════════════════════════╝");
            Console.WriteLine();
        }

        private void DrawBox(string title)
        {
            int width = 60;
            int padding = (width - title.Length) / 2;
            
            Console.WriteLine("┌" + new string('─', width - 2) + "┐");
            Console.WriteLine("│" + new string(' ', padding) + title + new string(' ', width - title.Length - padding - 2) + "│");
            Console.WriteLine("└" + new string('─', width - 2) + "┘");
            Console.WriteLine();
        }

        public void ShowWelcomeMessage()
        {
            Console.Clear();
            DrawHeader();
            
            DrawBox(" ¡BIENVENIDO!");
            
            Console.WriteLine("Sistema de conversión de unidades iniciado correctamente.");
            Console.WriteLine("Conectando con el servidor REST...");
            Console.WriteLine();
            
            // Simular carga
            for (int i = 0; i < 3; i++)
            {
                Console.Write(" Conectando");
                for (int j = 0; j < 3; j++)
                {
                    Console.Write(".");
                    System.Threading.Thread.Sleep(300);
                }
                Console.Write("\r" + new string(' ', 20) + "\r");
            }
            
            Console.WriteLine("✅ Conexión establecida exitosamente!");
            Console.WriteLine();
        }

        public void ShowGoodbyeMessage()
        {
            Console.Clear();
            DrawHeader();
            
            DrawBox("¡HASTA LUEGO!");
            
            Console.WriteLine("Gracias por usar el Conversor de Unidades Monster.");
            Console.WriteLine("¡Que tengas un excelente día!");
            Console.WriteLine();
            
            Console.WriteLine("Presione cualquier tecla para salir...");
            Console.ReadKey();
        }
    }
}