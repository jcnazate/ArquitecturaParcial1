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
    internal class LoginServicio
    {
        private readonly HttpClient _httpClient;
        private readonly string _baseUrl;

        public LoginServicio()
        {
            _httpClient = new HttpClient();
            _baseUrl = "http://localhost:5000"; // URL base del servicio REST
        }

        public async Task<LoginModel> AuthenticateAsync(string username, string password)
        {
            try
            {
                var loginModel = new LoginModel(username, password);

                // Construir la URL con parámetros de consulta
                var url = $"{_baseUrl}/authenticate?user={Uri.EscapeDataString(username)}&password={Uri.EscapeDataString(password)}";

                // Configurar timeout de 10 segundos
                _httpClient.Timeout = TimeSpan.FromSeconds(10);

                var response = await _httpClient.GetAsync(url);
                var content = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<dynamic>(content);
                    loginModel.IsAuthenticated = true;
                    loginModel.Message = result?.message ?? "Login exitoso";
                }
                else
                {
                    var errorResult = JsonConvert.DeserializeObject<dynamic>(content);
                    loginModel.IsAuthenticated = false;
                    loginModel.Message = errorResult?.message ?? $"Error de autenticación (HTTP {response.StatusCode})";
                }

                return loginModel;
            }
            catch (HttpRequestException ex)
            {
                return new LoginModel(username, password)
                {
                    IsAuthenticated = false,
                    Message = $"Error de conexión HTTP: {ex.Message}\n\nVerifique que el servicio REST esté ejecutándose en {_baseUrl}"
                };
            }
            catch (TaskCanceledException ex)
            {
                return new LoginModel(username, password)
                {
                    IsAuthenticated = false,
                    Message = $"Timeout de conexión: {ex.Message}\n\nEl servicio no respondió en el tiempo esperado."
                };
            }
            catch (Exception ex)
            {
                return new LoginModel(username, password)
                {
                    IsAuthenticated = false,
                    Message = $"Error inesperado: {ex.Message}"
                };
            }
        }

        public void Dispose()
        {
            _httpClient?.Dispose();
        }
    }
}
