<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/10/26
  Time: 上午9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="upload.action" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="photo">
    <br>
    <input type="submit" value="上传">
    <s:fielderror/>
</form>
</body>
</html>
