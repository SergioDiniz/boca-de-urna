package funcoes;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author Fatinha de Sousa
 */

public class DadosCliente {

    private static String [] cod;
    
    public static byte[] byteUser(Socket socket) throws IOException{
        
        InputStream in = socket.getInputStream();
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        
        in.read(b);
        temp.write(b);
        
        String mensagem = StringByte.convertByteStringSemCod(b);
        cod = mensagem.split(";");
        System.out.println(mensagem);
        /*
        b = StringByte.convertStringByte(cod[1]);
        System.out.println(StringByte.convertByteStringSemCod(b));
        /*
        int aux = 0;
        for(int i = 0; i < b.length; i++ ){
            if(b[i] != 0){
                aux++;
            }
        }
        
        temp.close();
        
        byte[] dados = new byte[aux];
        
        for(int i = 0; i < aux; i++ ){
            dados[i] = b[i];
        }*/
        System.out.println("Funcionando! ");
        return b;
    }
    
    public String getCod(Socket socket) throws IOException{
        InputStream in = socket.getInputStream();
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        
        in.read(b);
        temp.write(b);
        
        String mensagem = StringByte.convertByteStringSemCod(b);
        cod = mensagem.split(";");
        return cod[0];
    }
}
