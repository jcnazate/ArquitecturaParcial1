using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.modelo
{
    public class LoginModel
    {
        public string Usuario { get; set; }
        public string Contrasena { get; set; }
        public bool Autenticado { get; set; }

        public LoginModel() { }

        public LoginModel(string usuario, string contrasena)
        {
            Usuario = usuario;
            Contrasena = contrasena;
            Autenticado = false;
        }
    }
}
