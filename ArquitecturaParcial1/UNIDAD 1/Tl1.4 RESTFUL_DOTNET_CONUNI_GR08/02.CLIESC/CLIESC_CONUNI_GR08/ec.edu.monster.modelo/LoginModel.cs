using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.modelo
{
    internal class LoginModel
    {
        public string Username { get; set; }
        public string Password { get; set; }
        public bool IsAuthenticated { get; set; }
        public string Message { get; set; }

        public LoginModel()
        {
            Username = string.Empty;
            Password = string.Empty;
            IsAuthenticated = false;
            Message = string.Empty;
        }

        public LoginModel(string username, string password)
        {
            Username = username;
            Password = password;
            IsAuthenticated = false;
            Message = string.Empty;
        }
    }
}
