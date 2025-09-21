package com.cyx.ajax.servlet;

import com.alibaba.fastjson.JSONObject;
import com.cyx.ajax.pojo.Agent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/searchAgents")
public class AgentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String region = req.getParameter("region");
        List<Agent> agents = new ArrayList<>();
        Random r = new Random();
        int count = r.nextInt(20) + 1;
        for (int i = 0; i < count; i++) {
            Agent agent = new Agent();
            agent.setAid(i + 1);
            agent.setAno("ano" + i);
            agent.setAname("代理商" + i);
            agent.setAregion(region);
            agents.add(agent);
        }
        /*req.getSession().setAttribute("agents", agents);
        resp.sendRedirect("data.jsp");*/
        resp.setCharacterEncoding("UTF-8");
        //设置响应头信息 返回的格式是json格式的数据类型
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(JSONObject.toJSON(agents));
        writer.flush();
        writer.close();
    }
}
