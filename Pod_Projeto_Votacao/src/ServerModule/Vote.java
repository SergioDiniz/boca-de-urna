package ServerModule;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
public class Vote {

    private String user;
    private String value;
    
    public Vote(){
    
    }
    
    public Vote(String user, String value){
        this.user = user;
        this.value = value;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getvalue() {
        return value;
    }

    public void setvalue(String value) {
        this.value = value;
    }
}