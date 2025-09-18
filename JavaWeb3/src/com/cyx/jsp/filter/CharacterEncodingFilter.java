package com.cyx.jsp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * 字符集编码过滤器
 */
@WebFilter(urlPatterns = "/*", initParams = {
        @WebInitParam(name = "encoding", value = "UTF-8")
})
public class CharacterEncodingFilter implements Filter {
    private String encoding;

    public CharacterEncodingFilter(){
        System.out.println("过滤器创建实例");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤器处理");
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        //多个过滤器会形成一条过滤器链 当前过滤器处理完之后必须要调用doFilter方法
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
