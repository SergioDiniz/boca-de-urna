package DataModule;

import DataModule.CandidatoDaoIT;
import DataModule.UsuarioDaoIT;

/**
 *
 * @author Fatinha de Sousa
 */

public interface FactoryDaoIT {

    public UsuarioDaoIT criarUsuario();
    
    public CandidatoDaoIT criarCandidato();
}