using Microsoft.AspNetCore.Mvc.Razor;

var builder = WebApplication.CreateBuilder(args);

// Agregar servicios
builder.Services.AddControllersWithViews();

// Configurar ubicación de vistas
builder.Services.Configure<RazorViewEngineOptions>(options =>
{
    // {1}=Controller, {0}=View
    options.ViewLocationFormats.Add("/ec.edu.monster.vista/{1}/{0}.cshtml");
    options.ViewLocationFormats.Add("/ec.edu.monster.vista/Shared/{0}.cshtml");
});

var app = builder.Build();

// Configurar pipeline HTTP
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();
app.UseRouting();
app.UseAuthorization();

// Configurar rutas
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Auth}/{action=Index}/{id?}");

app.Run();
