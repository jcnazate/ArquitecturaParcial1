using Microsoft.AspNetCore.Mvc;
using System.ServiceModel;
using Referencia_Login; // <- tu Connected Service para Login

namespace CliWeb_ConUni_GR08.ec.edu.monster.controller
{
    public class AuthController : Controller
{
    public IActionResult Index() => View();

    [HttpPost]
    public async Task<IActionResult> Index(string user, string password)
    {
        // Opción A: usar el endpoint que generó la referencia (más simple)
        using var client = new LoginServicioClient(
            LoginServicioClient.EndpointConfiguration.BasicHttpBinding_ILoginServicio);

        // Contrato: bool Login(string user, string password) :contentReference[oaicite:0]{index=0}
        bool ok = await client.LoginAsync(user, password);

        if (!ok)
        {
            ViewData["Error"] = "Usuario o contraseña incorrectos.";
            return View();
        }

        // ✅ Ir al menú
        return RedirectToAction("Index", "Menu");
    }
    }
}
