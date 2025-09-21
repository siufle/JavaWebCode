
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="" method="post">
        <div>
            <span>用户名：</span>
            <input type="text" name="username" id="username">
            <span id="tip"></span>
        </div>
    </form>
</body>
<%--<script type="text/javascript" src="js/ajax.js"></script>--%>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
    $(function (){
        $("#username").blur(function (){
            $.ajax({
                url: 'checkUsername',
                type: 'get',
                data: {username: $("#username").val()},
                success: function (resp){
                    let tip = $("#tip")
                    if(resp === '1'){
                        tip.text("该用户已被注册");
                        tip.css("color","red")
                    }else{
                        tip.text("该用户名可以注册")
                        tip.css("color","green")
                    }
                }
            })
        })
    })
    /*let element = document.getElementById("username");
    //为username添加一个失去焦点事件
    element.onblur = function () {
        let value = element.value;
        if(value !== ''){
            ajax({
                url: 'checkUsername',
                method: 'get',
                data: {username: value},
                success: function (resp){
                    let tip = document.getElementById("tip");
                    if(resp === '1'){
                        tip.innerText = "该用户已被注册"
                        tip.style.color = "red"
                    }else{
                        tip.innerText = "该用户名可以注册"
                        tip.style.color = "green"
                    }
                }
            })*/
            /*let xmlHttpRequest;
            if(window.ActiveXObject){//检测window中是否存在ActiveXObject对象
                xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            }else{
                xmlHttpRequest = new XMLHttpRequest();
            }
            xmlHttpRequest.onreadystatechange = function () {
                if(xmlHttpRequest.readyState === 4){//就绪状态为4时表示已经将服务器传输回来的信息读取完毕
                    if(xmlHttpRequest.status === 200){//HTTP状态码为200的时候说明该请求处理完成
                        let result = xmlHttpRequest.responseText;
                        let tip = document.getElementById("tip");
                        if(result === '1'){
                            tip.innerText = "该用户已被注册"
                            tip.style.color = "red"
                        }else{
                            tip.innerText = "该用户名可以注册"
                            tip.style.color = "green"
                        }
                    }
                }
            }
            //get发送数据的方式是在URL地址后面进行数据的拼接
            xmlHttpRequest.open("get","checkUsername?username=" + value,true)
            xmlHttpRequest.send();*/
        //}
    //}
</script>
</html>
