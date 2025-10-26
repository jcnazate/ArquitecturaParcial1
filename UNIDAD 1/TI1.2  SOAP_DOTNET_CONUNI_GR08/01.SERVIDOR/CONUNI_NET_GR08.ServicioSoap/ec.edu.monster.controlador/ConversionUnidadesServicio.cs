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
    public class ConversionUnidadesServicio : IConversionUnidadesServicio
    {
        private readonly ConversionUnidadesModelo conUniModelo;

        public ConversionUnidadesServicio()
        {
            conUniModelo = new ConversionUnidadesModelo();
        }

        public double PulgadasACentimetros(double pulgadas)
        {
            return conUniModelo.PulgadasACentimetros(pulgadas);
        }

        public double CentimetrosAPulgadas(double centimetros)
        {
            return conUniModelo.CentimetrosAPulgadas(centimetros);
        }
        public double CelciusAKelvin(double celcius)
        {
            return conUniModelo.CelsiusAKelvin(celcius);
        }

        public double KelvinACelcius(double kelvin)
        {
            return conUniModelo.KelvinACelsius(kelvin);
        }

        public double GramosAKilogramos(double gramos)
        {
            return conUniModelo.GramosAKilogramos(gramos);
        }

        public double KilogramosAGramos(double kilogramos)
        {
            return conUniModelo.KilogramosAGramos(kilogramos);
        }
    }
}
