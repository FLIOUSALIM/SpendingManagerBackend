package org.melsif.service;

import org.melsif.bean.xml.User;
import org.melsif.repository.UserRepository;
import org.melsif.util.XmlConverter;
import org.melsif.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {

    private static final String FILENAME = "/xml/user.xml";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private XmlConverter xmlConverter;

    @Autowired
    private UserMapper userMapper;

    public void initializeUsers() {
        User userXml = null;
        try {
            userXml = (User) xmlConverter.fromXmltoObject(FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        org.melsif.model.User user = userMapper.fromXmltoObject(userXml);
        userRepository.save(user);
    }
}
