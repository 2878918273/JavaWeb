<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/18
  Time: 8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    这是登录页面。login.jsp页面<br>

    <form action="LoginServlet1" method="get">
        用户名：<input type="text" name="username" id="username" value="${cookie.username.value}"> <br>
        密码：<input type="password" name="password" id="password"> <br>
        <input type="submit" value="登录">

    </form>
</body>
</html>
