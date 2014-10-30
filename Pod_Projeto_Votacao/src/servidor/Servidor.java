package servidor;

import classes.AcessStatus;
import classes.Token;
import classes.User;
import classes.Vote;
import funcoes.DadosCliente;
import funcoes.StringByte;
import gerenciador.GerenciadorCandidato;
import gerenciador.GerenciadorUsuario;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;
import xmlConvert.AcessStatusXml;
import xmlConvert.ConvertUser;

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
                System.out.println("Cadastrando Email!");
                User u = (User) ConvertUser.XmlObj(dad);
                
                GerenciadorUsuario gerenciador = new GerenciadorUsuario();
                gerenciador.addUsuario(u.getEmail());
                
                socket.getOutputStream().write("Cadastro Efetuado com Sucesso...".getBytes());
                socket.getOutputStream().close();
            break;
                
            case "LOG":
                
                User user = (User) ConvertUser.XmlObj(dad);
                
                GerenciadorUsuario g1 = new GerenciadorUsuario();
                User usuario = g1.buscarUsuairo(user.getEmail());
                
                
                
                if(usuario != null){
                    socket.getOutputStream().write("Bem Vindo! " .getBytes());
                    socket.getOutputStream().close();
                }else{
                    socket.getOutputStream().write("Usuario Não Encontrado! " .getBytes());
                    socket.getOutputStream().close();
                }
                
           break;
                
        }
        
        socket.close();
        server.close();
    }
}