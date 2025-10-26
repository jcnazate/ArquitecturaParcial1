@echo off
echo ========================================
echo PRUEBA DE CONECTIVIDAD DEL SERVIDOR
echo ========================================
echo.

echo 1. Verificando si el servidor esta ejecutandose...
echo URL: http://10.0.2.2:5001/authenticate?user=MONSTER^&password=MONSTER9
echo.

echo 2. Probando con curl (si esta instalado)...
curl -v "http://10.0.2.2:5001/authenticate?user=MONSTER&password=MONSTER9" 2>&1
echo.

echo 3. Probando con PowerShell...
powershell -Command "try { $response = Invoke-WebRequest -Uri 'http://10.0.2.2:5001/authenticate?user=MONSTER&password=MONSTER9' -Method GET; Write-Host 'Status:' $response.StatusCode; Write-Host 'Content:' $response.Content } catch { Write-Host 'Error:' $_.Exception.Message }"
echo.

echo 4. Verificando puerto 5001...
netstat -an | findstr :5001
echo.

echo ========================================
echo INSTRUCCIONES PARA EL SERVIDOR .NET CORE
echo ========================================
echo.
echo Asegurate de que tu servidor este ejecutandose con:
echo   dotnet run --urls="http://localhost:5001"
echo.
echo Si usas IIS Express, habilita acceso externo:
echo   - Ejecuta como administrador
echo   - O configura para escuchar en 0.0.0.0:5001
echo.
echo Para verificar que el servidor responde:
echo   - Abre navegador en: http://localhost:5001/authenticate?user=MONSTER^&password=MONSTER9
echo   - Deberias ver: {"message": "Login exitoso"}
echo.

pause