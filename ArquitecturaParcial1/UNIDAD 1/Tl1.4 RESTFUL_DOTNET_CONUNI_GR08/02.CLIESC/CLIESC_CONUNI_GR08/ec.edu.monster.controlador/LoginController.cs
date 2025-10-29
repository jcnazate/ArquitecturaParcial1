using CLIESC_CONUNI_GR08.ec.edu.monster.modelo;
using CLIESC_CONUNI_GR08.ec.edu.monster.servicio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.controlador
{
    internal class LoginController
    {
        private readonly LoginServicio _loginServicio;

        public LoginController()
        {
            _loginServicio = new LoginServicio();
        }

        public bool ValidarCredenciales(string username, string password)
        {
            try
            {
                // Ejecutar de forma síncrona para mantener compatibilidad con el formulario
                var task = _loginServicio.AuthenticateAsync(username, password);
                task.Wait(); // Esperar a que termine la tarea asíncrona

                var result = task.Result;
                return result.IsAuthenticated;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public async Task<bool> ValidarCredencialesAsync(string username, string password)
        {
            try
            {
                var result = await _loginServicio.AuthenticateAsync(username, password);
                return result.IsAuthenticated;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public LoginModel ObtenerResultadoLogin(string username, string password)
        {
            try
            {
                var task = _loginServicio.AuthenticateAsync(username, password);
                task.Wait();
                return task.Result;
            }
            catch (Exception ex)
            {
                return new LoginModel(username, password)
                {
                    IsAuthenticated = false,
                    Message = $"Error: {ex.Message}"
                };
            }
        }

        public void Dispose()
        {
            _loginServicio?.Dispose();
        }
    }
}
