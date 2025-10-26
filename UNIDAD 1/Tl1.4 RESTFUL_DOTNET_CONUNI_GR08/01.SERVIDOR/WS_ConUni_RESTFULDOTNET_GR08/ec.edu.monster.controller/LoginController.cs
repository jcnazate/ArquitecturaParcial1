using Microsoft.AspNetCore.Mvc;
using WS_ConUni_RESTFULDOTNET_GR08.ec.edu.monster.model;

namespace WS_ConUni_RESTFULDOTNET_GR08.ec.edu.monster.controller
{
    public class LoginController : Controller
    {
        private readonly LoginModel _loginModel;

        public LoginController()
        {
            _loginModel = new LoginModel();
        }

        [HttpGet("authenticate")]
        [Produces("application/json")]
        public IActionResult Authenticate([FromQuery] string user, [FromQuery] string password)
        {
            bool isAuthenticated = _loginModel.Login(user, password);
            if (isAuthenticated)
            {
                return Ok(new { message = "Login exitoso" });
            }
            else
            {
                return Unauthorized(new { message = "Usuario o contraseña incorrectos" });
            }
        }
    }
}
