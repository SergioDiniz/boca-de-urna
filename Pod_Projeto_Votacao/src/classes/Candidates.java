package classes;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
public class Candidates {

    private String code;
    private String nome;
    private String quantity;
    private float relative;
    
    public Candidates(){
    
    }
    
    public Candidates(String code, String nome, String quantity, float relative){
        this.code = code;
        this.nome = nome;
        this.quantity = quantity;
        this.relative = relative;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public float getRelative() {
        return relative;
    }

    public void setRelative(float relative) {
        this.relative = relative;
    }
    
}
