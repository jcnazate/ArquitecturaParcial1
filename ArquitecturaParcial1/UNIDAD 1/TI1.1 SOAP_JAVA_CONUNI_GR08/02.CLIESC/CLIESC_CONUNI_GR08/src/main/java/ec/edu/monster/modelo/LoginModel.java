/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;
import ec.edu.monster.wsdl.Login;
import ec.edu.monster.wsdl.LoginService;
import ec.edu.monster.wsdl.Login_Service;

/**
 *
 * @author johan
 */
public class LoginModel {
    private final LoginService loginServicio;
    
    public LoginModel() {
        Login_Service loginService = new Login_Service();
        this.loginServicio = loginService.getLoginServicePort();
    }

    // Método para autenticar al usuario
    public boolean autenticar(String usuario, String contraseña) {
        try {
          
            return loginServicio.login(usuario, contraseña);
        } catch (Exception e) {
            throw new RuntimeException("Error al autenticar: " + e.getMessage());
        }
    }
    
}
