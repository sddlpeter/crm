package com.powernode.crm.workbench.service.impl;

import com.powernode.crm.commons.constants.Constants;
import com.powernode.crm.commons.utils.DateUtils;
import com.powernode.crm.commons.utils.UUIDUtils;
import com.powernode.crm.settings.domain.User;
import com.powernode.crm.workbench.domain.Clue;
import com.powernode.crm.workbench.domain.ClueRemark;
import com.powernode.crm.workbench.domain.Contacts;
import com.powernode.crm.workbench.domain.Customer;
import com.powernode.crm.workbench.mapper.ClueMapper;
import com.powernode.crm.workbench.mapper.ClueRemarkMapper;
import com.powernode.crm.workbench.mapper.ContactsMapper;
import com.powernode.crm.workbench.mapper.CustomerMapper;
import com.powernode.crm.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("clueService")
public class ClueServiceImpl implements ClueService {

    @Autowired
    ClueMapper clueMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    ContactsMapper contactsMapper;

    @Autowired
    ClueRemarkMapper clueRemarkMapper;

    @Override
    public int saveCreateClue(Clue clue) {
        return clueMapper.insertClue(clue);
    }

    @Override
    public Clue queryClueForDetailById(String id) {
        return clueMapper.selectClueForDetailById(id);
    }

    @Override
    public void saveConvertClue(Map<String, Object> map) {
        String clueId = (String) map.get("clueId");
        User user = (User) map.get(Constants.SESSION_USER);
        Clue clue = clueMapper.selectClueById(clueId);

        Customer c = new Customer();
        c.setAddress(clue.getAddress());
        c.setContactSummary(clue.getContactSummary());
        c.setCreateBy(user.getId());
        c.setCreateTime(DateUtils.formatDateTime(new Date()));
        c.setDescription(clue.getDescription());
        c.setId(UUIDUtils.getUUID());
        c.setName(clue.getCompany());
        c.setNextContactTime(clue.getNextContactTime());
        c.setOwner(user.getId());
        c.setPhone(clue.getPhone());
        c.setWebsite(clue.getWebsite());

        customerMapper.insertCustomer(c);


        Contacts co = new Contacts();
        co.setAddress(clue.getAddress());
        co.setAppellation(clue.getAppellation());
        co.setContactSummary(clue.getContactSummary());
        co.setCreateBy(user.getId());
        co.setCreateTime(DateUtils.formatDateTime(new Date()));
        co.setCustomerId(c.getId());
        co.setDescription(clue.getDescription());
        co.setEmail(clue.getEmail());
        co.setFullname(clue.getFullname());
        co.setId(UUIDUtils.getUUID());
        co.setJob(clue.getJob());
        co.setMphone(clue.getMphone());
        co.setNextContactTime(clue.getNextContactTime());
        co.setOwner(user.getId());
        co.setSource(clue.getSource());

        contactsMapper.insertContacts(co);

        List<ClueRemark> clueRemarkList = clueRemarkMapper.selectClueRemarkByClueId(clueId);

    }
}
