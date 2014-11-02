package xmlConvert;

import java.io.UnsupportedEncodingException;

/**
 *
 * @author Fatinha de Sousa
 */

public class StringByte {

    public static byte[] convertStringByte(String string){
        return string.getBytes();
    }
    
    public static String convertByteString(byte[] bytes, String cod) throws UnsupportedEncodingException{
        
        String codigo = new String(bytes, "UTF-8");
        return cod + codigo;
    }
    
    public static String convertByteStringSemCod(byte[] bytes) throws UnsupportedEncodingException{
        return new String(bytes, "UTF-8");
    }
}