package ec.edu.monster.model;

/**
 * Modelo para las respuestas de conversión de la API
 */
public class ConversionResponse {
    private double centimetros;
    private double pulgadas;
    private double kelvin;
    private double celsius;
    private double gramos;
    private double kilogramos;

    // Constructores
    public ConversionResponse() {}

    public ConversionResponse(double centimetros, double pulgadas, double kelvin, 
                            double celsius, double gramos, double kilogramos) {
        this.centimetros = centimetros;
        this.pulgadas = pulgadas;
        this.kelvin = kelvin;
        this.celsius = celsius;
        this.gramos = gramos;
        this.kilogramos = kilogramos;
    }

    // Getters y Setters
    public double getCentimetros() {
        return centimetros;
    }

    public void setCentimetros(double centimetros) {
        this.centimetros = centimetros;
    }

    public double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getGramos() {
        return gramos;
    }

    public void setGramos(double gramos) {
        this.gramos = gramos;
    }

    public double getKilogramos() {
        return kilogramos;
    }

    public void setKilogramos(double kilogramos) {
        this.kilogramos = kilogramos;
    }

    @Override
    public String toString() {
        return "ConversionResponse{" +
                "centimetros=" + centimetros +
                ", pulgadas=" + pulgadas +
                ", kelvin=" + kelvin +
                ", celsius=" + celsius +
                ", gramos=" + gramos +
                ", kilogramos=" + kilogramos +
                '}';
    }
}
