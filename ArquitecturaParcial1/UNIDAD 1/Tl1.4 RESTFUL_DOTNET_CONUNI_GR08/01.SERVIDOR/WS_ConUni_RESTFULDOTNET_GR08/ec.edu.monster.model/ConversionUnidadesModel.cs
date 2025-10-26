namespace WS_ConUni_RESTFULDOTNET_GR08.ec.edu.monster.model
{
    public class ConversionUnidadesModel
    {
        public double PulgadasACentimetros(double pulgadas)
        {
            return pulgadas * 2.54;
        }

        public double CentimetrosAPulgadas(double centimetros)
        {
            return centimetros / 2.54;
        }

        public double KelvinACelsius(double kelvin)
        {
            return kelvin - 273.15;
        }

        public double CelsiusAKelvin(double celsius)
        {
            return celsius + 273.15;
        }

        public double KilogramosAGramos(double kilogramos)
        {
            return kilogramos * 1000;
        }

        public double GramosAKilogramos(double gramos)
        {
            return gramos / 1000;
        }

    }
}
