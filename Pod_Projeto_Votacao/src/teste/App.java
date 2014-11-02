package teste;

import DataModule.*;
import ServerModule.*;
import ServerModule.*;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import xmlConvert.AcessStatusXml;
import xmlConvert.ConvertUser;
import xmlConvert.ReportXml;
import xmlConvert.StringByte;
import xmlConvert.VoteXmlConvert;



/**
 *
 * @author Fatinha de Sousa
 */
public class App {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException, JAXBException {
       GerenciadorCandidato gerenciador = new GerenciadorCandidato();
       Candidate candidate = new Candidate();
       
       candidate = gerenciador.buscarCandidate("25");
       
       if(candidate != null){
           System.out.println("Candidato: " +candidate.getName());
           System.out.println("Numero: " +candidate.getCode());
           System.out.println("Votos: " +candidate.getQuantity());
       }else{
           System.out.println("Candidate Invalido! ");
       }
    }
}
