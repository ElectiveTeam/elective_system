<%--
  Created by IntelliJ IDEA.
  User: 84261
  Date: 2019/1/8
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login/login" method="post">
    <input type="text" name="flag"/>
    <button type="submit">提交</button>
</form>
</body>
</html>
