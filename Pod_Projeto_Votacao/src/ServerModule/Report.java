package ServerModule;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name= "", propOrder = {"created", "candidates"})
    
public class Report {
    
    @XmlElement(name="created")
    private Date created;
    
    @XmlElement(name="candidates")
    private Candidates candidates;
    
    public Report(){}

    public Report(Candidates Candidates) {
        this.created = new Date();
        this.candidates = Candidates;
    }
    

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Candidates getCandidates() {
        return candidates;
    }

    public void setCandidates(Candidates Candidates) {
        this.candidates = Candidates;
    }
        
}
