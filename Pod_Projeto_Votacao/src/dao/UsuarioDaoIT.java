package dao;

import classes.Usuario;

/**
 *
 * @author Fatinha de Sousa
 */

public interface UsuarioDaoIT {

    public void persisteUsuario(Usuario usuario);
    
    public Usuario buscarUsuario(String email, String token);
    
}
