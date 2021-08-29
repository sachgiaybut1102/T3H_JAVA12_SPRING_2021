<%--
  Created by IntelliJ IDEA.
  User: minhs
  Date: 8/22/2021
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Demo upload File</h1>
<div>
    <form action="" method="post" enctype="multipart/form-data">
        Chọn hình ảnh:
        <input type="file" value="Upload File" name="file">
        <input type="submit" value="submit">
    </form>
</div>
<div>
    <h3>Image file uploaded</h3>
    <img src="${pageContext.request.contextPath}/images/${filename}">
</div>
</body>
</html>
