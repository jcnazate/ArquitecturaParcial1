/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ec.edu.monster.controlador;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.enterprise.context.RequestScoped;

/**
 * REST Web Service
 *
 * @author JOHAN
 */
@Path("conversiones")
@RequestScoped
public class ConversionUnidades{
    
    @Context
    private UriInfo context;
    
    /**
     * Crea una nueva instancia de ConversionUnidadesREST
     */
    public ConversionUnidades() {
    }
    
    /**
     * Convierte pulgadas a centímetros
     * @param pulgadas
     * @return el valor convertido en centímetros
     */
    @GET
    @Path("/pulgadasACentimetros/{pulgadas}")
    @Produces(MediaType.TEXT_PLAIN)
    public double pulgadasACentimetros(@PathParam("pulgadas") double pulgadas) {
        return pulgadas * 2.54;
    }
    
    /**
     * Convierte centímetros a pulgadas
     * @param centimetros
     * @return el valor convertido en pulgadas
     */
    @GET
    @Path("/centimetrosAPulgadas/{centimetros}")
    @Produces(MediaType.TEXT_PLAIN)
    public double centimetrosAPulgadas(@PathParam("centimetros") double centimetros) {
        return centimetros / 2.54;
    }
    
    /**
     * Convierte kilogramos a gramos
     * @param kilogramos
     * @return el valor convertido en gramos
     */
    @GET
    @Path("/kilogramosAGramos/{kilogramos}")
    @Produces(MediaType.TEXT_PLAIN)
    public double kilogramosAGramos(@PathParam("kilogramos") double kilogramos) {
        return kilogramos * 1000.0;
    }
    
    /**
     * Convierte gramos a kilogramos
     * @param gramos
     * @return el valor convertido en kilogramos
     */
    @GET
    @Path("/gramosAKilogramos/{gramos}")
    @Produces(MediaType.TEXT_PLAIN)
    public double gramosAKilogramos(@PathParam("gramos") double gramos) {
        return gramos / 1000.0;
    }
    
    /**
     * Convierte Celsius a Kelvin
     * @param celsius
     * @return el valor convertido en Kelvin
     */
    @GET
    @Path("/celsiusAKelvin/{celsius}")
    @Produces(MediaType.TEXT_PLAIN)
    public double celsiusAKelvin(@PathParam("celsius") double celsius) {
        return celsius + 273.15;
    }
    
    /**
     * Convierte Kelvin a Celsius
     * @param kelvin
     * @return el valor convertido en Celsius
     */
    @GET
    @Path("/kelvinACelsius/{kelvin}")
    @Produces(MediaType.TEXT_PLAIN)
    public double kelvinACelsius(@PathParam("kelvin") double kelvin) {
        return kelvin - 273.15;
    }
}