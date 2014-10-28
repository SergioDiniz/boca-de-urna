package teste;

import classes.User;
import gerenciador.GerenciadorCandidato;
import gerenciador.GerenciadorUsuario;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;
import org.xml.sax.SAXException;

/**
 *
 * @author Fatinha de Sousa
 */

public class App {

    public static void main(String [] args) throws JAXBException, SAXException, IOException, NoSuchAlgorithmException, SQLException{
     GerenciadorUsuario gu = new GerenciadorUsuario();
     
     gu.addUsuario("fferreira913@gmail.com");
    }

}
