package xmlConvert;

import ServerModule.Report;
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

public class ReportXml {

    public static byte[] ObjXml(Report report) throws JAXBException{
        
        JAXBContext cvt = JAXBContext.newInstance(Report.class);
        Marshaller marshaller = cvt.createMarshaller();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        marshaller.marshal(report, output);
        
        return output.toByteArray();
    }
    
    public static Report XmlObj(byte[] objeto) throws JAXBException{
        JAXBContext cvt = JAXBContext.newInstance(Report.class);
        Unmarshaller unmarshaller = cvt.createUnmarshaller();
        
        Report report = (Report) unmarshaller.unmarshal(new ByteArrayInputStream(objeto));
        
        return report;
    }
}
