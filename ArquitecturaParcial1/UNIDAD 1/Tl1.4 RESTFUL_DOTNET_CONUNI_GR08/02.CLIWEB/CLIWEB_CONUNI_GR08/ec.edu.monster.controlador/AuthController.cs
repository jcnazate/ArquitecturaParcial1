using Microsoft.AspNetCore.Mvc;
using System.Text.Json;

namespace CliWeb_ConUni_GR08.ec.edu.monster.controller
{
    public class AuthController : Controller
    {
        private readonly HttpClient _httpClient;
        private readonly IConfiguration _configuration;

        public AuthController(HttpClient httpClient, IConfiguration configuration)
        {
            _httpClient = httpClient;
            _configuration = configuration;
        }

        public IActionResult Index() => View();

        [HttpPost]
        public async Task<IActionResult> Index(string user, string password)
        {
            try
            {
                // URL del servicio REST
                var baseUrl = _configuration["RestService:BaseUrl"] ?? "https://localhost:5001";
                var endpoint = $"{baseUrl}/authenticate?user={Uri.EscapeDataString(user)}&password={Uri.EscapeDataString(password)}";

                var response = await _httpClient.GetAsync(endpoint);

                if (response.IsSuccessStatusCode)
                {
                    // Login exitoso
                    return RedirectToAction("Index", "Menu");
                }
                else
                {
                    ViewData["Error"] = "Usuario o contraseña incorrectos.";
                    return View();
                }
            }
            catch (Exception ex)
            {
                ViewData["Error"] = $"Error de conexión: {ex.Message}";
                return View();
            }
        }
    }
}
