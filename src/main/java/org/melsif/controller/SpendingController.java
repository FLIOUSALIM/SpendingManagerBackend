package org.melsif.controller;

import org.melsif.form.ExpenditureForm;
import org.melsif.model.Expenditure;
import org.melsif.repository.ExpenditureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/spending", produces = "application/json")
public class SpendingController {

    @Autowired
    private ExpenditureRepository expenditureRepository;

    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public Expenditure saveExpenditure(@RequestBody ExpenditureForm expenditureForm) {
        Expenditure expenditure = Expenditure.builder()
                .cout(expenditureForm.getCout())
                .date(new Date())
                .build();
        return expenditureRepository.save(expenditure);
    }
}
