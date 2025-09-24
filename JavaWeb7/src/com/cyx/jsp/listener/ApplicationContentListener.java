package com.cyx.jsp.listener;

import com.cyx.jsp.jdbc.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebListener
public class ApplicationContentListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet上下文初始化");
        //获取Servlet上下文
        ServletContext sc = sce.getServletContext();
        String jdbcConfig = sc.getInitParameter("jdbcConfig");
        InputStream is = this.getClass().getResourceAsStream(jdbcConfig);
        Properties props = new Properties();
        try {
            props.load(is);
            JdbcUtil.InitDataSource(props);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet上下文销毁");
        JdbcUtil.DestroyDataSource();
    }
}
