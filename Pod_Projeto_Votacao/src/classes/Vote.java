package classes;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
public class Vote {

    private String user;
    private int candidate;
    
    public Vote(){
    
    }
    
    public Vote(String user, int candidate){
        this.user = user;
        this.candidate = candidate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public int getCandidate() {
        return candidate;
    }

    public void setCandidate(int candidate) {
        this.candidate = candidate;
    }
}