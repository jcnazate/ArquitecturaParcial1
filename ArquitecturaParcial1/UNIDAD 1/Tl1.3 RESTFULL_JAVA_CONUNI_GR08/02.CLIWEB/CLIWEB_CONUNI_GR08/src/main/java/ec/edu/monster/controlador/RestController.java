/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ec.edu.monster.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ec.edu.monster.modelo.ConversionUnidades;
import ec.edu.monster.modelo.LoginModelo;
import ec.edu.monster.utils.RestClient;

/**
 *
 * @author crist
 */
@WebServlet(name = "RestController", urlPatterns = {"/RestController"})
public class RestController extends HttpServlet {

        /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        
        if (action == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        switch (action) {
            case "login":
                procesarLogin(request, response);
                break;
            case "logout":
                procesarLogout(request, response);
                break;
            case "temperatura":
                procesarTemperatura(request, response);
                break;
            case "longitud":
                procesarLongitud(request, response);
                break;
            case "masa":
                procesarMasa(request, response);
                break;
            default:
                response.sendRedirect("login.jsp");
                break;
        }
    }
    
    /**
     * Procesa el login del usuario usando el servicio REST
     */
    private void procesarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("user");
        String password = request.getParameter("password");
        
        try {
            // Usar el servicio REST para validar las credenciales
            boolean loginExitoso = RestClient.login(usuario, password);
            
            if (loginExitoso) {
                HttpSession session = request.getSession();
                session.setAttribute("autenticado", true);
                session.setAttribute("usuario", usuario);
                response.sendRedirect("menu.jsp");
            } else {
                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (IOException e) {
            request.setAttribute("error", "Error al conectar con el servicio de login. Verifique que el servicio REST esté ejecutándose.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    /**
     * Procesa el logout del usuario
     */
    private void procesarLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }
    
    /**
     * Procesa las conversiones de temperatura
     */
    private void procesarTemperatura(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo = request.getParameter("tipo");
        String valorStr = request.getParameter("valor");
        
        try {
            double valor = Double.parseDouble(valorStr);
            double resultado = 0.0;
            
            if ("celsiusAKelvin".equals(tipo)) {
                resultado = RestClient.celsiusAKelvin(valor);
                request.setAttribute("resultadoCToK", String.format("%.2f", resultado));
                request.setAttribute("valorC", valorStr);
            } else if ("kelvinACelsius".equals(tipo)) {
                resultado = RestClient.kelvinACelsius(valor);
                request.setAttribute("resultadoKToC", String.format("%.2f", resultado));
                request.setAttribute("valorK", valorStr);
            }
            
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Por favor ingrese un valor numérico válido");
        } catch (IOException e) {
            request.setAttribute("error", "Error al conectar con el servicio REST: " + e.getMessage());
        }
        
        request.getRequestDispatcher("temperatura.jsp").forward(request, response);
    }
    
    /**
     * Procesa las conversiones de longitud
     */
    private void procesarLongitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo = request.getParameter("tipo");
        String valorStr = request.getParameter("valor");
        
        try {
            double valor = Double.parseDouble(valorStr);
            double resultado = 0.0;
            
            if ("centimetrosAPulgadas".equals(tipo)) {
                resultado = RestClient.centimetrosAPulgadas(valor);
                request.setAttribute("resultadoCmToIn", String.format("%.2f", resultado));
                request.setAttribute("valorCm", valorStr);
            } else if ("pulgadasACentimetros".equals(tipo)) {
                resultado = RestClient.pulgadasACentimetros(valor);
                request.setAttribute("resultadoInToCm", String.format("%.2f", resultado));
                request.setAttribute("valorIn", valorStr);
            }
            
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Por favor ingrese un valor numérico válido");
        } catch (IOException e) {
            request.setAttribute("error", "Error al conectar con el servicio REST: " + e.getMessage());
        }
        
        request.getRequestDispatcher("longitud.jsp").forward(request, response);
    }
    
    /**
     * Procesa las conversiones de masa
     */
    private void procesarMasa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo = request.getParameter("tipo");
        String valorStr = request.getParameter("valor");
        
        try {
            double valor = Double.parseDouble(valorStr);
            double resultado = 0.0;
            
            if ("kilogramosAGramos".equals(tipo)) {
                resultado = RestClient.kilogramosAGramos(valor);
                request.setAttribute("resultadoKgToG", String.format("%.2f", resultado));
                request.setAttribute("valorKg", valorStr);
            } else if ("gramosAKilogramos".equals(tipo)) {
                resultado = RestClient.gramosAKilogramos(valor);
                request.setAttribute("resultadoGToKg", String.format("%.2f", resultado));
                request.setAttribute("valorG", valorStr);
            }
            
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Por favor ingrese un valor numérico válido");
        } catch (IOException e) {
            request.setAttribute("error", "Error al conectar con el servicio REST: " + e.getMessage());
        }
        
        request.getRequestDispatcher("masa.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
