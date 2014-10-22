package gerenciador;

import classes.Token;
import classes.Usuario;
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

    public void addUsuario(String email) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        Usuario usuario = new Usuario();
        usuario.setToken(Token.hashMDK5(email));
        usuario.setStatus(false);
        
        FactoryDaoIT factory = FactoryDao.createFactory();
        UsuarioDaoIT usuer = factory.criarUsuario();
        usuer.persisteUsuario(usuario);
    }
    
    public Usuario buscarUsuairo(String email) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        UsuarioDaoIT usuario = new UsuarioDao();
        return usuario.buscarUsuario(Token.hashMDK5(email));
    }
}
