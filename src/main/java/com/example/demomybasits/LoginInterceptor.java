package com.example.demomybasits;

import com.example.demomybasits.api.mapper.StaffUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private StaffUserMapper mapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().equals("/api/getAllAirlines")||
                request.getRequestURI().equals("/api/Register")
                || request.getRequestURI().equals("/service/register"))return true;
        //log.info("==========登录状态拦截");
        System.out.println("==========登录状态拦截");
        HttpSession session = request.getSession();
       // log.info("sessionId为：" + session.getId());
        System.out.println("sessionId为：" + session.getId());
        // 获取用户信息，如果没有用户信息直接返回提示信息
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo == null) {
            //log.info("没有登录");
            System.out.println("没有登录");
            response.getWriter().write("408");
            response.setHeader("Access-Control-Allow-Origin",request.getHeader("origin"));
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            return false;
        } else {
            System.out.println("已经登录过啦，用户信息为：\" "+ session.getAttribute("userInfo"));
            //log.info("已经登录过啦，用户信息为：" + session.getAttribute("userInfo"));
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
