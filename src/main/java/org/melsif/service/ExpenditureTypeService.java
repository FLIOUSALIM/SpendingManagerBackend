package org.melsif.service;

import org.melsif.model.ExpenditureType;
import org.melsif.repository.ExpenditureTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenditureTypeService {

    @Autowired
    private ExpenditureTypeRepository expenditureTypeRepository;

    public void initializeExpenditureType() {
        List<ExpenditureType> expenditureTypes = initExpenditureType();
        for(ExpenditureType expenditureType : expenditureTypes) {
            save(expenditureType);
        }
    }

    private List<ExpenditureType> initExpenditureType() {
        List<ExpenditureType> result = new ArrayList<>();
        result.add(ExpenditureType.builder().type("Shopping").build());
        result.add(ExpenditureType.builder().type("Frais divers").build());
        result.add(ExpenditureType.builder().type("Voyage").build());
        return result;
    }

    public List<ExpenditureType> findAll() {
        return expenditureTypeRepository.findAll();
    }

    private void save(ExpenditureType expenditureType) {
        expenditureTypeRepository.save(expenditureType);
    }
}
