package org.melsif.bean.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
public class UserList {
    List<User> users;

}
