package servlets;

import classes.Usuario;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fatinha de Sousa
 */

public class Login extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        GerenciadorUsuario gerenciador = new GerenciadorUsuario();
        Usuario usuario = new Usuario();
        
        try {
            usuario = gerenciador.buscarUsuairo(request.getParameter("email"), request.getParameter("token"));
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(usuario != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);
            
            response.sendRedirect("paginaInicial.jsp");
        }else{
            response.sendRedirect("login.html");
        }
    }
    
}
