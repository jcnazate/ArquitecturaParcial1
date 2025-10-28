/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.controlador;

import ec.edu.monster.vista.TemperaturaView;
import ec.edu.monster.vista.LoginView;
import ec.edu.monster.vista.MenuView;
import ec.edu.monster.modelo.ConversionModelo;
import ec.edu.monster.modelo.LoginModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author johan
 */
public class LoginController {
    private final LoginView loginView;
    private final LoginModel loginModel;

    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;

        // Asignar el ActionListener al botón de login
        this.loginView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });
    }

    private void authenticate() {
        String username = loginView.getUsernameField().getText();
        String password = new String(loginView.getPasswordField().getPassword());

        try {
            // Intentar autenticación usando el modelo
            if (loginModel.autenticar(username, password)) {
               loginView.dispose(); // Cerrar la ventana de login
                // Abrir la ventana de conversión
                MenuView menuView = new MenuView();               
                menuView.setVisible(true);
            } else {
                loginView.getMessageLabel().setText("Usuario o contraseña incorrectos");
            }
        } catch (RuntimeException e) {
            loginView.getMessageLabel().setText("Error al autenticar: " + e.getMessage());
        }
    }
}
