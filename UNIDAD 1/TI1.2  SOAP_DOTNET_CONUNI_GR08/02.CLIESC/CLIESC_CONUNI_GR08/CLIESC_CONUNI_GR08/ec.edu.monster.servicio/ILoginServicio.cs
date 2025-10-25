using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.servicio
{
    public interface ILoginServicio
    {
        bool ValidarLogin(string username, string password);
        Task<bool> ValidarLoginAsync(string username, string password);
    }
}
