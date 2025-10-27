using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace CLICON_CONUNI_GR08.ec.edu.monster.model
{
    internal class ConversionClientModel
    {
        private const string BaseUrl = "http://localhost:5000";
        private readonly HttpClient _client;

        public ConversionClientModel()
        {
            _client = new HttpClient();
        }

        public async Task<bool> AuthenticateAsync(string user, string password)
        {
            var response = await _client.GetAsync($"{BaseUrl}/authenticate?user={user}&password={password}");
            if (response.IsSuccessStatusCode)
            {
                var json = await response.Content.ReadAsStringAsync();
                try
                {
                    var result = JsonSerializer.Deserialize<Dictionary<string, string>>(json);
                    if (result != null && result.TryGetValue("message", out string? message))
                    {
                        return message == "Login exitoso";
                    }
                }
                catch (JsonException ex)
                {
                    Console.WriteLine($"Error al deserializar la respuesta JSON: {ex.Message}");
                }
            }
            return false;
        }

        public async Task<double> PulgadasACentimetrosAsync(double pulgadas)
        {
            string url = $"{BaseUrl}/pulgadas-a-centimetros?pulgadas={pulgadas.ToString(CultureInfo.InvariantCulture)}";
            //Console.WriteLine($"Request URL: {url}"); // Log for debugging
            var response = await _client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            var json = await response.Content.ReadAsStringAsync();
            //Console.WriteLine($"Raw JSON response: {json}"); // Log for debugging
            var options = new JsonSerializerOptions
            {
                NumberHandling = System.Text.Json.Serialization.JsonNumberHandling.AllowReadingFromString,
                PropertyNameCaseInsensitive = true
            };
            var result = JsonSerializer.Deserialize<Dictionary<string, double>>(json, options);
            return result["centimetros"];
        }

        public async Task<double> CentimetrosAPulgadasAsync(double centimetros)
        {
            string url = $"{BaseUrl}/centimetros-a-pulgadas?centimetros={centimetros.ToString(CultureInfo.InvariantCulture)}";
            var response = await _client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            var json = await response.Content.ReadAsStringAsync();
            var options = new JsonSerializerOptions
            {
                NumberHandling = System.Text.Json.Serialization.JsonNumberHandling.AllowReadingFromString,
                PropertyNameCaseInsensitive = true
            };
            var result = JsonSerializer.Deserialize<Dictionary<string, double>>(json, options);
            return result["pulgadas"];
        }

        public async Task<double> CelsiusAKelvinAsync(double celsius)
        {
            string url = $"{BaseUrl}/celsius-a-kelvin?celsius={celsius.ToString(CultureInfo.InvariantCulture)}";
            var response = await _client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            var json = await response.Content.ReadAsStringAsync();
            var options = new JsonSerializerOptions
            {
                NumberHandling = System.Text.Json.Serialization.JsonNumberHandling.AllowReadingFromString,
                PropertyNameCaseInsensitive = true
            };
            var result = JsonSerializer.Deserialize<Dictionary<string, double>>(json, options);
            return result["kelvin"];
        }

        public async Task<double> KelvinACelsiusAsync(double kelvin)
        {
            string url = $"{BaseUrl}/kelvin-a-celsius?kelvin={kelvin.ToString(CultureInfo.InvariantCulture)}";
            var response = await _client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            var json = await response.Content.ReadAsStringAsync();
            var options = new JsonSerializerOptions
            {
                NumberHandling = System.Text.Json.Serialization.JsonNumberHandling.AllowReadingFromString,
                PropertyNameCaseInsensitive = true
            };
            var result = JsonSerializer.Deserialize<Dictionary<string, double>>(json, options);
            return result["celsius"];
        }

        public async Task<double> KilogramosAGramosAsync(double kilogramos)
        {
            string url = $"{BaseUrl}/kilogramos-a-gramos?kilogramos={kilogramos.ToString(CultureInfo.InvariantCulture)}";
            var response = await _client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            var json = await response.Content.ReadAsStringAsync();
            var options = new JsonSerializerOptions
            {
                NumberHandling = System.Text.Json.Serialization.JsonNumberHandling.AllowReadingFromString,
                PropertyNameCaseInsensitive = true
            };
            var result = JsonSerializer.Deserialize<Dictionary<string, double>>(json, options);
            return result["gramos"];
        }

        public async Task<double> GramosAKilogramosAsync(double gramos)
        {
            string url = $"{BaseUrl}/gramos-a-kilogramos?gramos={gramos.ToString(CultureInfo.InvariantCulture)}";
            var response = await _client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            var json = await response.Content.ReadAsStringAsync();
            var options = new JsonSerializerOptions
            {
                NumberHandling = System.Text.Json.Serialization.JsonNumberHandling.AllowReadingFromString,
                PropertyNameCaseInsensitive = true
            };
            var result = JsonSerializer.Deserialize<Dictionary<string, double>>(json, options);
            return result["kilogramos"];
        }
    }
}
