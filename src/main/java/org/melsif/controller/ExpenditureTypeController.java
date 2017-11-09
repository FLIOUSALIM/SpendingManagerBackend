package org.melsif.controller;

import org.melsif.model.ExpenditureType;
import org.melsif.service.ExpenditureService;
import org.melsif.service.ExpenditureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/expendituretype", produces = "application/json")
public class ExpenditureTypeController {

    @Autowired
    private ExpenditureTypeService expenditureTypeService;

    @GetMapping
    public List<ExpenditureType> getAllExpenditureTypes() {
        return expenditureTypeService.findAll();
    }
}
