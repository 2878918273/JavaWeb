<%@ page import="草稿.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/14
  Time: 8:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<Student> studentList = (ArrayList<Student>)request.getAttribute("sl");
    %>

    <%
      for(Student s:studentList){%>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getName()%></td>
        <td><%=s.getAge()%></td>
    </tr><br />
    <%  }
    %>
</body>
</html>
