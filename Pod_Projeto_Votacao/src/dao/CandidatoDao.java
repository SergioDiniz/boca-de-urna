package dao;

import classes.Candidates;
import conexaoBanco.ConnectionDao;
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
    public void atualizaVoto(int numero){
        String sql = "update candidato set qtd_voto = qtd_voto + 1 where numero = ?";
        
        try {
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setInt(1, numero);
            
            stat.execute();
            stat.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Candidates buscarCandidato(int numero){
        String sql = "select * from candidato where numero = ?";
        Candidates candidato = new Candidates();
        
        try {
            PreparedStatement stat = this.conn.prepareStatement(sql);
            stat.setInt(1, numero);
            
            ResultSet rs = stat.executeQuery();
            rs.next();
            
            candidato.setNome(rs.getString(1));
            candidato.setCode(rs.getString(2));
            candidato.setQuantity(rs.getString(3));
            
            stat.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candidato;
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
                candidato.setQuantity(rs.getString(3));
                
                candidatos.add(candidato);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return candidatos;
   }
}