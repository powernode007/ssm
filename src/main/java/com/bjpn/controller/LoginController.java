package com.bjpn.controller;


import com.bjpn.bean.User;
import com.bjpn.service.UserService;
import com.bjpn.util.MessageUtil;
import com.bjpn.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("/toLogin.action")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/loginUser.action")
    @ResponseBody
    public ReturnObject loginUser(String userCode, String userPwd, Boolean loginCheck, ReturnObject returnObject, HttpServletResponse response, HttpSession session){
        User user = userService.loginUserService(userCode, userPwd);
        if(user!=null){
            //登录成功
            if(loginCheck){
                //记住密码
                Cookie cookieCode = new Cookie("loginCode", userCode);
                Cookie cookiePwd = new Cookie("loginPwd", userPwd);

                cookieCode.setPath("/");
                cookiePwd.setPath("/");
                cookieCode.setMaxAge(60*60*24*14);
                cookiePwd.setMaxAge(60*60*24*14);
                response.addCookie(cookieCode);
                response.addCookie(cookiePwd);
            }else{
                Cookie cookieCode = new Cookie("loginCode", userCode);
                Cookie cookiePwd = new Cookie("loginPwd", userPwd);
                cookieCode.setPath("/");
                cookiePwd.setPath("/");
                cookieCode.setMaxAge(0);
                cookiePwd.setMaxAge(0);
                response.addCookie(cookieCode);
                response.addCookie(cookiePwd);
            }
            //把User放在session中
            session.setAttribute("user", user);
            returnObject.setMessageCode(MessageUtil.LOGIN_SUCCESS_CODE);
            returnObject.setMessageStr(MessageUtil.LOGIN_SUCCESS_STR);
        }else{
            //失败
            returnObject.setMessageCode(MessageUtil.LOGIN_FAIL_CODE);
            returnObject.setMessageStr(MessageUtil.LOGIN_FAIL_STR);
        }
        return returnObject;
    }
}
