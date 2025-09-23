<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传和下载</title>
</head>
<body>
    <%--使用form表单进行文件上传的时候必须设置enctype属性为multipart/form-data--%>
    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="text" name="name">
        <input type="file" name="uploadFile">
        <input type="submit" value="上传">

        <input type="file" id="uploadFile">
        <input type="button" value="上传" id="uploadBtn">

        <a href="download?name=截图.png">截图.png</a>
    </form>
</body>
<script type="text/javascript" src="js/jquery-3.7.1.js"></script>
<script type="text/javascript">
    $(function () {
        $("#uploadBtn").click(function () {
            let formData = new FormData();
            formData.append("file",$("#uploadFile")[0].files[0])
            formData.append("name","admin")
            formData.append("sex","man")
            $.ajax({
                url: 'upload',
                type: 'post',
                data: formData,
                processData: false, //告诉jQuery不要处理数据
                contentType: false, //告诉jQuery不要设置内容类型
                success: function (resp) {
                    alert(resp);
                },
                error: function (xhr) {

                }
            })
        })
    })
</script>
</html>
