
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面刷新</title>
</head>
<body>
<input type="text" id="region">
<input type="button" value="查询" id="search">
<table>
    <thead>
    <tr>
        <th>代理商ID</th>
        <th>代理商编号</th>
        <th>代理商名称</th>
        <th>代理商区域</th>
    </tr>
    </thead>
    <tbody id="dataBox"></tbody>
</table>
</body>
<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
    $(function (){
        $("#search").click(function (){
            /*$("#dataBox").load("searchAgents?region=" + $("#region").val());*/
            $.ajax({
                url: "searchAgents",
                type: "get",
                data: {region: $("#region").val()},
                //说明服务器端要返回一个json格式的数据 否则前端会报错
                /*dataType: "application/json",*/
                success: function (resp) {
                    let tbody = $("#dataBox");
                    //首先清空tbody中的所有内容
                    tbody.empty();
                    for(let i = 0; i < resp.length; i++){
                        let tr = $("<tr></tr>");
                        tr.append($("<td>" + resp[i].aid + "</td>"))
                        tr.append($("<td>" + resp[i].ano + "</td>"))
                        tr.append($("<td>" + resp[i].aname + "</td>"))
                        tr.append($("<td>" + resp[i].aregion + "</td>"))
                        tbody.append(tr)
                    }
                }
            })
        })
    })
</script>
</html>
