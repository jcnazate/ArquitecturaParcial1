using CLIESC_CONUNI_GR08.ec.edu.monster.modelo;
using CLIESC_CONUNI_GR08.ec.edu.monster.servicio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.controlador
{
    public class ConversionController
    {
        private readonly IConversionServicio _conversionServicio;

        public ConversionController()
        {
            _conversionServicio = new ConversionServicio();
        }

        public ConversionController(IConversionServicio conversionServicio)
        {
            _conversionServicio = conversionServicio;
        }

        public ConversionModel RealizarConversion(ConversionModel conversionModel, string tipoConversion)
        {
            if (conversionModel == null)
            {
                return null;
            }

            try
            {
                switch (tipoConversion.ToUpper())
                {
                    case "LONGITUD":
                        return RealizarConversionLongitud(conversionModel);
                    case "TEMPERATURA":
                        return RealizarConversionTemperatura(conversionModel);
                    case "MASA":
                        return RealizarConversionMasa(conversionModel);
                    default:
                        throw new ArgumentException("Tipo de conversión no válido");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error en la conversión: {ex.Message}");
                return conversionModel;
            }
        }

        private ConversionModel RealizarConversionLongitud(ConversionModel conversionModel)
        {
            if (conversionModel.FromUnit == "PULGADAS" && conversionModel.ToUnit == "CENTIMETROS")
            {
                conversionModel.Result = _conversionServicio.ConvertirPulgadasACentimetros(conversionModel.Value);
            }
            else if (conversionModel.FromUnit == "CENTIMETROS" && conversionModel.ToUnit == "PULGADAS")
            {
                conversionModel.Result = _conversionServicio.ConvertirCentimetrosAPulgadas(conversionModel.Value);
            }
            else
            {
                throw new ArgumentException("Conversión de longitud no válida");
            }

            return conversionModel;
        }

        private ConversionModel RealizarConversionTemperatura(ConversionModel conversionModel)
        {
            if (conversionModel.FromUnit == "CELSIUS" && conversionModel.ToUnit == "KELVIN")
            {
                conversionModel.Result = _conversionServicio.ConvertirCelsiusAKelvin(conversionModel.Value);
            }
            else if (conversionModel.FromUnit == "KELVIN" && conversionModel.ToUnit == "CELSIUS")
            {
                conversionModel.Result = _conversionServicio.ConvertirKelvinACelsius(conversionModel.Value);
            }
            else
            {
                throw new ArgumentException("Conversión de temperatura no válida");
            }

            return conversionModel;
        }

        private ConversionModel RealizarConversionMasa(ConversionModel conversionModel)
        {
            if (conversionModel.FromUnit == "GRAMOS" && conversionModel.ToUnit == "KILOGRAMOS")
            {
                conversionModel.Result = _conversionServicio.ConvertirGramosAKilogramos(conversionModel.Value);
            }
            else if (conversionModel.FromUnit == "KILOGRAMOS" && conversionModel.ToUnit == "GRAMOS")
            {
                conversionModel.Result = _conversionServicio.ConvertirKilogramosAGramos(conversionModel.Value);
            }
            else
            {
                throw new ArgumentException("Conversión de masa no válida");
            }

            return conversionModel;
        }

        public async Task<ConversionModel> RealizarConversionAsync(ConversionModel conversionModel, string tipoConversion)
        {
            if (conversionModel == null)
            {
                return null;
            }

            try
            {
                switch (tipoConversion.ToUpper())
                {
                    case "LONGITUD":
                        return await RealizarConversionLongitudAsync(conversionModel);
                    case "TEMPERATURA":
                        return await RealizarConversionTemperaturaAsync(conversionModel);
                    case "MASA":
                        return await RealizarConversionMasaAsync(conversionModel);
                    default:
                        throw new ArgumentException("Tipo de conversión no válido");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error en la conversión async: {ex.Message}");
                return conversionModel;
            }
        }

        private async Task<ConversionModel> RealizarConversionLongitudAsync(ConversionModel conversionModel)
        {
            if (conversionModel.FromUnit == "PULGADAS" && conversionModel.ToUnit == "CENTIMETROS")
            {
                conversionModel.Result = await _conversionServicio.ConvertirPulgadasACentimetrosAsync(conversionModel.Value);
            }
            else if (conversionModel.FromUnit == "CENTIMETROS" && conversionModel.ToUnit == "PULGADAS")
            {
                conversionModel.Result = await _conversionServicio.ConvertirCentimetrosAPulgadasAsync(conversionModel.Value);
            }
            else
            {
                throw new ArgumentException("Conversión de longitud no válida");
            }

            return conversionModel;
        }

        private async Task<ConversionModel> RealizarConversionTemperaturaAsync(ConversionModel conversionModel)
        {
            if (conversionModel.FromUnit == "CELSIUS" && conversionModel.ToUnit == "KELVIN")
            {
                conversionModel.Result = await _conversionServicio.ConvertirCelsiusAKelvinAsync(conversionModel.Value);
            }
            else if (conversionModel.FromUnit == "KELVIN" && conversionModel.ToUnit == "CELSIUS")
            {
                conversionModel.Result = await _conversionServicio.ConvertirKelvinACelsiusAsync(conversionModel.Value);
            }
            else
            {
                throw new ArgumentException("Conversión de temperatura no válida");
            }

            return conversionModel;
        }

        private async Task<ConversionModel> RealizarConversionMasaAsync(ConversionModel conversionModel)
        {
            if (conversionModel.FromUnit == "GRAMOS" && conversionModel.ToUnit == "KILOGRAMOS")
            {
                conversionModel.Result = await _conversionServicio.ConvertirGramosAKilogramosAsync(conversionModel.Value);
            }
            else if (conversionModel.FromUnit == "KILOGRAMOS" && conversionModel.ToUnit == "GRAMOS")
            {
                conversionModel.Result = await _conversionServicio.ConvertirKilogramosAGramosAsync(conversionModel.Value);
            }
            else
            {
                throw new ArgumentException("Conversión de masa no válida");
            }

            return conversionModel;
        }

        public ConversionModel CrearConversionModel(double value, string fromUnit, string toUnit)
        {
            return new ConversionModel
            {
                Value = value,
                FromUnit = fromUnit,
                ToUnit = toUnit,
                Result = 0.0
            };
        }
    }
}
