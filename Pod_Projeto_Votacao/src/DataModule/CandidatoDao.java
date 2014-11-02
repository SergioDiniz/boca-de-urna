package DataModule;

import ServerModule.Candidate;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
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
    public ArrayList<Candidate> buscarCandidato() {
        String sql = "select * from candidato";
        ArrayList<Candidate> candidatos = new ArrayList();
        
        try {
            PreparedStatement stat = this.conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            
            while(rs.next()){
                Candidate candidato = new Candidate();
                
                candidato.setName(rs.getString(1));
                candidato.setCode(rs.getString(2));
                candidato.setQuantity(rs.getInt(3));
                candidato.setRelative(estatistica(candidato));
                
                candidatos.add(candidato);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return candidatos;
   }
   
   public int qtdVoto() {
       int qtdVoto = 0;
       try {
           String sql = "{? = call contaVotos()}";
           CallableStatement call = this.conn.prepareCall(sql);
           call.registerOutParameter(1, java.sql.Types.INTEGER);
           call.execute();
           
           qtdVoto = call.getInt(1);
          } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return qtdVoto;
    }
   
   public float estatistica(Candidate candidate){
       float resultado;
       
       resultado = ((candidate.getQuantity() * 100) / qtdVoto());
       
       return resultado;
   }
   
   @Override
   public Candidate buscarCandidato(String numero){
        String sql = "select * from candidato where numero ilike ?";
        Candidate candidate = new Candidate();
        try {
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setString(1, numero);
            ResultSet rs = stat.executeQuery();
            
            if(rs.next() == true){
                candidate.setName(rs.getString(1));
                candidate.setCode(rs.getString(2));
                candidate.setQuantity(rs.getInt(3));
            }else{
                candidate = null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return candidate;
   }
}