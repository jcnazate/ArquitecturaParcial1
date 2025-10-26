using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using CONUNI_NET_GR08.ServicioSoap.ec.edu.monster.modelo;
using CONUNI_NET_GR08.ServicioSoap.ec.edu.monster.service;

namespace CONUNI_NET_GR08.ServicioSoap.ec.edu.monster.service
{
    public class LoginServicio : ILoginServicio
    {
        private readonly LoginModelo loginModelo;

        public LoginServicio()
        {
            loginModelo = new LoginModelo();
        }

        public bool Login(string user, string password)
        {
            return loginModelo.Login(user, password);
        }
    }
}
