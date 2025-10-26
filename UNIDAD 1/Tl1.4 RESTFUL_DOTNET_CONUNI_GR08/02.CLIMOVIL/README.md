# Cliente Móvil - Conversión de Unidades

## Descripción
Aplicación móvil Android que consume servicios REST para conversión de unidades. Implementa el patrón MVC (Model-View-Controller) y se conecta a un servidor .NET Core.

## Características
- **Conversión de Longitud**: Pulgadas ↔ Centímetros
- **Conversión de Temperatura**: Celsius ↔ Kelvin  
- **Conversión de Masa**: Kilogramos ↔ Gramos
- **Autenticación**: Sistema de login básico
- **Arquitectura MVC**: Separación clara de responsabilidades

## Estructura del Proyecto

### Modelo (Model)
- `ConversionResponse.java`: Modelo para respuestas de conversión
- `LoginResponse.java`: Modelo para respuestas de autenticación
- `ConUniService.java`: Servicio para consumir la API REST

### Vista (View)
- `LoginActivity.java`: Pantalla de inicio de sesión
- `MenuActivity.java`: Menú principal de la aplicación
- `ConversionActivity.java`: Conversión de longitud (pulgadas/centímetros)
- `TemperatureActivity.java`: Conversión de temperatura (Celsius/Kelvin)
- `MassActivity.java`: Conversión de masa (kilogramos/gramos)

### Controlador (Controller)
- `AppController.java`: Controlador principal que maneja la lógica de negocio

### Utilidades (Utils)
- `Constants.java`: Constantes de la aplicación (URLs, timeouts, mensajes)
- `NetworkUtils.java`: Utilidades para verificar conectividad de red

## Configuración

### 1. Servidor REST
Asegúrate de que tu servidor .NET Core esté ejecutándose en:
```
https://localhost:5001/
```

### 2. Endpoints Disponibles
- `GET /pulgadas-a-centimetros?pulgadas={valor}`
- `GET /centimetros-a-pulgadas?centimetros={valor}`
- `GET /kelvin-a-celsius?kelvin={valor}`
- `GET /celsius-a-kelvin?celsius={valor}`
- `GET /kilogramos-a-gramos?kilogramos={valor}`
- `GET /gramos-a-kilogramos?gramos={valor}`
- `POST /authenticate` (con JSON: `{"username":"usuario","password":"contraseña"}`)

### 3. Dependencias
El proyecto incluye las siguientes dependencias en `build.gradle.kts`:
- Gson 2.10.1 (para parsing de JSON)
- OkHttp 4.12.0 (para networking)

### 4. Permisos
El `AndroidManifest.xml` incluye los permisos necesarios:
- `INTERNET`: Para conexiones HTTP/HTTPS
- `ACCESS_NETWORK_STATE`: Para verificar estado de red

## Uso de la Aplicación

1. **Inicio**: La aplicación inicia con la pantalla de login
2. **Autenticación**: Ingresa usuario y contraseña (validación básica)
3. **Menú Principal**: Selecciona el tipo de conversión deseada
4. **Conversiones**: 
   - Ingresa el valor a convertir
   - Presiona el botón de conversión correspondiente
   - El resultado se muestra en tiempo real

## Características Técnicas

### Manejo de Errores
- Validación de entrada de datos
- Verificación de conectividad de red
- Manejo de errores del servidor
- Mensajes de error descriptivos

### Arquitectura
- **Patrón MVC**: Separación clara entre modelo, vista y controlador
- **Threading**: Operaciones de red en hilos secundarios
- **Async/Await**: Manejo asíncrono de operaciones de red

### Validaciones
- Verificación de campos vacíos
- Validación de números válidos
- Verificación de conectividad antes de hacer peticiones

## Notas Importantes

1. **Certificado SSL**: Si usas HTTPS local, asegúrate de que el certificado sea válido o configura la aplicación para aceptar certificados autofirmados.

2. **IP del Servidor**: Si pruebas en un dispositivo físico, cambia `localhost` por la IP real de tu máquina en `Constants.java`.

3. **Firewall**: Asegúrate de que el puerto 5001 esté abierto en tu firewall.

## Desarrollo

### Compilación
```bash
./gradlew assembleDebug
```

### Instalación
```bash
./gradlew installDebug
```

### Testing
La aplicación incluye tests unitarios y de integración básicos.

## Estructura de Respuestas JSON

### Conversión
```json
{
  "centimetros": 25.4,
  "pulgadas": 10.0,
  "kelvin": 273.15,
  "celsius": 0.0,
  "gramos": 1000.0,
  "kilogramos": 1.0
}
```

### Autenticación
```json
{
  "success": true,
  "message": "Login exitoso",
  "token": "jwt_token_here"
}
```
