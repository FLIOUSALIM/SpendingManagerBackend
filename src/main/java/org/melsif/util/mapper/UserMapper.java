package org.melsif.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.melsif.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "lastname", target = "nom"),
            @Mapping(source = "firstname", target = "prenom"),
            @Mapping(source = "budget", target = "budget"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password")
    })
    User fromXmltoObject(org.melsif.bean.xml.User user);

}
