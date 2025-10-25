using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.modelo
{
    public class ConversionModel
    {
        public double Value { get; set; }
        public string FromUnit { get; set; }
        public string ToUnit { get; set; }
        public double Result { get; set; }

        public ConversionModel()
        {
        }

        public ConversionModel(double value, string fromUnit, string toUnit)
        {
            Value = value;
            FromUnit = fromUnit;
            ToUnit = toUnit;
            Result = 0.0;
        }
    }

}
