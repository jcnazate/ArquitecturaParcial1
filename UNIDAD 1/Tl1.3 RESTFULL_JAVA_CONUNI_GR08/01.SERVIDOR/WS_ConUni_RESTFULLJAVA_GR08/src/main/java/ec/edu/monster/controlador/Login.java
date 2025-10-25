/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ec.edu.monster.controlador;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author JOHAN
 */
@Path("generic")
@RequestScoped
public class Login {
    @Context
    private UriInfo context;
    
    // Datos de usuario para pruebas (luego deberían venir de una base de datos)
    private static final String USUARIO_CORRECTO = "MONSTER";
    private static final String PASSWORD_CORRECTO = "MONSTER9";

    public Login() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getStatus() {
        return "¡API de Login está funcionando!";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(
            @FormParam("username") String username,
            @FormParam("password") String password) {
        
        // Validar que se recibieron datos
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: Usuario y contraseña son obligatorios")
                    .build();
        }

        // Validar que las credenciales sean correctas
        if (!USUARIO_CORRECTO.equals(username)) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Error: Usuario no existe")
                    .build();
        }

        if (!PASSWORD_CORRECTO.equals(password)) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Error: Contraseña incorrecta")
                    .build();
        }

        // Si llegamos aquí, las credenciales son correctas
        return Response.ok("¡Inicio de sesión exitoso!").build();
    }

}
