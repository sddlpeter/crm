package com.powernode.crm.workbench.web.controller;

import com.powernode.crm.settings.domain.User;
import com.powernode.crm.settings.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    UserService userService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request){
        List<User> userList = userService.queryAllUsers();


        request.setAttribute("userList", userList);

        // 请求转发到市场活动主页面
        return "workbench/activity/index";
    }
}
