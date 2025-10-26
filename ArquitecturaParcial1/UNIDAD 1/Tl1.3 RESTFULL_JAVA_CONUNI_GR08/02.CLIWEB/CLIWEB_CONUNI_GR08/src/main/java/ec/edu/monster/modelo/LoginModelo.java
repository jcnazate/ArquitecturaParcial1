/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.modelo;
import java.io.IOException;
import ec.edu.monster.utils.RestClient;

/**
 *
 * @author crist
 */
public class LoginModelo {
    private String usuario;
    private String password;
    private boolean autenticado;
    
    public LoginModelo() {
        this.autenticado = false;
    }
    
    public LoginModelo(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        this.autenticado = false;
    }
    
    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isAutenticado() {
        return autenticado;
    }
    
    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
    
    /**
     * Valida las credenciales del usuario usando el servicio REST
     * @return true si las credenciales son válidas
     * @throws IOException si hay error de conexión con el servicio REST
     */
    public boolean validarCredenciales() throws IOException {
        // Usar únicamente el servicio REST para validar las credenciales
        boolean resultado = RestClient.login(usuario, password);
        this.autenticado = resultado;
        return resultado;
    }
}
