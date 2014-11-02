package ServerModule;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Fatinha de Sousa
 */

public class Token {
    
    public static String hashMDK5(String email) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String aux = "";
        MessageDigest msg = null;
        
        msg = MessageDigest.getInstance("MD5");
        
        BigInteger hash = new BigInteger(1, msg.digest(email.getBytes("UTF-8")));
        aux = hash.toString(16);
        
        return aux;
    }
}
