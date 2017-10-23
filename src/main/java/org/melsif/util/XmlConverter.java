package org.melsif.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Getter
@Setter
public class XmlConverter {

    private Marshaller marshaller;

    private Unmarshaller unmarshaller;

    public Object fromXmltoObject(String xmlFileName) throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(xmlFileName);
        return unmarshaller.unmarshal(new StreamSource(inputStream));
    }

}
