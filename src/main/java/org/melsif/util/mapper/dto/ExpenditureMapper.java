package org.melsif.util.mapper.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.melsif.dto.Expenditure;
import org.melsif.model.ExpenditureType;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExpenditureMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "cout", target = "cout"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "expenditureType.type", target = "type"),
    })
    Expenditure toDto(org.melsif.model.Expenditure expenditure);

    List<Expenditure> toDtos(List<org.melsif.model.Expenditure> expenditures);
}
