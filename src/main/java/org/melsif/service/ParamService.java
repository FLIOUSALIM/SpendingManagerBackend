package org.melsif.service;

import org.melsif.model.Param;
import org.melsif.repository.ParamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParamService {

    private static final String USER_INIT_KEY = "users_initialized";
    private static final String EXPENDITURE_TYPE_INIT_KEY = "expenditure_type_initialized";

    @Autowired
    private ParamRepository paramRepository;

    public boolean isUsersInitialized() {
        Param param = paramRepository.findOne(USER_INIT_KEY);
        return param != null && param.getValue() ;
    }

    public void putUsersInitialized() {
        Param param = new Param();
        param.setClef(USER_INIT_KEY);
        param.setValue(true);
        paramRepository.save(param);
    }

    public boolean isExpenditureTypeInitialized() {
        Param param = paramRepository.findOne(EXPENDITURE_TYPE_INIT_KEY);
        return param != null && param.getValue();
    }

    public void putExpenditureTypeInitialized() {
        Param param = new Param();
        param.setClef(EXPENDITURE_TYPE_INIT_KEY);
        param.setValue(true);
        paramRepository.save(param);
    }
}
