using Microsoft.AspNetCore.Mvc;
using WS_ConUni_RESTFULDOTNET_GR08.ec.edu.monster.model;

namespace WS_ConUni_RESTFULDOTNET_GR08.ec.edu.monster.controller
{
    public class ConversionUnidadesController : Controller
    {
        private readonly ConversionUnidadesModel _conUniModel;

        public ConversionUnidadesController()
        {
            _conUniModel = new ConversionUnidadesModel();
        }

        [HttpGet("pulgadas-a-centimetros")]
        [Produces("application/json")]
        public IActionResult PulgadasACentimetros([FromQuery] double pulgadas)
        {
            double centimetros = _conUniModel.PulgadasACentimetros(pulgadas);
            return Ok(new { centimetros });
        }

        [HttpGet("centimetros-a-pulgadas")]
        [Produces("application/json")]
        public IActionResult CentimetrosAPulgadas([FromQuery] double centimetros)
        {
            double pulgadas = _conUniModel.CentimetrosAPulgadas(centimetros);
            return Ok(new { pulgadas });
        }

        [HttpGet("kelvin-a-celsius")]
        [Produces("application/json")]
        public IActionResult KelvinACelsius([FromQuery] double kelvin)
        {
            double celsius = _conUniModel.KelvinACelsius(kelvin);
            return Ok(new { celsius });
        }

        [HttpGet("celsius-a-kelvin")]
        [Produces("application/json")]
        public IActionResult CelsiusAKelvin([FromQuery] double celsius)
        {
            double kelvin = _conUniModel.CelsiusAKelvin(celsius);
            return Ok(new { kelvin });
        }

        [HttpGet("kilogramos-a-gramos")]
        [Produces("application/json")]
        public IActionResult KilogramosAGramos([FromQuery] double kilogramos)
        {
            double gramos = _conUniModel.KilogramosAGramos(kilogramos);
            return Ok(new { gramos });
        }

        [HttpGet("gramos-a-kilogramos")]
        [Produces("application/json")]
        public IActionResult GramosAKilogramos([FromQuery] double gramos)
        {
            double kilogramos = _conUniModel.GramosAKilogramos(gramos);
            return Ok(new { kilogramos });
        }
    }
}
