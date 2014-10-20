package fabrica;

import dao.CandidatoDaoIT;
import dao.UsuarioDaoIT;

/**
 *
 * @author Fatinha de Sousa
 */

public interface FactoryDaoIT {

    public UsuarioDaoIT criarUsuario();
    
    public CandidatoDaoIT criarCandidato();
}