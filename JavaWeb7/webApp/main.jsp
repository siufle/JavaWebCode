
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<input type="button" value="查询" id="searchBtn">
<input type="button" value="修改" id="updateBtn">
</body>
<script type="text/javascript" src="js/jquery-3.7.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#searchBtn").click(function () {
            $.ajax({
                url: 'search',
                type: 'get',
                data: {},
                success: function (resp) {
                    console.log(resp)
                }
            })
        })
        $("#updateBtn").click(function () {
            $.ajax({
                url: 'update',
                type: 'post',
                contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
                data: {
                    id: 3,
                    name: '王五',
                    sex: '女',
                    age: 23
                },
                success: function (resp) {
                    alert(resp)
                }
            })
        })
    })
</script>
</html>
