package servidor;

import classes.AcessStatus;
import classes.User;
import classes.Vote;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Fatinha de Sousa
 */

public class Cliente {

    public static void main(String [] args) throws IOException, JAXBException, NoSuchAlgorithmException, SQLException{
        
        Socket socket = new Socket("localhost", 10001);
        
        GerenciadorUsuario g = new GerenciadorUsuario();
        User usuario = g.buscarUsuairo("fatinha.sg@hotmail.com");
        
        Vote vote = new Vote();
        vote.setUser(usuario.getToken());
        vote.setCandidate(13);
        
        byte[] dados = VoteXmlConvert.ObjXml(vote);
        socket.getOutputStream().write(dados);
        
        socket.getOutputStream().close();
        socket.close();
        
        System.out.println("Envio Finalizado! ");
    }
}
