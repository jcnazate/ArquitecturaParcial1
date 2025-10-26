using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.servicio
{
    public interface IConversionServicio
    {
        // Conversiones de Longitud
        double ConvertirPulgadasACentimetros(double pulgadas);
        double ConvertirCentimetrosAPulgadas(double centimetros);
        
        // Conversiones de Temperatura
        double ConvertirCelsiusAKelvin(double celsius);
        double ConvertirKelvinACelsius(double kelvin);
        
        // Conversiones de Masa
        double ConvertirGramosAKilogramos(double gramos);
        double ConvertirKilogramosAGramos(double kilogramos);
        
        // Métodos asíncronos
        Task<double> ConvertirPulgadasACentimetrosAsync(double pulgadas);
        Task<double> ConvertirCentimetrosAPulgadasAsync(double centimetros);
        Task<double> ConvertirCelsiusAKelvinAsync(double celsius);
        Task<double> ConvertirKelvinACelsiusAsync(double kelvin);
        Task<double> ConvertirGramosAKilogramosAsync(double gramos);
        Task<double> ConvertirKilogramosAGramosAsync(double kilogramos);
    }
}
