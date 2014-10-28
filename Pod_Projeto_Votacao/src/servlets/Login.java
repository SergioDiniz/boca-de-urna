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
        Socket socket = new Socket("localhost", 10001);
        byte[] dados = null;
        
        User usuario = new User();
        usuario.setEmail(request.getParameter("email"));
        
        try{
            dados = ConvertUser.ObjXml(usuario);
        } catch (JAXBException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        socket.getOutputStream().write(dados);
        socket.getOutputStream().flush();
        /*
        InputStream input = socket.getInputStream();
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        byte[] b = new byte[1];
        
        input.read(b);
        temp.write(b);
        
        while(input.read(dados) != -1){
            temp.write(dados);
        }
        
        response.getWriter().print(temp);
        */
        /*
        if(usuario != null){
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);
            response.sendRedirect("votacao.jsp");
            
        }else{
            response.sendRedirect("index.jsp");
        }
        */
        
        socket.getOutputStream().close();
        socket.close();
        
    }
}
