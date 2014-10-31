package ServerModule;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fatinha de Sousa
 */

@XmlRootElement
public class Report {

    private Candidates candidato;
    private Candidates candidato1;
    
    
    public Report(){
    
    }
    
    public Report(Candidates candidato, Candidates candidato1){
        this.candidato = candidato;
        this.candidato1 = candidato1;
    }

    public Candidates getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidates candidato) {
        this.candidato = candidato;
    }

    public Candidates getCandidato1() {
        return candidato1;
    }

    public void setCandidato1(Candidates candidato1) {
        this.candidato1 = candidato1;
    }
    
}
