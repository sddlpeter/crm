package com.powernode.crm.workbench.web.controller;

import com.powernode.crm.settings.domain.DicValue;
import com.powernode.crm.settings.domain.User;
import com.powernode.crm.settings.service.DicValueService;
import com.powernode.crm.settings.service.UserService;
import com.powernode.crm.workbench.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.ResourceBundle;

@Controller
public class TranController {

    @Autowired
    DicValueService dicValueService;

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @RequestMapping("/workbench/transaction/index.do")
    public String index(HttpServletRequest request){
        List<DicValue> transactionTypeList = dicValueService.queryDicValueByTypeCode("transaction");
        List<DicValue> sourceList = dicValueService.queryDicValueByTypeCode("source");
        List<DicValue> stageList = dicValueService.queryDicValueByTypeCode("stage");

        request.setAttribute("transactionTypeList", transactionTypeList);
        request.setAttribute("sourceList", sourceList);
        request.setAttribute("stageList", stageList);


        return "workbench/transaction/index";
    }

    @RequestMapping("/workbench/transaction/toSave.do")
    public String toSave(HttpServletRequest request){
        List<User> userList = userService.queryAllUsers();
        List<DicValue> transactionTypeList = dicValueService.queryDicValueByTypeCode("transaction");
        List<DicValue> sourceList = dicValueService.queryDicValueByTypeCode("source");
        List<DicValue> stageList = dicValueService.queryDicValueByTypeCode("stage");

        request.setAttribute("userList", userList);
        request.setAttribute("transactionTypeList", transactionTypeList);
        request.setAttribute("sourceList", sourceList);
        request.setAttribute("stageList", stageList);

        return "workbench/transaction/save";
    }

    @RequestMapping("/workbench/transaction/getPossibilityByStage.do")
    @ResponseBody
    public Object getPossibilityByStage(String stageValue){
        ResourceBundle bundle = ResourceBundle.getBundle("possibility");
        String possibility = bundle.getString(stageValue);
        return possibility;
    }

    @RequestMapping("/workbench/transaction/queryAllCustomerName.do")
    @ResponseBody
    public Object queryAllCustomerName(String customerName){
        return customerService.queryCustomerNameByName(customerName);
    }
}
