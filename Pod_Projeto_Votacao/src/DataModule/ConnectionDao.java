package DataModule;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Fatinha de Sousa
 */
public class ConnectionDao {

    private final String url = "jdbc:postgresql://localhost:5432/POD_PROJETO";
    private final String username = "postgres";
    private final String password = "12345";
            
    public Connection createConnection() throws SQLException{
        DriverManager.registerDriver(new org.postgresql.Driver());
        
        Connection conn = DriverManager.getConnection(url, username, password);
        
        return conn;
    }
}
