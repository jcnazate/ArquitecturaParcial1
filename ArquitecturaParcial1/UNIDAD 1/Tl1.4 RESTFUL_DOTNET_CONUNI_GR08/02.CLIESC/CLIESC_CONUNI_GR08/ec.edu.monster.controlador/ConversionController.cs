using CLIESC_CONUNI_GR08.ec.edu.monster.modelo;
using CLIESC_CONUNI_GR08.ec.edu.monster.servicio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.controlador
{
    internal class ConversionController
    {
        private readonly ConversionServicio _conversionServicio;

        public ConversionController()
        {
            _conversionServicio = new ConversionServicio();
        }

        public ConversionModel RealizarConversion(ConversionModel conversionModel, string tipoConversion)
        {
            try
            {
                // Ejecutar de forma síncrona para mantener compatibilidad con el formulario
                Task<ConversionModel> task = null;

                switch (tipoConversion.ToUpper())
                {
                    case "LONGITUD":
                        task = RealizarConversionLongitud(conversionModel);
                        break;
                    case "TEMPERATURA":
                        task = RealizarConversionTemperatura(conversionModel);
                        break;
                    case "MASA":
                        task = RealizarConversionMasa(conversionModel);
                        break;
                    default:
                        conversionModel.IsSuccess = false;
                        conversionModel.Message = "Tipo de conversión no válido";
                        return conversionModel;
                }

                if (task != null)
                {
                    task.Wait(); // Esperar a que termine la tarea asíncrona
                    return task.Result;
                }

                return conversionModel;
            }
            catch (Exception ex)
            {
                conversionModel.IsSuccess = false;
                conversionModel.Message = $"Error: {ex.Message}";
                return conversionModel;
            }
        }

        private async Task<ConversionModel> RealizarConversionLongitud(ConversionModel conversionModel)
        {
            try
            {
                if (conversionModel.FromUnit == "PULGADAS" && conversionModel.ToUnit == "CENTIMETROS")
                {
                    return await _conversionServicio.PulgadasACentimetrosAsync(conversionModel.Value);
                }
                else if (conversionModel.FromUnit == "CENTIMETROS" && conversionModel.ToUnit == "PULGADAS")
                {
                    return await _conversionServicio.CentimetrosAPulgadasAsync(conversionModel.Value);
                }
                else
                {
                    conversionModel.IsSuccess = false;
                    conversionModel.Message = "Conversión de longitud no válida";
                    return conversionModel;
                }
            }
            catch (Exception ex)
            {
                conversionModel.IsSuccess = false;
                conversionModel.Message = $"Error en conversión de longitud: {ex.Message}";
                return conversionModel;
            }
        }

        private async Task<ConversionModel> RealizarConversionTemperatura(ConversionModel conversionModel)
        {
            try
            {
                if (conversionModel.FromUnit == "KELVIN" && conversionModel.ToUnit == "CELSIUS")
                {
                    return await _conversionServicio.KelvinACelsiusAsync(conversionModel.Value);
                }
                else if (conversionModel.FromUnit == "CELSIUS" && conversionModel.ToUnit == "KELVIN")
                {
                    return await _conversionServicio.CelsiusAKelvinAsync(conversionModel.Value);
                }
                else
                {
                    conversionModel.IsSuccess = false;
                    conversionModel.Message = "Conversión de temperatura no válida";
                    return conversionModel;
                }
            }
            catch (Exception ex)
            {
                conversionModel.IsSuccess = false;
                conversionModel.Message = $"Error en conversión de temperatura: {ex.Message}";
                return conversionModel;
            }
        }

        private async Task<ConversionModel> RealizarConversionMasa(ConversionModel conversionModel)
        {
            try
            {
                if (conversionModel.FromUnit == "KILOGRAMOS" && conversionModel.ToUnit == "GRAMOS")
                {
                    return await _conversionServicio.KilogramosAGramosAsync(conversionModel.Value);
                }
                else if (conversionModel.FromUnit == "GRAMOS" && conversionModel.ToUnit == "KILOGRAMOS")
                {
                    return await _conversionServicio.GramosAKilogramosAsync(conversionModel.Value);
                }
                else
                {
                    conversionModel.IsSuccess = false;
                    conversionModel.Message = "Conversión de masa no válida";
                    return conversionModel;
                }
            }
            catch (Exception ex)
            {
                conversionModel.IsSuccess = false;
                conversionModel.Message = $"Error en conversión de masa: {ex.Message}";
                return conversionModel;
            }
        }

        public async Task<ConversionModel> RealizarConversionAsync(ConversionModel conversionModel, string tipoConversion)
        {
            try
            {
                switch (tipoConversion.ToUpper())
                {
                    case "LONGITUD":
                        return await RealizarConversionLongitud(conversionModel);
                    case "TEMPERATURA":
                        return await RealizarConversionTemperatura(conversionModel);
                    case "MASA":
                        return await RealizarConversionMasa(conversionModel);
                    default:
                        conversionModel.IsSuccess = false;
                        conversionModel.Message = "Tipo de conversión no válido";
                        return conversionModel;
                }
            }
            catch (Exception ex)
            {
                conversionModel.IsSuccess = false;
                conversionModel.Message = $"Error: {ex.Message}";
                return conversionModel;
            }
        }

        public void Dispose()
        {
            _conversionServicio?.Dispose();
        }
    }
}
