package teste;

import classes.User;
import gerenciador.GerenciadorUsuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 *
 * @author Fatinha de Sousa
 */

public class App {

    public static void main(String [] args) throws UnsupportedEncodingException, SQLException, NoSuchAlgorithmException{
        
       GerenciadorUsuario gerenciador = new GerenciadorUsuario();
       User user = gerenciador.buscarUsuairo("fatinha.sg@hotmail.com");
       
       System.out.println(user.getToken());
       System.out.println(user.getStatus());
    }
}
