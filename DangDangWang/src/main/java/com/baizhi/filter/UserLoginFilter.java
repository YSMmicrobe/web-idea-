package com.baizhi.filter;

import com.baizhi.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebFilter(filterName = "aa",urlPatterns = "/*")
public class UserLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        User user = (User) req.getSession().getAttribute("user");
        if (user != null){
            chain.doFilter(request,response);
        }else {
            resp.sendRedirect(req.getContextPath()+"/user/login_form.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
