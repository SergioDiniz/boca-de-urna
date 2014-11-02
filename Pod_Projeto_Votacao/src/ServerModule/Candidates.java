package ServerModule;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
public class Candidates {

    private ArrayList<Candidate> candidate = new ArrayList<Candidate>();

    public Candidates(){}
    
    public Candidates(ArrayList<Candidate> candidate) {
        this.candidate =  candidate;
    }

    public ArrayList<Candidate> getCandidate() {
        return candidate;
    }

    public void setCandidate(ArrayList<Candidate> candidate) {
        this.candidate = candidate;
    }

    public void addCandidate(Candidate candidate){
        this.candidate.add(candidate);
    }
}
