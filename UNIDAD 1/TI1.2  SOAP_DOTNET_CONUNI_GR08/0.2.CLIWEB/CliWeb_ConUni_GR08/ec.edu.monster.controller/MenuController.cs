using Microsoft.AspNetCore.Mvc;

namespace CliWeb_ConUni_GR08.ec.edu.monster.controller
{
    public class MenuController : Controller
    {
        [HttpGet]
        public IActionResult Index() => View();
    }
}
