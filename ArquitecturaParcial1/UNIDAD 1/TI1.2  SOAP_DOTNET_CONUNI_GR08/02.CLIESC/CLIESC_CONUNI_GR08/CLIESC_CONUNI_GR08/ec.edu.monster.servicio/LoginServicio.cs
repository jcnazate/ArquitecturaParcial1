using CLIESC_CONUNI_GR08.ec.edu.monster.servicio;
using CLIESC_CONUNI_GR08.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.servicio
{
    public class LoginServicio : ILoginServicio
    {
        private readonly LoginServicioClient _loginClient;

        public LoginServicio()
        {
            _loginClient = new LoginServicioClient();
        }

        public bool ValidarLogin(string username, string password)
        {
            try
            {
                return _loginClient.Login(username, password);
            }
            catch (Exception ex)
            {
                // Log del error si es necesario
                Console.WriteLine($"Error al validar login: {ex.Message}");
                return false;
            }
        }

        public async Task<bool> ValidarLoginAsync(string username, string password)
        {
            try
            {
                return await _loginClient.LoginAsync(username, password);
            }
            catch (Exception ex)
            {
                // Log del error si es necesario
                Console.WriteLine($"Error al validar login async: {ex.Message}");
                return false;
            }
        }

        public void Dispose()
        {
            _loginClient?.Close();
        }
    }
}
