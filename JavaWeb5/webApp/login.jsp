<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AJAX登录</title>
</head>
<body>
<form action="" method="post">
    <div>
        <input type="text" name="username" id="username">
    </div>
    <div>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <input type="button" value="登录" id="loginBtn">
    </div>
</form>
</body>
<%--<script type="text/javascript" src="js/ajax.js"></script>--%>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
    $(function (){
        $("#loginBtn").click(function (){
            $.ajax({
                url: 'login',
                type: 'post',
                contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
                data: {username: $("#username").val(), password: $("#password").val()},
                success: function (resp){
                    if (resp === '0') {
                        alert("账号或密码错误")
                    } else {
                        alert("登录成功")
                    }
                }
            })
        })
    })
    /*document.getElementById("loginBtn").onclick = function () {
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        ajax({
            url: 'login',
            method: 'post',
            contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
            data: {username: username, password: password},
            success: function (resp){
                if (resp === '0') {
                    alert("账号或密码错误")
                } else {
                    alert("登录成功")
                }
            }

        })*/
        /*let xmlHttpRequest;
        if (window.ActiveXObject) {//检测window中是否存在ActiveXObject对象
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        } else {
            xmlHttpRequest = new XMLHttpRequest();
        }
        xmlHttpRequest.onreadystatechange = function () {
            if (xmlHttpRequest.readyState === 4) {//就绪状态为4时表示已经将服务器传输回来的信息读取完毕
                if (xmlHttpRequest.status === 200) {//HTTP状态码为200的时候说明该请求处理完成
                    let result = xmlHttpRequest.responseText;
                    if (result === '0') {
                        alert("账号或密码错误")
                    } else {
                        alert("登录成功")
                    }
                }
            }
        }
        xmlHttpRequest.open("post", "login", true)
        //POST方式发送请求时，携带数据一定要添加请求头，设置传输数据的类型
        //为application/x-www-form-urlencoded其作用将键值对的参数用&连接起来，
        //如果有空格，将空格转换为+加号；有特殊符号，将特殊符号转换为ASCII HEX值
        xmlHttpRequest.setRequestHeader('content-type', 'application/x-www-form-urlencoded;charset=UTF-8');
        //post请求发送数据需要在方法中
        xmlHttpRequest.send("username=" + username + "&password=" + password);*/
    //}
</script>
</html>
