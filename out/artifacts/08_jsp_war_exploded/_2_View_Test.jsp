<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/13
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>_2_View_Test.jsp页面</h1>
pageContext是否有值：<%=pageContext.getAttribute("key1")%> <br>
request是否有值：<%=request.getAttribute("key2")%> <br>
session是否有值:<%=session.getAttribute("key3")%>   <br>
application是否有值：<%=application.getAttribute("key4")%>
</body>
</html>
