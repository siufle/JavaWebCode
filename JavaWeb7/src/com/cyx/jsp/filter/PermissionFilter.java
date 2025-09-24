package com.cyx.jsp.filter;

import com.cyx.jsp.service.UserService;
import com.cyx.jsp.service.impl.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class PermissionFilter extends HttpFilter {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        String uri = requestURI.replace(request.getContextPath(), "");
        if (uri.endsWith(".jsp") || "/".equals(uri) || "/login".equals(uri) || uri.startsWith("/js")) {
            chain.doFilter(request, response);
        }else{
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if (username == null) {
                System.out.println("登陆超时");
            }else{
                //去数据库查询当前用户是否有访问这个url地址的权限
                if(userService.hasPermission(username,uri)){
                    chain.doFilter(request, response);
                }else{
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter writer = response.getWriter();
                    writer.print("没有访问权限");
                    writer.flush();
                    writer.close();
                }
            }
        }
    }
}
