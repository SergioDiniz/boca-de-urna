package xmlConvert;

import ServerModule.Vote;
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

public class VoteXmlConvert {

    public static byte[] ObjXml(Vote vote) throws JAXBException{
        
        JAXBContext cvt = JAXBContext.newInstance(Vote.class);
        Marshaller marshaller = cvt.createMarshaller();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        marshaller.marshal(vote, output);
        
        return output.toByteArray();
    }
    
    public static Vote XmlObj(byte[] objeto) throws JAXBException{
        JAXBContext cvt = JAXBContext.newInstance(Vote.class);
        Unmarshaller unmarshaller = cvt.createUnmarshaller();
        
        Vote vote = (Vote) unmarshaller.unmarshal(new ByteArrayInputStream(objeto));
        
        return vote;
    }
}
