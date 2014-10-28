package dao;

import classes.Token;
import classes.User;
import conexaoBanco.ConnectionDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fatinha de Sousa
 */

public class UsuarioDao implements UsuarioDaoIT {
    
    private Connection conn;
    
    public UsuarioDao() throws SQLException{
        this.conn = new ConnectionDao().createConnection();
    }
    
    @Override
    public void persisteUsuario(User usuario) {
       String sql = "insert into Usuario(email, token, status) values(?, ?, ?)";
       
        try {
            PreparedStatement stat = this.conn.prepareCall(sql);
            stat.setString(1, usuario.getEmail());
            stat.setString(2, usuario.getToken());
            stat.setString(3, usuario.getStatus());
            
            stat.execute();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public User buscarUsuario(String token){
        User usuario = new User();
        String sql = "select * from usuario where token = ?";
        
        try {
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, token);
            
            ResultSet rs = stat.executeQuery();
            
            if(rs.next() == true){
                
                usuario.setEmail(rs.getString(1));
                usuario.setToken(rs.getString(2));
                usuario.setStatus(rs.getString(3));
                
            }else{
                usuario = null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
}
