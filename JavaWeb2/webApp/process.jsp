
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*String username = request.getParameter("username");//获取参数username的值
    String password = request.getParameter("password");//获取参数password的值
    if("admin".equals(username) && "123456".equals(password)){
        //将用户名和密码存储在session中 session是针对用户的 只有用户本人能获取存储的数据
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        //设置session超时时间为5秒
        session.setMaxInactiveInterval(5);

        //页面重定向至主页面
        //response.sendRedirect("main.jsp");

        //从请求中获取一个请求转发的对象 上一次请求的信息 转发的对象也应该清楚
        //因此可以从转发的新的对象获取上一次转发的信息
        RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
        rd.forward(request, response);
    }*/

    String username = request.getParameter("username");//获取参数username的值
    String password = request.getParameter("password");//获取参数password的值
    String rememberMe = request.getParameter("rememberMe");//获取参数rememberMe的值
    if("admin".equals(username) && "123456".equals(password)){
        session.setAttribute("username", username);
        //只有登陆成功其勾选了记住密码的情况下才会记住密码
        if(!"on".equals(rememberMe)){
            username = "";
            password = "";
            rememberMe = "";
        }
        Cookie usernameCookie = new Cookie("username", username);
        Cookie passwordCookie = new Cookie("password", password);
        Cookie rememberMeCookie = new Cookie("rememberMe", rememberMe);
        //记住密码是服务端对用户操作的一种响应 这个响应就是使用cookie来存储账号和密码
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
        response.addCookie(rememberMeCookie);
        //页面重定向至主页面
        response.sendRedirect("main.jsp");
    }
%>