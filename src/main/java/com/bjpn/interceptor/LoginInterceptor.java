package com.bjpn.interceptor;


import com.bjpn.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //除了login下的请求  都会被拦截器的预处理拦截
        //判断session
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        if(user!=null){
            return true;
        }else{
            //该请求没有登录  强行登录
            response.sendRedirect(request.getContextPath()+"/login/toLogin.action");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
