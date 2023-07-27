package com.powernode.crm.workbench.service.impl;

import com.powernode.crm.workbench.domain.Clue;
import com.powernode.crm.workbench.mapper.ClueMapper;
import com.powernode.crm.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("clueService")
public class ClueServiceImpl implements ClueService {

    @Autowired
    ClueMapper clueMapper;

    @Override
    public int saveCreateClue(Clue clue) {
        return clueMapper.insertClue(clue);
    }

    @Override
    public Clue queryClueForDetailById(String id) {
        return clueMapper.selectClueForDetailById(id);
    }
}
