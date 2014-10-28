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

    public void computaVoto(int numero) throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        cand.atualizaVoto(numero);
    }
    
    public Candidato buscarCandidato(int numero) throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        return cand.buscarCandidato(numero);
    }
    
    public ArrayList<Candidato> candidatos() throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        ArrayList<Candidato> candidatos = new ArrayList();
        
        candidatos = cand.buscarCandidato();
        
        return candidatos;
    }
}
