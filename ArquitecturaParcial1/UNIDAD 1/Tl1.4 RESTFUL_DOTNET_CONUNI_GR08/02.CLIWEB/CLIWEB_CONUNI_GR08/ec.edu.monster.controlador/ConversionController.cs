using Microsoft.AspNetCore.Mvc;
using System.Text.Json;

namespace CliWeb_ConUni_GR08.ec.edu.monster.controller
{
    public class ConversionController : Controller
    {
        private readonly HttpClient _httpClient;
        private readonly IConfiguration _configuration;

        public ConversionController(HttpClient httpClient, IConfiguration configuration)
        {
            _httpClient = httpClient;
            _configuration = configuration;
        }

        // --- helper para obtener la URL base del servicio REST ---
        private string GetBaseUrl() => _configuration["RestService:BaseUrl"] ?? "https://localhost:5001";

        // ================== PÁGINAS (GET) ==================
        [HttpGet]
        public IActionResult Longitud()    => View("Longitud");

        [HttpGet]
        public IActionResult Masa()        => View("Masa");

        [HttpGet]
        public IActionResult Temperatura() => View("Temperatura");

        // ================== LONGITUD (POST) ==================
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> PulgadasACm(double pulgadas)
        {
            try
            {
                var endpoint = $"{GetBaseUrl()}/pulgadas-a-centimetros?pulgadas={pulgadas}";
                var response = await _httpClient.GetAsync(endpoint);
                
                if (response.IsSuccessStatusCode)
                {
                    var json = await response.Content.ReadAsStringAsync();
                    var result = JsonSerializer.Deserialize<JsonElement>(json);
                    double cm = result.GetProperty("centimetros").GetDouble();
                    
                    ViewBag.Pulgadas = pulgadas;
                    ViewBag.Cm = cm;
                }
                else
                {
                    ViewBag.Error = "Error en la conversión";
                }
            }
            catch (Exception ex)
            {
                ViewBag.Error = $"Error de conexión: {ex.Message}";
            }
            
            return View("Longitud");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> CmAPulgadas(double centimetros)
        {
            try
            {
                var endpoint = $"{GetBaseUrl()}/centimetros-a-pulgadas?centimetros={centimetros}";
                var response = await _httpClient.GetAsync(endpoint);
                
                if (response.IsSuccessStatusCode)
                {
                    var json = await response.Content.ReadAsStringAsync();
                    var result = JsonSerializer.Deserialize<JsonElement>(json);
                    double pulg = result.GetProperty("pulgadas").GetDouble();
                    
                    ViewBag.Centimetros = centimetros;
                    ViewBag.PulgadasRes = pulg;
                }
                else
                {
                    ViewBag.Error = "Error en la conversión";
                }
            }
            catch (Exception ex)
            {
                ViewBag.Error = $"Error de conexión: {ex.Message}";
            }
            
            return View("Longitud");
        }

        // ================== MASA (POST) ==================
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> GramosAKg(double gramos)
        {
            try
            {
                var endpoint = $"{GetBaseUrl()}/gramos-a-kilogramos?gramos={gramos}";
                var response = await _httpClient.GetAsync(endpoint);
                
                if (response.IsSuccessStatusCode)
                {
                    var json = await response.Content.ReadAsStringAsync();
                    var result = JsonSerializer.Deserialize<JsonElement>(json);
                    double kg = result.GetProperty("kilogramos").GetDouble();
                    
                    ViewBag.Gramos = gramos;
                    ViewBag.Kg = kg;
                }
                else
                {
                    ViewBag.Error = "Error en la conversión";
                }
            }
            catch (Exception ex)
            {
                ViewBag.Error = $"Error de conexión: {ex.Message}";
            }
            
            return View("Masa");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> KgAGramos(double kilogramos)
        {
            try
            {
                var endpoint = $"{GetBaseUrl()}/kilogramos-a-gramos?kilogramos={kilogramos}";
                var response = await _httpClient.GetAsync(endpoint);
                
                if (response.IsSuccessStatusCode)
                {
                    var json = await response.Content.ReadAsStringAsync();
                    var result = JsonSerializer.Deserialize<JsonElement>(json);
                    double g = result.GetProperty("gramos").GetDouble();
                    
                    ViewBag.Kilogramos = kilogramos;
                    ViewBag.GramosRes = g;
                }
                else
                {
                    ViewBag.Error = "Error en la conversión";
                }
            }
            catch (Exception ex)
            {
                ViewBag.Error = $"Error de conexión: {ex.Message}";
            }
            
            return View("Masa");
        }

        // ================== TEMPERATURA (POST) ==================
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> C2K(double celsius)
        {
            try
            {
                var endpoint = $"{GetBaseUrl()}/celsius-a-kelvin?celsius={celsius}";
                var response = await _httpClient.GetAsync(endpoint);
                
                if (response.IsSuccessStatusCode)
                {
                    var json = await response.Content.ReadAsStringAsync();
                    var result = JsonSerializer.Deserialize<JsonElement>(json);
                    double k = result.GetProperty("kelvin").GetDouble();
                    
                    ViewBag.Temp = $"{celsius} °C = {k} K";
                }
                else
                {
                    ViewBag.Error = "Error en la conversión";
                }
            }
            catch (Exception ex)
            {
                ViewBag.Error = $"Error de conexión: {ex.Message}";
            }
            
            return View("Temperatura");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> K2C(double kelvin)
        {
            try
            {
                var endpoint = $"{GetBaseUrl()}/kelvin-a-celsius?kelvin={kelvin}";
                var response = await _httpClient.GetAsync(endpoint);
                
                if (response.IsSuccessStatusCode)
                {
                    var json = await response.Content.ReadAsStringAsync();
                    var result = JsonSerializer.Deserialize<JsonElement>(json);
                    double c = result.GetProperty("celsius").GetDouble();
                    
                    ViewBag.Temp = $"{kelvin} K = {c} °C";
                }
                else
                {
                    ViewBag.Error = "Error en la conversión";
                }
            }
            catch (Exception ex)
            {
                ViewBag.Error = $"Error de conexión: {ex.Message}";
            }
            
            return View("Temperatura");
        }
    }
}
