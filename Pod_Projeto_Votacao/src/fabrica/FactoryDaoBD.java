package fabrica;

import dao.CandidatoDao;
import dao.CandidatoDaoIT;
import dao.UsuarioDao;
import dao.UsuarioDaoIT;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fatinha de Sousa
 */

public class FactoryDaoBD implements FactoryDaoIT{

    private UsuarioDao usuario;
    private CandidatoDao candidato;
    
    @Override
    public UsuarioDaoIT criarUsuario() {
        try {
            usuario = new UsuarioDao();
        } catch (SQLException ex) {
            Logger.getLogger(FactoryDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    @Override
    public CandidatoDaoIT criarCandidato() {
        try {
            candidato = new CandidatoDao();
        } catch (SQLException ex) {
            Logger.getLogger(FactoryDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return candidato;
    }
    
}
