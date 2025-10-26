using CLIESC_CONUNI_GR08.ec.edu.monster.modelo;
using CLIESC_CONUNI_GR08.ec.edu.monster.servicio;
using System;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.controlador
{
    public class LoginController
    {
        private readonly ILoginServicio _loginServicio;

        public LoginController()
        {
            _loginServicio = new LoginServicio();
        }

        public LoginController(ILoginServicio loginServicio)
        {
            _loginServicio = loginServicio;
        }

        public bool ValidarCredenciales(string usuario, string contrasena)
        {
            if (string.IsNullOrWhiteSpace(usuario) || string.IsNullOrWhiteSpace(contrasena))
            {
                return false;
            }

            return _loginServicio.ValidarLogin(usuario, contrasena);
        }

        public async Task<bool> ValidarCredencialesAsync(string usuario, string contrasena)
        {
            if (string.IsNullOrWhiteSpace(usuario) || string.IsNullOrWhiteSpace(contrasena))
            {
                return false;
            }

            return await _loginServicio.ValidarLoginAsync(usuario, contrasena);
        }

        public LoginModel CrearLoginModel(string usuario, string contrasena)
        {
            var loginModel = new LoginModel
            {
                Usuario = usuario,
                Contrasena = contrasena,
                Autenticado = false
            };

            return loginModel;
        }

        public LoginModel ValidarYActualizarLoginModel(LoginModel loginModel)
        {
            if (loginModel == null)
            {
                return null;
            }

            loginModel.Autenticado = ValidarCredenciales(loginModel.Usuario, loginModel.Contrasena);
            return loginModel;
        }

        public async Task<LoginModel> ValidarYActualizarLoginModelAsync(LoginModel loginModel)
        {
            if (loginModel == null)
            {
                return null;
            }

            loginModel.Autenticado = await ValidarCredencialesAsync(loginModel.Usuario, loginModel.Contrasena);
            return loginModel;
        }
    }
}