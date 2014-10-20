package gerenciador;

import classes.Candidato;
import dao.CandidatoDao;
import dao.CandidatoDaoIT;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fatinha de Sousa
 */

public class GerenciadorCandidato {

    public void computaVoto(Candidato candidato) throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        cand.atualizaVoto(candidato);
    }
    
    public Candidato buscarCandidato(int id) throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        return cand.buscarCandidato(id);
    }
    
    public ArrayList<Candidato> candidatos() throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        ArrayList<Candidato> candidatos = new ArrayList();
        
        candidatos = cand.buscarCandidato();
        
        return candidatos;
    }
}
