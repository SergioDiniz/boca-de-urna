package DataModule;

import ServerModule.Token;
import ServerModule.User;
import DataModule.UsuarioDao;
import DataModule.UsuarioDaoIT;
import DataModule.FactoryDao;
import DataModule.FactoryDaoIT;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 *
 * @author Fatinha de Sousa
 */

public class GerenciadorUsuario {

    public boolean addUsuario(String email) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        User usuario = new User();
        usuario.setToken(Token.hashMDK5(email));
        usuario.setStatus("F");
        usuario.setEmail(email);
        
        FactoryDaoIT factory = FactoryDao.createFactory();
        UsuarioDaoIT usuer = factory.criarUsuario();
        usuer.persisteUsuario(usuario);
        
        return true;
    }
    
    public User buscarUsuairo(String email) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        UsuarioDaoIT usuario = new UsuarioDao();
        return usuario.buscarUsuario(Token.hashMDK5(email));
    }
    
    public void atualizaStatus(String token) throws SQLException{
        UsuarioDaoIT usuario = new UsuarioDao();
        usuario.atualizaStatus(token);    
    }
}
