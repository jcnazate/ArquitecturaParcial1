/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author crist
 */
public class HashUtil {
    /**
     * Genera un hash SHA-256 de la contraseña
     * @param password contraseña a hashear
     * @return hash de la contraseña
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar hash", e);
        }
    }
    
    /**
     * Verifica si una contraseña coincide con su hash
     * @param password contraseña en texto plano
     * @param hash hash almacenado
     * @return true si coinciden
     */
    public static boolean verifyPassword(String password, String hash) {
        return hashPassword(password).equals(hash);
    }
}
