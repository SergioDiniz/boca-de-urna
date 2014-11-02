package DataModule;

import ServerModule.Candidate;
import java.util.ArrayList;

/**
 *
 * @author Fatinha de Sousa
 */

public interface CandidatoDaoIT {

    public void atualizaVoto(String numero);
    
    public ArrayList<Candidate> buscarCandidato();
   
    public Candidate buscarCandidato(String numero);
    
}
