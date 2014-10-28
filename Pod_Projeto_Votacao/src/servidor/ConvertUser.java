package servidor;

import classes.User;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Fatinha de Sousa
 */

public class ConvertUser {

    public static byte[] ObjXml(User usuario) throws JAXBException{
        
        JAXBContext cvt = JAXBContext.newInstance(User.class);
        Marshaller marshaller = cvt.createMarshaller();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        marshaller.marshal(usuario, output);
        
        return output.toByteArray();
    }
    
    public static User XmlObj(byte[] objeto) throws JAXBException{
        JAXBContext cvt = JAXBContext.newInstance(User.class);
        Unmarshaller unmarshaller = cvt.createUnmarshaller();
        
        User usuario = (User) unmarshaller.unmarshal(new ByteArrayInputStream(objeto));
        
        return usuario;
    }
}
