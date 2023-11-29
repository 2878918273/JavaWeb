<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/18
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String scheme = request.getScheme()
            +"://"
            + request.getServerName()
            +":"
            + request.getServerPort()
            + request.getContextPath()
            +"/"
            ;

    pageContext.setAttribute("basePath",scheme);
%>

<!--    写base标签，永远固定相对路径跳转的结果-->
<base href="<%=scheme%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>