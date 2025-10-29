using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLIESC_CONUNI_GR08.ec.edu.monster.modelo
{
    internal class ConversionModel
    {
        public double Value { get; set; }
        public string FromUnit { get; set; }
        public string ToUnit { get; set; }
        public double Result { get; set; }
        public string ConversionType { get; set; }
        public string Message { get; set; }
        public bool IsSuccess { get; set; }

        public ConversionModel()
        {
            Value = 0.0;
            FromUnit = string.Empty;
            ToUnit = string.Empty;
            Result = 0.0;
            ConversionType = string.Empty;
            Message = string.Empty;
            IsSuccess = false;
        }

        public ConversionModel(double value, string fromUnit, string toUnit, string conversionType)
        {
            Value = value;
            FromUnit = fromUnit;
            ToUnit = toUnit;
            ConversionType = conversionType;
            Result = 0.0;
            Message = string.Empty;
            IsSuccess = false;
        }
    }
}
