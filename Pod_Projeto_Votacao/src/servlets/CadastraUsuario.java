package servlets;

import classes.User;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import servidor.ConvertUser;

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
        
        Socket socket = new Socket("localhost", 10001);
        
        String email = request.getParameter("email");
        
        User user = new User();
        user.setEmail(email);
        
        byte[] dados = null;
        
        try {
            dados = ConvertUser.ObjXml(user);
            response.sendRedirect("index.jsp");
        } catch (JAXBException ex) {
            Logger.getLogger(CadastraUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        socket.getOutputStream().write(dados);
        socket.getOutputStream().flush();
        socket.getOutputStream().close();
        socket.close();
        
    }
}