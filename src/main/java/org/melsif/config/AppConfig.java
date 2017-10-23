package org.melsif.config;

import org.melsif.util.XmlConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = { "org.melsif.util" })
public class AppConfig {

    @Bean
    public XmlConverter getXmlConverter() {
        XmlConverter xmlConverter = new XmlConverter();
        xmlConverter.setMarshaller(getCastorMarshaller());
        xmlConverter.setUnmarshaller(getCastorMarshaller());
        return xmlConverter;
    }

    @Bean
    public Jaxb2Marshaller getCastorMarshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("org.melsif.bean");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jaxb.formatted.output", true);
        jaxb2Marshaller.setMarshallerProperties(map);
        return jaxb2Marshaller;
    }
}
