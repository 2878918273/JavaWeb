<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/19
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("target.jsp页面执行了");
        System.out.println("target.jsp页面的线程" + Thread.currentThread().getName());
    %>
</body>
</html>
