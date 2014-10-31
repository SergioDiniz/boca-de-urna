
package ServerModule;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
public class AcessStatus {
 
    private String access;
    private String status;
    
    public AcessStatus(){
    
    }
    
    public AcessStatus(String access, String status){
        this.access = access;
        this.status = status;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
}
