package gerenciador;

import classes.Token;
import classes.User;
import dao.UsuarioDao;
import dao.UsuarioDaoIT;
import fabrica.FactoryDao;
import fabrica.FactoryDaoIT;
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
}
