<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/13
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>

</table>
<tr>hahaihai</tr> <br>
<%
    for (int i = 1; i < 10; i++) {
%>
<tr>
<%
    for (int j = 1; j < i + 1; j++) {
%>
    <td><%=i+" * "+j +" = "+ (i*j)%></td>
<%
    }
%>
</tr><br/>
<%
    }
%>
</body>
</html>
