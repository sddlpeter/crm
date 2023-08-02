package com.powernode.crm.workbench.service;

import com.powernode.crm.workbench.domain.TranHistory;
import com.powernode.crm.workbench.mapper.TranHistoryMapper;

import java.util.List;

public interface TranHistoryService {
    List<TranHistory> queryTranHistoryForDetailByTranId(String tranId);
}
