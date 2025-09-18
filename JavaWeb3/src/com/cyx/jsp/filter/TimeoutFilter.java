package com.cyx.jsp.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class TimeoutFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        requestURI = requestURI.replace(contextPath, "");
        if("/".equals(requestURI) || "/showUserInfo".equals(requestURI) || requestURI.startsWith("/second")) {
            chain.doFilter(request, response);
        }else {
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user == null) {//说明登录超时了 跳转至登录页面
                response.sendRedirect("second.jsp");
            }else{//没超时 让下一个过滤器做事情
                chain.doFilter(request, response);
            }
        }
    }
}
