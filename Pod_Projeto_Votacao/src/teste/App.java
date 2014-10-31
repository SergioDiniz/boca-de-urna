package teste;

import DataModule.GerenciadorCandidato;
import ServerModule.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 *
 * @author Fatinha de Sousa
 */

public class App {

    public static void main(String [] args) throws UnsupportedEncodingException, SQLException, NoSuchAlgorithmException{
        
        GerenciadorCandidato cand = new GerenciadorCandidato();
        cand.computaVoto("13");
    }
}
