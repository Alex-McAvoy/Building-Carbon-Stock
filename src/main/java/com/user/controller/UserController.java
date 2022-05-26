package com.user.controller;

import com.user.bean.User;
import com.user.service.UserService;
import com.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 用户相关控制器
 * @Author: Alex McAvoy
 * @Date: 2022/5/19 0:51
 * @Version: 1.0
 **/
@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * @Description: 用户登录验证
     * @Param: [username, password]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 1:22
     **/
    @ResponseBody
    @RequestMapping("/login-verify")
    public Msg login(@RequestParam String username, @RequestParam String password,
                     HttpServletRequest request, HttpServletResponse response) {
        User user = userService.getUserByUsername(username);

        if (user == null) {
            return Msg.fail().add("message", "userNull");
        } else {
            if (user.getPassword().equals(password)) {
                request.getSession().removeAttribute("user");
                request.getSession().setAttribute("user", user);
                return Msg.success().add("message", "success");
            } else {
                return Msg.fail().add("message", "passwordWrong");
            }
        }
    }

    /**
     * @Description: 登出
     * @Param: [request, response]
     * @Return: com.utils.Msg
     * @Author: Alex McAvoy
     * @Date: 2022/5/25 20:51
     **/
    @ResponseBody
    @RequestMapping("/exit")
    public Msg exit(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        return Msg.success();
    }

    /**
     * @Description: 登录成功跳转
     * @Param: []
     * @Return: java.lang.String
     * @Author: Alex McAvoy
     * @Date: 2022/5/19 1:22
     **/
    @RequestMapping("/manage")
    public String toManagePage() {
        return "manage";
    }

}
