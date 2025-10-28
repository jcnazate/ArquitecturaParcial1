/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.vista.TemperaturaView;
import ec.edu.monster.vista.LongitudView;
import ec.edu.monster.vista.MasaView;
import ec.edu.monster.modelo.ConversionModelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author johan
 */
public class ConversionController {
    private final ConversionModelo model;
    private TemperaturaView temperaturaView;
    private LongitudView longitudView;
    private MasaView masaView;

    // Constructor para TemperaturaView
    public ConversionController(ConversionModelo model, TemperaturaView view) {
        this.model = model;
        this.temperaturaView = view;
        this.longitudView = null;
        initTemperaturaController();
    }

    // Constructor para LongitudView
    public ConversionController(ConversionModelo model, LongitudView view) {
        this.model = model;
        this.temperaturaView = null;
        this.longitudView = view;
        this.masaView = null;
        initLongitudController();
    }

    // Constructor para MasaView
    public ConversionController(ConversionModelo model, MasaView view) {
        this.model = model;
        this.temperaturaView = null;
        this.longitudView = null;
        this.masaView = view;
        initMasaController();
    }

    private void initTemperaturaController() {
        // Botón para convertir Kelvin a Celsius
        temperaturaView.getBtnConvertir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleKelvinToCelsiusConversion();
            }
        });
        
        // Botón para convertir Celsius a Kelvin
        temperaturaView.getBtnConvertir1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCelsiusToKelvinConversion();
            }
        });
    }

    private void initLongitudController() {
        // Botón para convertir Centímetros a Pulgadas
        longitudView.getBtnConvertir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCentimetrosToPulgadasConversion();
            }
        });
        
        // Botón para convertir Pulgadas a Centímetros
        longitudView.getBtnConvertir1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePulgadasToCentimetrosConversion();
            }
        });
    }

    private void initMasaController() {
        // Botón para convertir Gramos a Kilogramos
        masaView.getBtnConvertir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGramosToKilogramosConversion();
            }
        });
        
        // Botón para convertir Kilogramos a Gramos
        masaView.getBtnConvertir1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleKilogramosToGramosConversion();
            }
        });
    }

    private void handleKelvinToCelsiusConversion() {
        try {
            String input = temperaturaView.getTxtKelvin().getText().trim();
            if (input.isEmpty()) {
                temperaturaView.getLblCelsius().setText("Ingrese un valor");
                temperaturaView.getLblKelvin().setText("");
                return;
            }

            // Reemplazar comas por puntos para evitar problemas de formato
            input = input.replace(',', '.');

            double kelvin = Double.parseDouble(input);
            if (kelvin < 0) {
                temperaturaView.getLblCelsius().setText("El valor no puede ser negativo");
                temperaturaView.getLblKelvin().setText("");
                return;
            }

            // Establecer el valor de Kelvin en el label
            temperaturaView.getLblKelvin().setText(String.format("%.2f", kelvin));
            
            // Convertir Kelvin a Celsius
            double celsius = model.kelvinACelsius(kelvin);
            temperaturaView.getLblCelsius().setText(String.format("%.2f", celsius));
            
        } catch (NumberFormatException ex) {
            temperaturaView.getLblCelsius().setText("Ingrese un valor numérico válido");
            temperaturaView.getLblKelvin().setText("");
        } catch (RuntimeException ex) {
            temperaturaView.getLblCelsius().setText("Error: " + ex.getMessage());
            temperaturaView.getLblKelvin().setText("");
        }
    }

    private void handleCelsiusToKelvinConversion() {
        try {
            String input = temperaturaView.getTxtCelsius().getText().trim();
            if (input.isEmpty()) {
                temperaturaView.getLblKelvin1().setText("Ingrese un valor");
                temperaturaView.getLblCelsius1().setText("");
                return;
            }

            // Reemplazar comas por puntos para evitar problemas de formato
            input = input.replace(',', '.');

            double celsius = Double.parseDouble(input);
            if (celsius < -273.15) {
                temperaturaView.getLblKelvin1().setText("Temperatura bajo cero absoluto");
                temperaturaView.getLblCelsius1().setText("");
                return;
            }

            // Establecer el valor de Celsius en el label
            temperaturaView.getLblCelsius1().setText(String.format("%.2f", celsius));
            
            // Convertir Celsius a Kelvin
            double kelvin = model.celsiusAKelvin(celsius);
            temperaturaView.getLblKelvin1().setText(String.format("%.2f", kelvin));
            
        } catch (NumberFormatException ex) {
            temperaturaView.getLblKelvin1().setText("Ingrese un valor numérico válido");
            temperaturaView.getLblCelsius1().setText("");
        } catch (RuntimeException ex) {
            temperaturaView.getLblKelvin1().setText("Error: " + ex.getMessage());
            temperaturaView.getLblCelsius1().setText("");
        }
    }

    private void handleCentimetrosToPulgadasConversion() {
        try {
            String input = longitudView.getTxtCentimetros().getText().trim();
            if (input.isEmpty()) {
                longitudView.getLblPulgadas().setText("Ingrese un valor");
                longitudView.getLblCentimetros().setText("");
                return;
            }

            // Reemplazar comas por puntos para evitar problemas de formato
            input = input.replace(',', '.');

            double centimetros = Double.parseDouble(input);
            if (centimetros < 0) {
                longitudView.getLblPulgadas().setText("El valor no puede ser negativo");
                longitudView.getLblCentimetros().setText("");
                return;
            }

            // Establecer el valor de Centímetros en el label
            longitudView.getLblCentimetros().setText(String.format("%.2f", centimetros));
            
            // Convertir Centímetros a Pulgadas
            double pulgadas = model.centimetrosAPulgadas(centimetros);
            longitudView.getLblPulgadas().setText(String.format("%.2f", pulgadas));
            
        } catch (NumberFormatException ex) {
            longitudView.getLblPulgadas().setText("Ingrese un valor numérico válido");
            longitudView.getLblCentimetros().setText("");
        } catch (RuntimeException ex) {
            longitudView.getLblPulgadas().setText("Error: " + ex.getMessage());
            longitudView.getLblCentimetros().setText("");
        }
    }

    private void handlePulgadasToCentimetrosConversion() {
        try {
            String input = longitudView.getTxtPulgadas().getText().trim();
            if (input.isEmpty()) {
                longitudView.getLblCentimetros1().setText("Ingrese un valor");
                longitudView.getLblPulgadas1().setText("");
                return;
            }

            // Reemplazar comas por puntos para evitar problemas de formato
            input = input.replace(',', '.');

            double pulgadas = Double.parseDouble(input);
            if (pulgadas < 0) {
                longitudView.getLblCentimetros1().setText("El valor no puede ser negativo");
                longitudView.getLblPulgadas1().setText("");
                return;
            }

            // Establecer el valor de Pulgadas en el label
            longitudView.getLblPulgadas1().setText(String.format("%.2f", pulgadas));
            
            // Convertir Pulgadas a Centímetros
            double centimetros = model.pulgadasACentimetros(pulgadas);
            longitudView.getLblCentimetros1().setText(String.format("%.2f", centimetros));
            
        } catch (NumberFormatException ex) {
            longitudView.getLblCentimetros1().setText("Ingrese un valor numérico válido");
            longitudView.getLblPulgadas1().setText("");
        } catch (RuntimeException ex) {
            longitudView.getLblCentimetros1().setText("Error: " + ex.getMessage());
            longitudView.getLblPulgadas1().setText("");
        }
    }

    private void handleGramosToKilogramosConversion() {
        try {
            String input = masaView.getTxtGramos().getText().trim();
            if (input.isEmpty()) {
                masaView.getLblKg().setText("Ingrese un valor");
                masaView.getLblGramos().setText("");
                return;
            }

            // Reemplazar comas por puntos para evitar problemas de formato
            input = input.replace(',', '.');

            double gramos = Double.parseDouble(input);
            if (gramos < 0) {
                masaView.getLblKg().setText("El valor no puede ser negativo");
                masaView.getLblGramos().setText("");
                return;
            }

            // Establecer el valor de Gramos en el label
            masaView.getLblGramos().setText(String.format("%.2f", gramos));
            
            // Convertir Gramos a Kilogramos
            double kilogramos = model.gramosAKilogramos(gramos);
            masaView.getLblKg().setText(String.format("%.2f", kilogramos));
            
        } catch (NumberFormatException ex) {
            masaView.getLblKg().setText("Ingrese un valor numérico válido");
            masaView.getLblGramos().setText("");
        } catch (RuntimeException ex) {
            masaView.getLblKg().setText("Error: " + ex.getMessage());
            masaView.getLblGramos().setText("");
        }
    }

    private void handleKilogramosToGramosConversion() {
        try {
            String input = masaView.getTxtKg().getText().trim();
            if (input.isEmpty()) {
                masaView.getLblGramos1().setText("Ingrese un valor");
                masaView.getLblKg1().setText("");
                return;
            }

            // Reemplazar comas por puntos para evitar problemas de formato
            input = input.replace(',', '.');

            double kilogramos = Double.parseDouble(input);
            if (kilogramos < 0) {
                masaView.getLblGramos1().setText("El valor no puede ser negativo");
                masaView.getLblKg1().setText("");
                return;
            }

            // Establecer el valor de Kilogramos en el label
            masaView.getLblKg1().setText(String.format("%.2f", kilogramos));
            
            // Convertir Kilogramos a Gramos
            double gramos = model.kilogramosAGramos(kilogramos);
            masaView.getLblGramos1().setText(String.format("%.2f", gramos));
            
        } catch (NumberFormatException ex) {
            masaView.getLblGramos1().setText("Ingrese un valor numérico válido");
            masaView.getLblKg1().setText("");
        } catch (RuntimeException ex) {
            masaView.getLblGramos1().setText("Error: " + ex.getMessage());
            masaView.getLblKg1().setText("");
        }
    }
}
