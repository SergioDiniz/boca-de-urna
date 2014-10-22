package servlets;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gerenciador.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fatinha de Sousa
 */

public class CadastraUsuario extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, 
            UnsupportedEncodingException{
        
        String email = request.getParameter("email");
        GerenciadorUsuario gerenciador = new GerenciadorUsuario();
        
        try {
            gerenciador.addUsuario(email);
            response.sendRedirect("login.html");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CadastraUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
