# INSTRUCCIONES PARA CONFIGURAR EL SERVIDOR .NET CORE

## Problema Identificado
El error `EOFException: \n not found: size=0 content=...` indica que:
1. El servidor no está ejecutándose
2. El endpoint `/authenticate` no existe en tu servidor
3. El servidor está rechazando la conexión

## Solución Temporal Implementada
He modificado la aplicación para que:
- Use el endpoint `/pulgadas-a-centimetros` para verificar la conexión
- Omita la autenticación temporalmente
- Vaya directamente al menú principal

## Configuración del Servidor .NET Core

### 1. Asegúrate de que tu servidor esté ejecutándose:
```bash
# En la carpeta de tu proyecto .NET Core:
dotnet run --urls="http://localhost:5001"
```

### 2. Verifica que los endpoints estén disponibles:
- `GET http://localhost:5001/pulgadas-a-centimetros?pulgadas=10`
- `GET http://localhost:5001/centimetros-a-pulgadas?centimetros=25.4`
- `GET http://localhost:5001/kelvin-a-celsius?kelvin=273.15`
- `GET http://localhost:5001/celsius-a-kelvin?celsius=0`
- `GET http://localhost:5001/kilogramos-a-gramos?kilogramos=1`
- `GET http://localhost:5001/gramos-a-kilogramos?gramos=1000`

### 3. Para agregar autenticación (opcional):
Si quieres agregar el endpoint `/authenticate`, agrega esto a tu `ConversionUnidadesController`:

```csharp
[HttpPost("authenticate")]
[Produces("application/json")]
public IActionResult Authenticate([FromBody] LoginRequest request)
{
    // Validación básica (cambia por tu lógica real)
    if (request.Username == "admin" && request.Password == "password")
    {
        return Ok(new { success = true, message = "Login exitoso", token = "fake_token" });
    }
    return Ok(new { success = false, message = "Usuario o contraseña incorrectos" });
}

public class LoginRequest
{
    public string Username { get; set; }
    public string Password { get; set; }
}
```

## Prueba de Conexión
1. Ejecuta tu servidor .NET Core
2. Abre la aplicación Android
3. Ingresa cualquier usuario y contraseña
4. La aplicación verificará la conexión usando el endpoint de conversión
5. Si la conexión es exitosa, accederás al menú principal

## URLs de Prueba
- **Emulador Android**: `http://10.0.2.2:5001/`
- **Dispositivo físico**: `http://TU_IP_REAL:5001/`

## Notas Importantes
- El servidor debe estar ejecutándose en **HTTP** (no HTTPS) para desarrollo
- La aplicación ahora tiene mejor manejo de errores
- Los mensajes de error son más descriptivos
