package dao;

import classes.Candidato;
import java.util.ArrayList;

/**
 *
 * @author Fatinha de Sousa
 */

public interface CandidatoDaoIT {

    public void atualizaVoto(Candidato candidato);
    
    public ArrayList<Candidato> buscarCandidato();
    
    public Candidato buscarCandidato(int id);
    
}
