package classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
public class User {

    private String email;
    private String status;
    private String token;
    
    public User(){
    
    }
    
    public User(String email, String status, String token) {
        this.status = status;
        this.token = token;
        this.email = email;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
}
