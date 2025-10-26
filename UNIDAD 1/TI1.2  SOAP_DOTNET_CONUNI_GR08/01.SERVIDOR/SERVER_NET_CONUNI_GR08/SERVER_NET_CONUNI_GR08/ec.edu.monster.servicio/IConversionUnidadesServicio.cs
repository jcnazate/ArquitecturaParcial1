using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;

namespace CONUNI_GR08.ec.edu.monster.servicio
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
