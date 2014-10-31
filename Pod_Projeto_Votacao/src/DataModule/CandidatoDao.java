package DataModule;

import ServerModule.Candidates;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fatinha de Sousa
 */

public class CandidatoDao implements CandidatoDaoIT{

    private Connection conn;
    
    public CandidatoDao() throws SQLException{
        this.conn = new ConnectionDao().createConnection();
    }
    
    @Override
    public void atualizaVoto(String numero){
        String sql = "update candidato set qtd_voto = qtd_voto + 1 where numero = ?";
        
        try {
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, numero);
            
            stat.executeUpdate();
            stat.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<Candidates> buscarCandidato() {
        String sql = "select * from candidato";
        ArrayList<Candidates> candidatos = new ArrayList();
        
        try {
            PreparedStatement stat = this.conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            
            while(rs.next()){
                Candidates candidato = new Candidates();
                
                candidato.setNome(rs.getString(1));
                candidato.setCode(rs.getString(2));
                //candidato.setQuantity(rs.getString(3));
                
                candidatos.add(candidato);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return candidatos;
   }
}