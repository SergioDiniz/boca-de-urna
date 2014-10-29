package servidor;

import classes.AcessStatus;
import classes.User;
import classes.Vote;
import gerenciador.GerenciadorCandidato;
import gerenciador.GerenciadorUsuario;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Fatinha de Sousa
 */

public class Servidor {

    public static void main(String [] args) throws IOException, JAXBException, NoSuchAlgorithmException, SQLException{
        
        ServerSocket server = new ServerSocket(10001);
        System.out.println("Aguardando Conexao...");
        Socket socket = server.accept();
        System.out.println("Conexao Realizada...");
        
        InputStream in = socket.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        
        in.read(b);
        out.write(b);
        
        socket.getOutputStream().write("Cadastro Efetuado com Sucesso...".getBytes());
        socket.getOutputStream().close();
        
        out.writeTo(System.out);
        out.close();
        in.close();
        socket.close();
        server.close();
    }
}