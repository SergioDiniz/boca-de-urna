package ServerModule;

import DataModule.GerenciadorCandidato;
import DataModule.GerenciadorUsuario;
import xmlConvert.StringByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;
import xmlConvert.AcessStatusXml;
import xmlConvert.ConvertUser;
import xmlConvert.ReportXml;
import xmlConvert.VoteXmlConvert;

/**
 *
 * @author Fatinha de Sousa
 */
public class Servidor {

    public static void main(String[] args) throws IOException, JAXBException, NoSuchAlgorithmException, SQLException {

        ServerSocket server = new ServerSocket(10001);
        System.out.println("Aguardando Conexao...");

        while (true) {

            Socket socket = server.accept();
            System.out.println("Conexao Realizada...");

            InputStream in = socket.getInputStream();
            ByteArrayOutputStream temp = new ByteArrayOutputStream();
            byte[] b = new byte[1024];

            in.read(b);
            temp.write(b);

            String mensagem = StringByte.convertByteStringSemCod(b);
            
            String[] cod = mensagem.split(";");
            int aux = 0;
            byte[] dad = null;
            
            if(cod.length == 2){
            b = StringByte.convertStringByte(cod[1]);

                for (int i = 0; i < b.length; i++) {
                    if (b[i] != 0) {
                        aux++;
                    }
                }

                temp.close();
                dad = new byte[aux];
                System.arraycopy(b, 0, dad, 0, aux);
            }
            switch (cod[0]) {
                
                case "CAD":
                    User u = (User) ConvertUser.XmlObj(dad);
                    GerenciadorUsuario gUsuario = new GerenciadorUsuario();
                    User u1 = gUsuario.buscarUsuairo(u.getEmail());

                    if (u1 == null) {
                        gUsuario.addUsuario(u.getEmail());
                        socket.getOutputStream().write("Cadastro Efetuado com Sucesso...".getBytes());
                        socket.getOutputStream().close();
                    } else {
                        socket.getOutputStream().write("Email Ja Esta Cadastrado! ".getBytes());
                        socket.getOutputStream().close();
                    }
                    break;

                case "LOG":

                    User user = (User) ConvertUser.XmlObj(dad);
                    GerenciadorUsuario gUsuario1 = new GerenciadorUsuario();

                    User usuario = gUsuario1.buscarUsuairo(user.getEmail());

                    if (usuario != null) {
                        AcessStatus acess = new AcessStatus();
                        acess.setAccess(usuario.getToken());
                        acess.setStatus(usuario.getStatus());

                        byte[] d = null;
                        d = AcessStatusXml.ObjXml(acess);

                        socket.getOutputStream().write(d);
                        socket.getOutputStream().close();
                    } else {
                        socket.getOutputStream().write("Usuario Não Encontrado! ".getBytes());
                        socket.getOutputStream().close();
                    }
                    break;

                case "VOT":

                    Vote vote = (Vote) VoteXmlConvert.XmlObj(dad);
                    GerenciadorCandidato gCandidato = new GerenciadorCandidato();
                    
                    Candidate candidate1 = gCandidato.buscarCandidate(vote.getvalue());
                    
                    if(candidate1 != null){
                    
                        GerenciadorUsuario gUsuario2 = new GerenciadorUsuario();

                        gCandidato.computaVoto(vote.getvalue());
                        gUsuario2.atualizaStatus(vote.getUser());

                        socket.getOutputStream().write("Voto Efetuado Com Sucesso!".getBytes());
                        socket.getOutputStream().close();
                    }else{
                        System.out.println("Candidato Invalido! ");
                        socket.getOutputStream().write("Candidate Invalido".getBytes());
                        socket.getOutputStream().close();
                    }
                    break;

                case "PAL": {
                    
                    GerenciadorCandidato gerenciador = new GerenciadorCandidato();
                    ArrayList<Candidate> candidate = new ArrayList();
                    candidate = gerenciador.candidatos();
                    Candidates cand = new Candidates(candidate);
                    Report report = new Report(cand);
                    byte [] rep = new byte[1024];
                    rep = ReportXml.ObjXml(report);
                    
                    socket.getOutputStream().write(rep);
                    socket.getOutputStream().close();
                }
            }
        }

        //server.close();
    }
}
