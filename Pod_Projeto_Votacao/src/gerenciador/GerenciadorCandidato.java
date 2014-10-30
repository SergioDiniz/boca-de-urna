package gerenciador;

import classes.Candidates;
import dao.CandidatoDao;
import dao.CandidatoDaoIT;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fatinha de Sousa
 */

public class GerenciadorCandidato {

    public void computaVoto(int numero) throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        cand.atualizaVoto(numero);
    }
    
    public Candidates buscarCandidato(int numero) throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        return cand.buscarCandidato(numero);
    }
    
    public ArrayList<Candidates> candidatos() throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        ArrayList<Candidates> candidatos = new ArrayList();
        
        candidatos = cand.buscarCandidato();
        
        return candidatos;
    }
}
