package teste;

import classes.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import gerenciador.*;
/**
 *
 * @author Fatinha de Sousa
 */

public class App {

    public static void main(String [] args) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        
        GerenciadorUsuario gerenciador = new GerenciadorUsuario();
        Usuario usuario = new Usuario();
        usuario = gerenciador.buscarUsuairo("fatinha.sg@HOTMAIL.com", "84fb52b7f25005ee3d0e6e8d09b2a4d6");
        
        System.out.println("Usuario: " +usuario.getEmail());
        System.out.println("Token: " +usuario.getToken());
     }
}
