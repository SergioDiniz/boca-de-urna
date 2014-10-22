package classes;

/**
 *
 * @author Fatinha de Sousa
 */

public class Usuario {

    private int id;
    private boolean status;
    private String token;
    
    public Usuario(){
    
    }
    
    public Usuario(boolean status, String token){
        this.status = status;
        this.token = token;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
