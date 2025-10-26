using Microsoft.AspNetCore.Mvc;
using ServiceReference1; // tu proxy WCF
using System.ServiceModel;

namespace CliWeb_ConUni_GR08.ec.edu.monster.controller
{
    public class ConversionController : Controller
    {
        // --- helper para crear el cliente SOAP ---
        private ConversionUnidadesServicioClient CreateClient() =>
            new ConversionUnidadesServicioClient(
                ConversionUnidadesServicioClient.EndpointConfiguration.BasicHttpBinding_IConversionUnidadesServicio);

        // ================== PÁGINAS (GET) ==================
        [HttpGet]
        public IActionResult Longitud()    => View("Longitud");

        [HttpGet]
        public IActionResult Masa()        => View("Masa");

        [HttpGet]
        public IActionResult Temperatura() => View("Temperatura");

        // ================== LONGITUD (POST) ==================
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> PulgadasACm(double pulgadas)
        {
            using var client = CreateClient();
            double cm = await client.PulgadasACentimetrosAsync(pulgadas);
            ViewBag.Pulgadas = pulgadas;
            ViewBag.Cm = cm;
            return View("Longitud");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> CmAPulgadas(double centimetros)
        {
            using var client = CreateClient();
            double pulg = await client.CentimetrosAPulgadasAsync(centimetros);
            ViewBag.Centimetros = centimetros;
            ViewBag.PulgadasRes = pulg;
            return View("Longitud");
        }

        // ================== MASA (POST) ==================
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> GramosAKg(double gramos)
        {
            using var client = CreateClient();
            double kg = await client.GramosAKilogramosAsync(gramos);
            ViewBag.Gramos = gramos;
            ViewBag.Kg = kg;
            return View("Masa");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> KgAGramos(double kilogramos)
        {
            using var client = CreateClient();
            double g = await client.KilogramosAGramosAsync(kilogramos);
            ViewBag.Kilogramos = kilogramos;
            ViewBag.GramosRes = g;
            return View("Masa");
        }

        // ================== TEMPERATURA (POST) ==================
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> C2K(double celsius)
        {
            using var client = CreateClient();
            double k = await client.CelciusAKelvinAsync(celsius); // (así está escrito en el contrato)
            ViewBag.Temp = $"{celsius} °C = {k} K";
            return View("Temperatura");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> K2C(double kelvin)
        {
            using var client = CreateClient();
            double c = await client.KelvinACelciusAsync(kelvin);
            ViewBag.Temp = $"{kelvin} K = {c} °C";
            return View("Temperatura");
        }
    }
}
