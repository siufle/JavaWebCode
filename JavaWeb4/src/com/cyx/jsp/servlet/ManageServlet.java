package com.cyx.jsp.servlet;

import com.cyx.jsp.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@WebServlet("/showData")
public class ManageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //无论存在request还是session中 EL表达式都可以取到值 优先从request中取
        HttpSession session = req.getSession();
        session.setAttribute("user", new User("李四","女"));
        req.setAttribute("user",new User("张三","男"));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("王五","女"));
        users.add(new User("赵六","男"));
        session.setAttribute("users",users);

        HashMap<String,Object> map = new HashMap<>();
        map.put("admin",90);
        map.put("test",80);
        session.setAttribute("map",map);

        req.getRequestDispatcher("manage.jsp").forward(req, resp);
    }
}
