
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<input type="text" id="username">
<input type="password" id="password">
<input type="button" value="登录" id="loginBtn">
</body>
<script type="text/javascript" src="js/jquery-3.7.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#loginBtn").click(function () {
            $.ajax({
                url: 'login',
                type: 'post',
                contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
                data: {
                    username: $("#username").val(),
                    password: $("#password").val()
                },
                success: function (resp) {
                    if(resp === '1'){
                        window.location.href = "main.jsp"
                    }else if(resp === '0'){
                        alert("密码错误")
                    }else{
                        alert("用户不存在")
                    }
                }
            })
        })
    })
</script>
</html>
