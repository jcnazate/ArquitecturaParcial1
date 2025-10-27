using CLICON_CONUNI_GR08.ec.edu.monster.controller;
using CLICON_CONUNI_GR08.ec.edu.monster.model;
using CLICON_CONUNI_GR08.ec.edu.monster.view;

namespace CLICON_CONUNI_GR08
{
    class Program
    {
        static async Task Main(string[] args)
        {
            try
            {
                var model = new ConversionClientModel();
                var view = new ConversionClientView();
                var controller = new ConversionClientController(model, view);
                
                await controller.StartAsync();
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error fatal: {ex.Message}");
                Console.WriteLine("Presione cualquier tecla para salir...");
                Console.ReadKey();
            }
        }
    }
}
