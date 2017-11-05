package org.melsif.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpendingManagerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(SpendingManagerService.class);

    @Autowired
    private ParamService paramService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExpenditureTypeService expenditureTypeService;


    public void initializeApplication() {
        if (!paramService.isUsersInitialized()) {
            LOGGER.info("Initializing users...");
            userService.initializeUsers();
            paramService.putUsersInitialized();
            LOGGER.info("Users initialized...");
        }

        if (!paramService.isExpenditureTypeInitialized()) {
            LOGGER.info("Initializing Expenditure Types ...");
            expenditureTypeService.initializeExpenditureType();
            paramService.putExpenditureTypeInitialized();
            LOGGER.info("Expenditure Types initialized...");
        }
    }
}
