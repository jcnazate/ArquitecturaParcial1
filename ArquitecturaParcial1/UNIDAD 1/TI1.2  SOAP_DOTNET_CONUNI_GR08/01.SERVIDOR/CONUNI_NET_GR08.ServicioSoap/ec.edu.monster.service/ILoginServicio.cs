using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace CONUNI_NET_GR08.ServicioSoap.ec.edu.monster.service
{
    [ServiceContract]
    public interface ILoginServicio
    {
        [OperationContract]
        bool Login(string user, string password);
    }
}
