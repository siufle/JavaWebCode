<%@ page import="java.util.Arrays" %>
<%@ page import="javax.sound.sampled.AudioFormat" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    //从请求中获取username的值
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String[] channels = request.getParameterValues("channel");

    /*for(String channel : channels) {
        //在ISO_8859_1的编码方式下获取字符串的字节数据
        byte[] bytes = channel.getBytes(StandardCharsets.ISO_8859_1);
        //通过字符串的构造方法进行转码
        String s = new String(bytes, StandardCharsets.UTF_8);
    }*/
%>
<div><%=username%></div>
<div><%=password%></div>
<%--post请求发送的参数信息如果是中文 在页面展示时可能会出现乱码 可以在request对象中
    先设置请求的编码格式 然后再从request对象中取值--%>
<%--get请求发送的参数信息如果是中文 在页面展示时可能会出现乱码 可以使用字符串的转码方式来解决--%>
<div><%=Arrays.toString(channels)%></div>