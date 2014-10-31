package servidor;

import DataModule.GerenciadorCandidato;
import DataModule.GerenciadorUsuario;
import ServerModule.AcessStatus;
import ServerModule.User;
import ServerModule.Vote;
import xmlConvert.StringByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;
import xmlConvert.AcessStatusXml;
import xmlConvert.ConvertUser;
import xmlConvert.VoteXmlConvert;

/**
 *
 * @author Fatinha de Sousa
 */

public class Servidor {

    public static void main(String [] args) throws IOException, JAXBException, NoSuchAlgorithmException, SQLException{
    
        ServerSocket server = new ServerSocket(10001);
        System.out.println("Aguardando Conexao...");
        Socket socket = server.accept();
        System.out.println("Conexao Realizada...");
        
        InputStream in = socket.getInputStream();
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        
        in.read(b);
        temp.write(b);
        
        String mensagem = StringByte.convertByteStringSemCod(b);
        String [] cod = mensagem.split(";");
        
        b = StringByte.convertStringByte(cod[1]);
        
        int aux = 0;
        for(int i = 0; i < b.length; i++ ){
            if(b[i] != 0){
                aux++;
            }
        }
        
        temp.close();
        
        byte[] dad = new byte[aux];
        
        for(int i = 0; i < aux; i++ ){
            dad[i] = b[i];
        }
        
        switch(cod[0]){
        
            case "CAD":
                User u = (User) ConvertUser.XmlObj(dad);
                GerenciadorUsuario gUsuario = new GerenciadorUsuario();
                User u1 = gUsuario.buscarUsuairo(u.getEmail());
                
                if(u1 == null){
                    gUsuario.addUsuario(u.getEmail());
                    socket.getOutputStream().write("Cadastro Efetuado com Sucesso...".getBytes());
                    socket.getOutputStream().close();
                }else{
                    socket.getOutputStream().write("Email Invalido! ".getBytes());
                }
            break;
                
            case "LOG":
                
                User user = (User) ConvertUser.XmlObj(dad);
                GerenciadorUsuario gUsuario1 = new GerenciadorUsuario();
                
                User usuario = gUsuario1.buscarUsuairo(user.getEmail());
                
                if(usuario != null){
                    AcessStatus acess = new AcessStatus();
                    acess.setAccess(usuario.getToken());
                    acess.setStatus(usuario.getStatus());
                
                    byte [] d = null;
                    d = AcessStatusXml.ObjXml(acess);
                    
                    socket.getOutputStream().write(d);
                }else{
                    socket.getOutputStream().write("Usuario Não Encontrado! ".getBytes());
                    socket.getOutputStream().close();
                }
                break;
                
            case "VOT" :
                
                Vote vote  = (Vote) VoteXmlConvert.XmlObj(dad);
                
                GerenciadorCandidato gCandidato = new GerenciadorCandidato();
                GerenciadorUsuario gUsuario2 = new GerenciadorUsuario();
                
                gCandidato.computaVoto(vote.getvalue());
                gUsuario2.atualizaStatus(vote.getUser());
                
                socket.getOutputStream().write("Voto Enviado Com Sucesso! ".getBytes());
                socket.getOutputStream().close();
                
                break;
                
            case "PAL" :{
                socket.getOutputStream().write("Estatisticas!".getBytes());
                socket.getOutputStream().close();
            }
        }
        
        socket.close();
        server.close();
    }
}