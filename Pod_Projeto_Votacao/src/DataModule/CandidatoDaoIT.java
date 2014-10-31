package DataModule;

import ServerModule.Candidates;
import java.util.ArrayList;

/**
 *
 * @author Fatinha de Sousa
 */

public interface CandidatoDaoIT {

    public void atualizaVoto(String numero);
    
    public ArrayList<Candidates> buscarCandidato();
    
}
