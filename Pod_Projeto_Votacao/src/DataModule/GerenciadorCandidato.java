package DataModule;

import ServerModule.Candidate;
import DataModule.CandidatoDao;
import DataModule.CandidatoDaoIT;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fatinha de Sousa
 */

public class GerenciadorCandidato {

    public void computaVoto(String numero) throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        cand.atualizaVoto(numero);
    }
    
    public ArrayList<Candidate> candidatos() throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        ArrayList<Candidate> candidatos = new ArrayList<Candidate>();
        
        candidatos = cand.buscarCandidato();
        
        return candidatos;
    }
    
    public float calculaVoto(Candidate candidate) throws SQLException{
        CandidatoDao cand = new CandidatoDao();
        return cand.estatistica(candidate);
    }
    
    public Candidate buscarCandidate(String numero) throws SQLException{
        CandidatoDaoIT candidato = new CandidatoDao();
        return candidato.buscarCandidato(numero);
    }
}
