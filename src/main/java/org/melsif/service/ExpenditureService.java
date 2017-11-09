package org.melsif.service;

import org.melsif.model.Expenditure;
import org.melsif.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenditureService {

    @Autowired
    private ExpenditureRepository expenditureRepository;

    public List<Expenditure> findAll() {
        return expenditureRepository.findAll();
    }

}
