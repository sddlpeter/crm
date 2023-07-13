package com.powernode.crm.settings.service;

import com.powernode.crm.settings.domain.User;

import java.util.Map;

public interface UserService {
    User queryUserByLoginActAndPwd(Map<String, Object> map);
}
