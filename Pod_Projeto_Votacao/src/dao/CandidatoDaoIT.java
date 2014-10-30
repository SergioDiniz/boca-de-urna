package dao;

import classes.Candidates;
import java.util.ArrayList;

/**
 *
 * @author Fatinha de Sousa
 */

public interface CandidatoDaoIT {

    public void atualizaVoto(int numero);
    
    public ArrayList<Candidates> buscarCandidato();
    
    public Candidates buscarCandidato(int id);
    
}
