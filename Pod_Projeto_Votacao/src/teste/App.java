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
        //gerenciador.addUsuario("fatinha.sg@hotmail.com");
        
        
        Usuario usuario = new Usuario();
        usuario = gerenciador.buscarUsuairo("fatinha.sg@hotmail.com");
        
        if(usuario != null){
            System.out.println("Token: " +usuario.getToken());
        }else{
            System.out.println("Usuario Invalido! ");
        }
     }
}
