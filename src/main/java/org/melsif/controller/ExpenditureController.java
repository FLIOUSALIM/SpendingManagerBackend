package org.melsif.controller;

import org.melsif.model.Expenditure;
import org.melsif.service.ExpenditureService;
import org.melsif.util.mapper.dto.ExpenditureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/expenditure", produces = "application/json")
public class ExpenditureController {

    @Autowired
    private ExpenditureService expenditureService;

    @Autowired
    private ExpenditureMapper expenditureMapper;

    @GetMapping
    public List<org.melsif.dto.Expenditure> getAllExpenditures() {
        List<Expenditure> expenditures = expenditureService.findAll();
        return expenditureMapper.toDtos(expenditures);
    }


}
