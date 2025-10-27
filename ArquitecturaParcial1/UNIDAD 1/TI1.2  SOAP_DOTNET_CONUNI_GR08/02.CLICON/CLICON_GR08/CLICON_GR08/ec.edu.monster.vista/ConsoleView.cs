using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLICON_GR08.ec.edu.monster.vista
{
    public class ConsoleView
    {
        public void ShowWelcome()
        {
            Console.WriteLine("????????????????????????");
            Console.WriteLine("?                      ?");
            Console.WriteLine("?     BIENVENIDO       ?");
            Console.WriteLine("?                      ?");
            Console.WriteLine("????????????????????????");
        }

        public (string username, string password) GetLoginCredentials()
        {
            Console.WriteLine("\nIngrese sus credenciales:");

            Console.Write("????????????????????????\n");
            Console.Write("?            Usuario:  ?\n");
            Console.Write("????????????????????????\n");
            Console.SetCursorPosition("? Usuario:             ?".Length + 1, Console.CursorTop - 2);
            string username = Console.ReadLine();

            Console.Write("????????????????????????\n");
            Console.Write("?          Contrase�a: ?\n");
            Console.Write("????????????????????????\n");
            Console.SetCursorPosition("? Contrase�a:          ?".Length + 1, Console.CursorTop - 2);
            string password = ReadPassword();

            return (username, password);
        }

        private string ReadPassword()
        {
            string password = string.Empty;
            ConsoleKeyInfo info;
            do
            {
                info = Console.ReadKey(true);
                if (info.Key != ConsoleKey.Backspace && info.Key != ConsoleKey.Enter)
                {
                    password += info.KeyChar;
                    Console.Write("*");
                }
                else if (info.Key == ConsoleKey.Backspace && password.Length > 0)
                {
                    password = password.Substring(0, password.Length - 1);
                    Console.Write("\b \b");
                }
            } while (info.Key != ConsoleKey.Enter);

            Console.WriteLine();
            return password;
        }

        public void ShowLoginError(bool isUsernameError)
        {
            Console.WriteLine(isUsernameError ?
                "\nUsuario incorrecto. Intente nuevamente.\n" :
                "\nContrase�a incorrecta. Intente nuevamente.\n");
        }

        public void ShowLoginSuccess()
        {
            Console.WriteLine("\nInicio de sesi�n exitoso.\n");
        }

        public int ShowMainMenu()
        {
            Console.Clear();
            Console.WriteLine("????????????????????????????????????");
            Console.WriteLine("?   *** Conversor de Unidades ***  ?");
            Console.WriteLine("????????????????????????????????????");
            Console.WriteLine("? Seleccione el tipo de Conversi�n:?");
            Console.WriteLine("?                                  ?");
            Console.WriteLine("? 1. Conversiones de Longitud      ?");
            Console.WriteLine("? 2. Conversiones de Temperatura   ?");
            Console.WriteLine("? 3. Conversiones de Masa          ?");
            Console.WriteLine("? 4. Salir                         ?");
            Console.WriteLine("????????????????????????????????????");

            Console.Write("\nIngrese su opci�n: ");
            int.TryParse(Console.ReadLine(), out int option);
            return option;
        }

        public int ShowConversionMenu(string type)
        {
            Console.Clear();
            Console.WriteLine("????????????????????????????????????");
            Console.WriteLine($"?  *** Conversiones de {type} ***");
            Console.WriteLine("????????????????????????????????????");

            switch (type.ToLower())
            {
                case "longitud":
                    Console.WriteLine("? 1. Cent�metros a Pulgadas        ?");
                    Console.WriteLine("? 2. Pulgadas a Cent�metros        ?");
                    break;
                case "temperatura":
                    Console.WriteLine("? 1. Celsius a Fahrenheit          ?");
                    Console.WriteLine("? 2. Fahrenheit a Celsius          ?");
                    break;
                case "masa":
                    Console.WriteLine("? 1. Kilogramos a Gramos           ?");
                    Console.WriteLine("? 2. Gramos a Kilogramos           ?");
                    break;
            }

            Console.WriteLine("? 3. Volver al men� principal      ?");
            Console.WriteLine("????????????????????????????????????");

            Console.Write("\nIngrese su opci�n: ");
            int.TryParse(Console.ReadLine(), out int option);
            return option;
        }

        public double GetValueToConvert(string fromUnit)
        {
            Console.Write($"\nIngrese el valor a convertir en {fromUnit}: ");
            double.TryParse(Console.ReadLine(), out double value);
            return value;
        }

        public void ShowResult(double inputValue, double result, string fromUnit, string toUnit)
        {
            Console.WriteLine($"\nResultado de la conversi�n: {inputValue} {fromUnit} = {result} {toUnit}");
            Console.WriteLine("\nPresione cualquier tecla para continuar...");
            Console.ReadKey();
        }

        public void ShowError(string message)
        {
            Console.WriteLine($"\nError: {message}");
            Console.WriteLine("\nPresione cualquier tecla para continuar...");
            Console.ReadKey();
        }
    }
}

