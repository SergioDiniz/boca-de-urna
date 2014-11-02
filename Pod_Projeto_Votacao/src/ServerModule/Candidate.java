package ServerModule;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
public class Candidate {

    private String code;
    private String name;
    private int quantity;
    private float relative;
    
    public Candidate(){
    
    }
    
    public Candidate(String code, String name, int quantity, float relative){
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.relative = relative;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getRelative() {
        return relative;
    }

    public void setRelative(float relative) {
        this.relative = relative;
    }
    
}
