package org.melsif.bean.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class User {

    @XmlElement(name = "lastname")
    private String lastname;

    @XmlElement(name = "firstname")
    private String firstname;

    @XmlElement(name = "budget")
    private int budget;

    @XmlElement(name = "email")
    private String email;

    @XmlElement(name = "password")
    private String password;

}
