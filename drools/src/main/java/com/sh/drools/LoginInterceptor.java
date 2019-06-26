package com.sh.drools;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: liyong
 * @Date:2019/6/19 17:14
 * @Desc: 登录状态拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static String SESSION_KEY= "user";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //判断是否已有该用户登录的session
        if(session.getAttribute(SESSION_KEY) != null){
            return true;
        }

        // 跳转到登录页
        String url = "/login";
        response.sendRedirect(url);
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
