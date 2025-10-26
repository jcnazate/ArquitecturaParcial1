using CLIESC_CONUNI_GR08.ec.edu.monster.servicio;
using CLIESC_CONUNI_GR08.ServiceReference2;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.servicio
{
    public class ConversionServicio : IConversionServicio
    {
        private readonly ConversionUnidadesServicioClient _conversionClient;

        public ConversionServicio()
        {
            _conversionClient = new ConversionUnidadesServicioClient();
        }

        // Conversiones de Longitud
        public double ConvertirPulgadasACentimetros(double pulgadas)
        {
            try
            {
                return _conversionClient.PulgadasACentimetros(pulgadas);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir pulgadas a centímetros: {ex.Message}");
                throw;
            }
        }

        public double ConvertirCentimetrosAPulgadas(double centimetros)
        {
            try
            {
                return _conversionClient.CentimetrosAPulgadas(centimetros);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir centímetros a pulgadas: {ex.Message}");
                throw;
            }
        }

        // Conversiones de Temperatura
        public double ConvertirCelsiusAKelvin(double celsius)
        {
            try
            {
                return _conversionClient.CelciusAKelvin(celsius);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir Celsius a Kelvin: {ex.Message}");
                throw;
            }
        }

        public double ConvertirKelvinACelsius(double kelvin)
        {
            try
            {
                return _conversionClient.KelvinACelcius(kelvin);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir Kelvin a Celsius: {ex.Message}");
                throw;
            }
        }

        // Conversiones de Masa
        public double ConvertirGramosAKilogramos(double gramos)
        {
            try
            {
                return _conversionClient.GramosAKilogramos(gramos);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir gramos a kilogramos: {ex.Message}");
                throw;
            }
        }

        public double ConvertirKilogramosAGramos(double kilogramos)
        {
            try
            {
                return _conversionClient.KilogramosAGramos(kilogramos);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir kilogramos a gramos: {ex.Message}");
                throw;
            }
        }

        // Métodos asíncronos
        public async Task<double> ConvertirPulgadasACentimetrosAsync(double pulgadas)
        {
            try
            {
                return await _conversionClient.PulgadasACentimetrosAsync(pulgadas);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir pulgadas a centímetros (async): {ex.Message}");
                throw;
            }
        }

        public async Task<double> ConvertirCentimetrosAPulgadasAsync(double centimetros)
        {
            try
            {
                return await _conversionClient.CentimetrosAPulgadasAsync(centimetros);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir centímetros a pulgadas (async): {ex.Message}");
                throw;
            }
        }

        public async Task<double> ConvertirCelsiusAKelvinAsync(double celsius)
        {
            try
            {
                return await _conversionClient.CelciusAKelvinAsync(celsius);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir Celsius a Kelvin (async): {ex.Message}");
                throw;
            }
        }

        public async Task<double> ConvertirKelvinACelsiusAsync(double kelvin)
        {
            try
            {
                return await _conversionClient.KelvinACelciusAsync(kelvin);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir Kelvin a Celsius (async): {ex.Message}");
                throw;
            }
        }

        public async Task<double> ConvertirGramosAKilogramosAsync(double gramos)
        {
            try
            {
                return await _conversionClient.GramosAKilogramosAsync(gramos);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir gramos a kilogramos (async): {ex.Message}");
                throw;
            }
        }

        public async Task<double> ConvertirKilogramosAGramosAsync(double kilogramos)
        {
            try
            {
                return await _conversionClient.KilogramosAGramosAsync(kilogramos);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al convertir kilogramos a gramos (async): {ex.Message}");
                throw;
            }
        }

        public void Dispose()
        {
            _conversionClient?.Close();
        }
    }
}
