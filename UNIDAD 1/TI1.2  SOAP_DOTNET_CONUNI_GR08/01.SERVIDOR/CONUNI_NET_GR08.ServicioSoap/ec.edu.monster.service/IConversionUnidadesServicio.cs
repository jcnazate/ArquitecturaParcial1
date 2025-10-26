using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace CONUNI_NET_GR08.ServicioSoap.ec.edu.monster.service
{
    [ServiceContract]
    public interface IConversionUnidadesServicio
    {
        [OperationContract]
        double PulgadasACentimetros(double pulgadas);

        [OperationContract]
        double CentimetrosAPulgadas(double centimetros);

        [OperationContract]
        double CelciusAKelvin(double celcius);

        [OperationContract]
        double KelvinACelcius(double kelvin);

        [OperationContract]
        double GramosAKilogramos(double gramos);

        [OperationContract]
        double KilogramosAGramos(double kilogramos);
    }
}
