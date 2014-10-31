package DataModule;

import ServerModule.Candidates;
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
    
    public ArrayList<Candidates> candidatos() throws SQLException{
        CandidatoDaoIT cand = new CandidatoDao();
        ArrayList<Candidates> candidatos = new ArrayList<Candidates>();
        
        candidatos = cand.buscarCandidato();
        
        return candidatos;
    }
}
