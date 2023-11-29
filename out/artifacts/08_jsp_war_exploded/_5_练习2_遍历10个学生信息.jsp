<%@ page import="草稿.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/13
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border:1px red solid;
            width: 600px;
            border-collapse:collapse;
        }
    </style>
</head>
<body>
<%--练习2：jsp输出一个表格，里面有10个学生信息--%>
<%
    List<Student> stuedntList = new ArrayList<Student>();
    for (int i = 1; i <= 10; i++) {
        stuedntList.add(new Student(100 + i, "name" + i, i + 18));
    }
%>
<table>
<%
    for (Student s : stuedntList) {
%>
    <tr>
        <td><%=s.getId()%></td>
        <td><%=s.getAge()%></td>
        <td><%=s.getName()%></td>
    </tr>
<%
    }
%>
</table>

</body>
</html>
