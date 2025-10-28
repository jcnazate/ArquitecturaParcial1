/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.monster.cliesc_conuni_restjava_gr08;

import ec.edu.monster.controlador.LoginController;
import ec.edu.monster.modelo.LoginModel;
import ec.edu.monster.vista.LoginView;

/**
 *
 * @author jcnaz
 */
public class CLIESC_CONUNI_RESTJAVA_GR08 {

        public static void main(String[] args) {
        // Mostrar la ventana de login primero
        java.awt.EventQueue.invokeLater(() -> {
            LoginView loginView = new LoginView();
            LoginModel loginModel = new LoginModel();
            LoginController loginController = new LoginController(loginView, loginModel);
            loginView.setVisible(true);
        });
        
        // También puedes probar la ventana de conversión
        // java.awt.EventQueue.invokeLater(() -> {
        //     ConversionView conversionView = new ConversionView();
        //     conversionView.setVisible(true);
        // });
    }
}
