package org.melsif.controller;

import org.melsif.service.ExpenditureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/expenditure", produces = "application/json")
public class ExpenditureController {

    private ExpenditureService expenditureService;

}
