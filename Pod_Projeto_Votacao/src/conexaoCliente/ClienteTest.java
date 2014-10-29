package conexaoCliente;

import classes.User;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import servidor.ConvertUser;
import servlets.Login;

/**
 *
 * @author Fatinha de Sousa
 */
public class ClienteTest {

    public static void main(String [] args) throws IOException, ClassNotFoundException{
        
        Socket socket = new Socket("localhost", 10011); //faz a conexao na maquina local e com porta = 10001
        socket.getOutputStream().write("Hello World - Fatinha".getBytes()); //
        socket.getOutputStream().flush();//envia
        
        InputStream input = socket.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        
        input.read(b);
        out.write(b);
        
        System.out.println(out);
        socket.getOutputStream().close();
        socket.close();
    }
}