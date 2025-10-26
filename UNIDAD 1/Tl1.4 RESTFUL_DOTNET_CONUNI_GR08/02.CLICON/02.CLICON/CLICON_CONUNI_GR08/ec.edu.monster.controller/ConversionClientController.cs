using CLICON_CONUNI_GR08.ec.edu.monster.model;
using CLICON_CONUNI_GR08.ec.edu.monster.view;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CLICON_CONUNI_GR08.ec.edu.monster.controller
{
    internal class ConversionClientController
    {
        private readonly ConversionClientModel _model;
        private readonly ConversionClientView _view;

        public ConversionClientController(ConversionClientModel model, ConversionClientView view)
        {
            _model = model;
            _view = view;
        }

        public async Task StartAsync()
        {
            // Mostrar mensaje de bienvenida
            _view.ShowWelcomeMessage();
            
            // Autenticación
            bool authenticated = false;
            while (!authenticated)
            {
                var (user, password) = _view.GetCredentials();
                try
                {
                    authenticated = await _model.AuthenticateAsync(user, password);
                    if (!authenticated)
                    {
                        _view.ShowLoginError();
                    }
                }
                catch (Exception e)
                {
                    _view.ShowError("Error al conectar con el servidor: " + e.Message);
                    return;
                }
            }

            // Menú principal
            while (true)
            {
                _view.ShowMenu();
                int option = _view.GetMenuOption();
                try
                {
                    switch (option)
                    {
                        case 1:
                            double pulgadas = _view.GetInputValue("pulgadas");
                            if (pulgadas < 0)
                            {
                                _view.ShowError("Las pulgadas no pueden ser negativas.");
                                continue;
                            }
                            double centimetros = await _model.PulgadasACentimetrosAsync(pulgadas);
                            _view.ShowConversionResult("pulgadas", pulgadas, "centímetros", centimetros);
                            break;
                        case 2:
                            double cm = _view.GetInputValue("centímetros");
                            if (cm < 0)
                            {
                                _view.ShowError("Los centímetros no pueden ser negativos.");
                                continue;
                            }
                            double inches = await _model.CentimetrosAPulgadasAsync(cm);
                            _view.ShowConversionResult("centímetros", cm, "pulgadas", inches);
                            break;
                        case 3:
                            double celsius = _view.GetInputValue("celsius");
                            double kelvin = await _model.CelsiusAKelvinAsync(celsius);
                            _view.ShowConversionResult("celsius", celsius, "kelvin", kelvin);
                            break;
                        case 4:
                            double kelvinInput = _view.GetInputValue("kelvin");
                            if (kelvinInput < 0)
                            {
                                _view.ShowError("Los grados Kelvin no pueden ser negativos.");
                                continue;
                            }
                            double celsiusOutput = await _model.KelvinACelsiusAsync(kelvinInput);
                            _view.ShowConversionResult("kelvin", kelvinInput, "celsius", celsiusOutput);
                            break;
                        case 5:
                            double kilogramos = _view.GetInputValue("kilogramos");
                            if (kilogramos < 0)
                            {
                                _view.ShowError("Los kilogramos no pueden ser negativos.");
                                continue;
                            }
                            double gramos = await _model.KilogramosAGramosAsync(kilogramos);
                            _view.ShowConversionResult("kilogramos", kilogramos, "gramos", gramos);
                            break;
                        case 6:
                            double gramosInput = _view.GetInputValue("gramos");
                            if (gramosInput < 0)
                            {
                                _view.ShowError("Los gramos no pueden ser negativos.");
                                continue;
                            }
                            double kilogramosOutput = await _model.GramosAKilogramosAsync(gramosInput);
                            _view.ShowConversionResult("gramos", gramosInput, "kilogramos", kilogramosOutput);
                            break;
                        case 7:
                            _view.ShowGoodbyeMessage();
                            return;
                        default:
                            _view.ShowError("Opción no válida.");
                            break;
                    }
                }
                catch (Exception e)
                {
                    _view.ShowError("Error al procesar la conversión: " + e.Message);
                }
            }
        }
    }
}
