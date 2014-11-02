package xmlConvert;

import ServerModule.AcessStatus;
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

public class AcessStatusXml {

    public static byte[] ObjXml(AcessStatus acess) throws JAXBException{
        
        JAXBContext cvt = JAXBContext.newInstance(AcessStatus.class);
        Marshaller marshaller = cvt.createMarshaller();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        marshaller.marshal(acess, output);
        
        return output.toByteArray();
    }
    
    public static AcessStatus XmlObj(byte[] objeto) throws JAXBException{
        JAXBContext cvt = JAXBContext.newInstance(AcessStatus.class);
        Unmarshaller unmarshaller = cvt.createUnmarshaller();
        
        AcessStatus acess = (AcessStatus) unmarshaller.unmarshal(new ByteArrayInputStream(objeto));
        
        return acess;
    }
}
