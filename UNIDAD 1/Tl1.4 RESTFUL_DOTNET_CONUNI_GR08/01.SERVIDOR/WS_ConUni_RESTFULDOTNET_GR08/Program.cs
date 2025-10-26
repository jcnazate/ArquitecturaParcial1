var builder = WebApplication.CreateBuilder(args);

// Configurar URLs estáticas y abrir navegador automáticamente
builder.WebHost.UseUrls("http://localhost:5000", "https://localhost:5001");
builder.WebHost.UseStaticWebAssets();

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI(c =>
    {
        c.SwaggerEndpoint("/swagger/v1/swagger.json", "WS_ConUni_RESTFULDOTNET_GR08 v1");
        c.RoutePrefix = "swagger";
    });
}

// Solo usar HTTPS redirection en producción
if (!app.Environment.IsDevelopment())
{
    app.UseHttpsRedirection();
}

app.UseAuthorization();

app.MapControllers();

app.Run();
