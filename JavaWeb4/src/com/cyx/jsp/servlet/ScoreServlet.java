package com.cyx.jsp.servlet;

import com.cyx.jsp.pojo.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/showScore")
public class ScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("zhangsan", new Score("张三",80.5));
        List<Score> scores = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            scores.add(new Score("李四" + i, 70 + i));
        }
        req.getSession().setAttribute("scores", scores);
        resp.sendRedirect("score.jsp");
    }
}
