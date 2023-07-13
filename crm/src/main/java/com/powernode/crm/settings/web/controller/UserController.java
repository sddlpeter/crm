package com.powernode.crm.settings.web.controller;

import com.powernode.crm.commons.constants.Constants;
import com.powernode.crm.commons.domain.ReturnObject;
import com.powernode.crm.commons.utils.DateUtils;
import com.powernode.crm.settings.domain.User;
import com.powernode.crm.settings.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/settings/qx/user/toLogin.do")
    public String user() {
        return "/settings/qx/user/login";
    }


    @RequestMapping("/settings/qx/user/login.do")
    @ResponseBody
    public Object login(String loginAct, String loginPwd, String isRemPwd, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        // 封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);

        // 调用service层方法，查询用户
        User user = userService.queryUserByLoginActAndPwd(map);


        ReturnObject returnObject = new ReturnObject();

        // 根据查询结果，生成响应信息
        if (user == null) {
            // 登录失败，用户名或密码错误
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        } else { // 进一步判断，账号是否合法

            String nowStr = DateUtils.formatDateTime(new Date());

            if (nowStr.compareTo(user.getExpireTime()) > 0) {
                //登陆失败，账号过期
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号过期");

            } else if("0".equals(user.getLockState())) {
                //登陆失败，账号被锁定
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号状态被锁定");

            } else if (!user.getAllowIps().contains(request.getRemoteAddr())) {
                //登陆失败，ip被限制
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("ip受限制");

            } else {
                // 登录成功
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
                session.setAttribute(Constants.SESSION_USER, user);

                // 如果需要记住密码，则往外写cookie
                if ("true".equals(isRemPwd)) {
                    Cookie c1 = new Cookie("loginAct", user.getLoginAct());
                    c1.setMaxAge(60*60*24*10);
                    response.addCookie(c1);

                    Cookie c2 = new Cookie("loginPwd", user.getLoginPwd());
                    c2.setMaxAge(60*60*24*10);
                    response.addCookie(c2);
                } else {
                    // 把没过期的cookie删除
                    Cookie c1 = new Cookie("loginAct", "1");
                    c1.setMaxAge(0);
                    response.addCookie(c1);

                    Cookie c2 = new Cookie("loginPwd", "1");
                    c2.setMaxAge(0);
                    response.addCookie(c2);
                }
            }
        }

        return returnObject;
    }


    @RequestMapping("/settings/qx/user/logout.do")
    public String logout(HttpServletResponse response, HttpSession session) {
        // 清空cookie
        Cookie c1 = new Cookie("loginAct", "1");
        c1.setMaxAge(0);
        response.addCookie(c1);

        Cookie c2 = new Cookie("loginPwd", "1");
        c2.setMaxAge(0);
        response.addCookie(c2);


        // 销毁session
        session.invalidate();

        // 跳转到首页
        return "redirect:/";  // 借助springmvc框架来重定向，翻译成response.sendRedirect("/crm/");
    }
}
