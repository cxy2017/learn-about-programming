<%--
  Created by IntelliJ IDEA.
  User: cxy
  Date: 2017/12/20
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户管理-创建客户</title>
</head>
<body>
<h1>创建客户界面</h1>
<form method="post" action="/s/FileUpLoadDemo" id="customer_form" enctype="multipart/form-data">
    <div align="center">
        <fieldset style="width: 80%">
            <legend>上传文件</legend><br/>
                <div align="left">上传文件1</div>
                <div align="left">
                    <input type="file" name="file1">
                </div>
                <div align="left">提交文件</div>
                <div align="left">
                    <input type="submit" name="提交">
                </div>

        </fieldset>
    </div>
</form>
</body>
</html>
