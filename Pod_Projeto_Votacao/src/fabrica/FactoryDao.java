package fabrica;

/**
 *
 * @author Fatinha de Sousa
 */

public class FactoryDao {

    public static FactoryDaoIT createFactory(){
        return new FactoryDaoBD();
    }
}
