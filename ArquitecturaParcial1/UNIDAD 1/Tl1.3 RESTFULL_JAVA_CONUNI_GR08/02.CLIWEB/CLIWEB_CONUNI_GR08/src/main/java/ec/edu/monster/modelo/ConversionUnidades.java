/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;

/**
 *
 * @author crist
 */
public class ConversionUnidades {
    private double valor;
    private String tipoConversion;
    private double resultado;
    private String unidadOrigen;
    private String unidadDestino;
    
    public ConversionUnidades() {
    }
    
    public ConversionUnidades(double valor, String tipoConversion) {
        this.valor = valor;
        this.tipoConversion = tipoConversion;
    }
    
    // Getters y Setters
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getTipoConversion() {
        return tipoConversion;
    }
    
    public void setTipoConversion(String tipoConversion) {
        this.tipoConversion = tipoConversion;
    }
    
    public double getResultado() {
        return resultado;
    }
    
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    public String getUnidadOrigen() {
        return unidadOrigen;
    }
    
    public void setUnidadOrigen(String unidadOrigen) {
        this.unidadOrigen = unidadOrigen;
    }
    
    public String getUnidadDestino() {
        return unidadDestino;
    }
    
    public void setUnidadDestino(String unidadDestino) {
        this.unidadDestino = unidadDestino;
    }
    
    /**
     * Realiza la conversión según el tipo especificado
     */
    public void realizarConversion() {
        switch (tipoConversion) {
            case "pulgadasACentimetros":
                this.resultado = valor * 2.54;
                this.unidadOrigen = "pulgadas";
                this.unidadDestino = "centímetros";
                break;
            case "centimetrosAPulgadas":
                this.resultado = valor / 2.54;
                this.unidadOrigen = "centímetros";
                this.unidadDestino = "pulgadas";
                break;
            case "kilogramosAGramos":
                this.resultado = valor * 1000.0;
                this.unidadOrigen = "kilogramos";
                this.unidadDestino = "gramos";
                break;
            case "gramosAKilogramos":
                this.resultado = valor / 1000.0;
                this.unidadOrigen = "gramos";
                this.unidadDestino = "kilogramos";
                break;
            case "celsiusAKelvin":
                this.resultado = valor + 273.15;
                this.unidadOrigen = "Celsius";
                this.unidadDestino = "Kelvin";
                break;
            case "kelvinACelsius":
                this.resultado = valor - 273.15;
                this.unidadOrigen = "Kelvin";
                this.unidadDestino = "Celsius";
                break;
            default:
                this.resultado = 0.0;
                break;
        }
    }
}
