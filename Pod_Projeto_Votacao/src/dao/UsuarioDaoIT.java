package dao;

import classes.User;

/**
 *
 * @author Fatinha de Sousa
 */

public interface UsuarioDaoIT {

    public void persisteUsuario(User usuario);
    
    public User buscarUsuario(String token);
    
}
