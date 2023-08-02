package com.powernode.crm.workbench.service;

import com.powernode.crm.workbench.domain.Tran;

import java.util.Map;

public interface TranService {
    void saveCreateTran(Map<String, Object> map);

    Tran queryTranForDetailById(String id);
}
