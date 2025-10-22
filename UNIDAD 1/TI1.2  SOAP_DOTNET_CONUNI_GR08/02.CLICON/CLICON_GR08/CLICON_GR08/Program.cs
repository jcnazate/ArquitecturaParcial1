using CLICON_GR08.Controllers;
using System;

namespace CLICON_GR08
{
    internal class Program
    {
        static void Main(string[] args)
        {
            var controller = new ConversionController();
            controller.Start();

            Console.WriteLine("\nPresione cualquier tecla para salir...");
            Console.ReadKey();
        }
    }
}
