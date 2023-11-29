<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/14
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key1","独断万古");
    %>
    表达式脚本输出的值是:<%=request.getAttribute("key1")%>
    EL表达式输出的值是:${key1}
</body>
</html>
