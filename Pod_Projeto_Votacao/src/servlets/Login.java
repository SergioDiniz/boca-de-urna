package servlets;

import classes.AcessStatus;
import classes.User;
import gerenciador.GerenciadorUsuario;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import servidor.AcessStatusXml;
import servidor.ConvertUser;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, UnsupportedEncodingException{
        
        //Socket socket = new Socket("192.168.0.109", 10001);
        //Socket socket = new Socket("localhost", 10001);
        //byte[] dados = null;
        
        User usuario = new User();
        usuario.setEmail(request.getParameter("email"));
        
        response.getWriter().print("Email: " +usuario.getEmail());
        /*
        try{
            dados = ConvertUser.ObjXml(usuario);
        } catch (JAXBException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        socket.getOutputStream().write(dados);
        socket.getOutputStream().flush();
        
        InputStream input = socket.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        
        input.read(b);
        out.write(b);
        
        response.getWriter().print(out);
        
        socket.getOutputStream().close();
        socket.close();*/
    }
}
