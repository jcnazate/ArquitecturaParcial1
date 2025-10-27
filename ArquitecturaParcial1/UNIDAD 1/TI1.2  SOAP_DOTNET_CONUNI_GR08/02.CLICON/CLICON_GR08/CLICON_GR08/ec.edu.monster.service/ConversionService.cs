using CLICON_GR08.ReferenciaConversionUni;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using CLICON_GR08.ReferenciaLogin;

namespace CLICON_GR08.ec.edu.monster.service
{
    public class ConversionService
    {
        private readonly ConversionUnidadesServicioClient _conversionClient;
        private readonly LoginServicioClient _loginClient;

        public ConversionService()
        {
            _conversionClient = new ConversionUnidadesServicioClient();
            _loginClient = new LoginServicioClient();
        }

        public bool ValidateLogin(string username, string password)
        {
            try
            {
                // Aqu� deber�as usar el servicio real de login
                return username == "MONSTER" && password == "MONSTER9";
            }
            catch (Exception)
            {
                return false;
            }
        }

        public double ConvertLength(double value, int option)
        {
            try
            {
                switch (option)
                {
                    case 1: // cm to inches
                        return _conversionClient.CentimetrosAPulgadas(value);
                    case 2: // inches to cm
                        return _conversionClient.PulgadasACentimetros(value);
                    default:
                        throw new ArgumentException("Opci�n de conversi�n no v�lida");
                }
            }
            catch (Exception ex)
            {
                throw new Exception($"Error al convertir longitud: {ex.Message}");
            }
        }

        public double ConvertTemperature(double value, int option)
        {
            try
            {
                switch (option)
                {
                    case 1: // Celsius to Fahrenheit
                        return _conversionClient.CentimetrosAPulgadas(value); // Temporal
                    case 2: // Fahrenheit to Celsius
                        return _conversionClient.PulgadasACentimetros(value); // Temporal
                    default:
                        throw new ArgumentException("Opci�n de conversi�n no v�lida");
                }
            }
            catch (Exception ex)
            {
                throw new Exception($"Error al convertir temperatura: {ex.Message}");
            }
        }

        public double ConvertMass(double value, int option)
        {
            try
            {
                switch (option)
                {
                    case 1: // kg to g
                        return _conversionClient.KilogramosAGramos(value);
                    case 2: // g to kg
                        return _conversionClient.GramosAKilogramos(value);
                    default:
                        throw new ArgumentException("Opci�n de conversi�n no v�lida");
                }
            }
            catch (Exception ex)
            {
                throw new Exception($"Error al convertir masa: {ex.Message}");
            }
        }
    }
}

