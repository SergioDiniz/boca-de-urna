package servidor;

import classes.AcessStatus;
import classes.User;
import classes.Vote;
import gerenciador.GerenciadorCandidato;
import gerenciador.GerenciadorUsuario;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Fatinha de Sousa
 */

public class Servidor {

    public static void main(String [] args) throws IOException, JAXBException, NoSuchAlgorithmException, SQLException{
        
        ServerSocket server = new ServerSocket(10001);
        System.out.println("Servidor Rodando na Porta: " +server.getLocalPort());
        System.out.println("Host: " +server.getInetAddress().toString());
        System.out.println("Aguardando Conexão dos Clientes...");
        
        Socket socket = server.accept();
        
        InputStream input = socket.getInputStream();
        
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        byte[] dados = new byte[1];
        
        while(input.read(dados) != -1){
            temp.write(dados);
        }
        
        User user = (User) ConvertUser.XmlObj(temp.toByteArray());
        GerenciadorUsuario gerenciador = new GerenciadorUsuario();
        gerenciador.addUsuario(user.getEmail());
        /*
        GerenciadorUsuario gerenciador = new GerenciadorUsuario();
        user = gerenciador.buscarUsuairo(user.getEmail());
        
        if(user != null){
        
            System.out.println("Status: " +user.getEmail());
            System.out.println("Token: " +user.getToken());
            System.out.println("Email: " +user.getEmail());
        }
        
        System.out.println(temp.toString().toString());
        *//*
        socket.getOutputStream().write(ConvertUser.ObjXml(user));
        socket.getOutputStream().close();
        */
        socket.close();
        server.close();
    }
}