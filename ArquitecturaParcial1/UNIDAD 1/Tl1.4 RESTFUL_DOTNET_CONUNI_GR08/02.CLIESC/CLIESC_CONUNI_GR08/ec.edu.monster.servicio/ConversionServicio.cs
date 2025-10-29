using CLIESC_CONUNI_GR08.ec.edu.monster.modelo;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.servicio
{
    internal class ConversionServicio
    {
        private readonly HttpClient _httpClient;
        private readonly string _baseUrl;

        public ConversionServicio()
        {
            _httpClient = new HttpClient();
            _baseUrl = "http://localhost:5000"; // URL base del servicio REST
        }

        public async Task<ConversionModel> PulgadasACentimetrosAsync(double pulgadas)
        {
            try
            {
                var url = $"{_baseUrl}/pulgadas-a-centimetros?pulgadas={pulgadas}";
                var response = await _httpClient.GetAsync(url);
                var content = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<dynamic>(content);
                    return new ConversionModel
                    {
                        Value = pulgadas,
                        FromUnit = "PULGADAS",
                        ToUnit = "CENTIMETROS",
                        ConversionType = "LONGITUD",
                        Result = (double)result.centimetros,
                        IsSuccess = true,
                        Message = "Conversión exitosa"
                    };
                }
                else
                {
                    return new ConversionModel
                    {
                        Value = pulgadas,
                        FromUnit = "PULGADAS",
                        ToUnit = "CENTIMETROS",
                        ConversionType = "LONGITUD",
                        IsSuccess = false,
                        Message = "Error en la conversión"
                    };
                }
            }
            catch (Exception ex)
            {
                return new ConversionModel
                {
                    Value = pulgadas,
                    FromUnit = "PULGADAS",
                    ToUnit = "CENTIMETROS",
                    ConversionType = "LONGITUD",
                    IsSuccess = false,
                    Message = $"Error de conexión: {ex.Message}"
                };
            }
        }

        public async Task<ConversionModel> CentimetrosAPulgadasAsync(double centimetros)
        {
            try
            {
                var url = $"{_baseUrl}/centimetros-a-pulgadas?centimetros={centimetros}";
                var response = await _httpClient.GetAsync(url);
                var content = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<dynamic>(content);
                    return new ConversionModel
                    {
                        Value = centimetros,
                        FromUnit = "CENTIMETROS",
                        ToUnit = "PULGADAS",
                        ConversionType = "LONGITUD",
                        Result = (double)result.pulgadas,
                        IsSuccess = true,
                        Message = "Conversión exitosa"
                    };
                }
                else
                {
                    return new ConversionModel
                    {
                        Value = centimetros,
                        FromUnit = "CENTIMETROS",
                        ToUnit = "PULGADAS",
                        ConversionType = "LONGITUD",
                        IsSuccess = false,
                        Message = "Error en la conversión"
                    };
                }
            }
            catch (Exception ex)
            {
                return new ConversionModel
                {
                    Value = centimetros,
                    FromUnit = "CENTIMETROS",
                    ToUnit = "PULGADAS",
                    ConversionType = "LONGITUD",
                    IsSuccess = false,
                    Message = $"Error de conexión: {ex.Message}"
                };
            }
        }

        public async Task<ConversionModel> KelvinACelsiusAsync(double kelvin)
        {
            try
            {
                var url = $"{_baseUrl}/kelvin-a-celsius?kelvin={kelvin}";
                var response = await _httpClient.GetAsync(url);
                var content = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<dynamic>(content);
                    return new ConversionModel
                    {
                        Value = kelvin,
                        FromUnit = "KELVIN",
                        ToUnit = "CELSIUS",
                        ConversionType = "TEMPERATURA",
                        Result = (double)result.celsius,
                        IsSuccess = true,
                        Message = "Conversión exitosa"
                    };
                }
                else
                {
                    return new ConversionModel
                    {
                        Value = kelvin,
                        FromUnit = "KELVIN",
                        ToUnit = "CELSIUS",
                        ConversionType = "TEMPERATURA",
                        IsSuccess = false,
                        Message = "Error en la conversión"
                    };
                }
            }
            catch (Exception ex)
            {
                return new ConversionModel
                {
                    Value = kelvin,
                    FromUnit = "KELVIN",
                    ToUnit = "CELSIUS",
                    ConversionType = "TEMPERATURA",
                    IsSuccess = false,
                    Message = $"Error de conexión: {ex.Message}"
                };
            }
        }

        public async Task<ConversionModel> CelsiusAKelvinAsync(double celsius)
        {
            try
            {
                var url = $"{_baseUrl}/celsius-a-kelvin?celsius={celsius}";
                var response = await _httpClient.GetAsync(url);
                var content = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<dynamic>(content);
                    return new ConversionModel
                    {
                        Value = celsius,
                        FromUnit = "CELSIUS",
                        ToUnit = "KELVIN",
                        ConversionType = "TEMPERATURA",
                        Result = (double)result.kelvin,
                        IsSuccess = true,
                        Message = "Conversión exitosa"
                    };
                }
                else
                {
                    return new ConversionModel
                    {
                        Value = celsius,
                        FromUnit = "CELSIUS",
                        ToUnit = "KELVIN",
                        ConversionType = "TEMPERATURA",
                        IsSuccess = false,
                        Message = "Error en la conversión"
                    };
                }
            }
            catch (Exception ex)
            {
                return new ConversionModel
                {
                    Value = celsius,
                    FromUnit = "CELSIUS",
                    ToUnit = "KELVIN",
                    ConversionType = "TEMPERATURA",
                    IsSuccess = false,
                    Message = $"Error de conexión: {ex.Message}"
                };
            }
        }

        public async Task<ConversionModel> KilogramosAGramosAsync(double kilogramos)
        {
            try
            {
                var url = $"{_baseUrl}/kilogramos-a-gramos?kilogramos={kilogramos}";
                var response = await _httpClient.GetAsync(url);
                var content = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<dynamic>(content);
                    return new ConversionModel
                    {
                        Value = kilogramos,
                        FromUnit = "KILOGRAMOS",
                        ToUnit = "GRAMOS",
                        ConversionType = "MASA",
                        Result = (double)result.gramos,
                        IsSuccess = true,
                        Message = "Conversión exitosa"
                    };
                }
                else
                {
                    return new ConversionModel
                    {
                        Value = kilogramos,
                        FromUnit = "KILOGRAMOS",
                        ToUnit = "GRAMOS",
                        ConversionType = "MASA",
                        IsSuccess = false,
                        Message = "Error en la conversión"
                    };
                }
            }
            catch (Exception ex)
            {
                return new ConversionModel
                {
                    Value = kilogramos,
                    FromUnit = "KILOGRAMOS",
                    ToUnit = "GRAMOS",
                    ConversionType = "MASA",
                    IsSuccess = false,
                    Message = $"Error de conexión: {ex.Message}"
                };
            }
        }

        public async Task<ConversionModel> GramosAKilogramosAsync(double gramos)
        {
            try
            {
                var url = $"{_baseUrl}/gramos-a-kilogramos?gramos={gramos}";
                var response = await _httpClient.GetAsync(url);
                var content = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<dynamic>(content);
                    return new ConversionModel
                    {
                        Value = gramos,
                        FromUnit = "GRAMOS",
                        ToUnit = "KILOGRAMOS",
                        ConversionType = "MASA",
                        Result = (double)result.kilogramos,
                        IsSuccess = true,
                        Message = "Conversión exitosa"
                    };
                }
                else
                {
                    return new ConversionModel
                    {
                        Value = gramos,
                        FromUnit = "GRAMOS",
                        ToUnit = "KILOGRAMOS",
                        ConversionType = "MASA",
                        IsSuccess = false,
                        Message = "Error en la conversión"
                    };
                }
            }
            catch (Exception ex)
            {
                return new ConversionModel
                {
                    Value = gramos,
                    FromUnit = "GRAMOS",
                    ToUnit = "KILOGRAMOS",
                    ConversionType = "MASA",
                    IsSuccess = false,
                    Message = $"Error de conexión: {ex.Message}"
                };
            }
        }

        public void Dispose()
        {
            _httpClient?.Dispose();
        }
    }
}
