package com.powernode.crm.workbench.service;

import com.powernode.crm.workbench.domain.Clue;

public interface ClueService {
    int saveCreateClue(Clue clue);

    Clue queryClueForDetailById(String id);
}
