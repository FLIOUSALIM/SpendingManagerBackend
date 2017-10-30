package org.melsif.service;

import org.melsif.model.User;
import org.melsif.repository.UserRepository;
import org.melsif.util.XmlConverter;
import org.melsif.util.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.io.IOException;

import static java.util.Collections.emptyList;

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
        org.melsif.bean.xml.User userXml = null;
        try {
            userXml = (org.melsif.bean.xml.User) xmlConverter.fromXmltoObject(FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = userMapper.fromXmltoObject(userXml);
        userRepository.save(user);
    }

    public UserDetails getUserByEmail(String email) {
       User user = userRepository.findByEmail(email);
       if (user == null) {
           throw new UsernameNotFoundException(email);
       }

       return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), emptyList());
    }
}
