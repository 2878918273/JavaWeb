<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/14
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--获取请求的协议--%>
<%=request.getScheme()%> <br/>
<%--获取请求的服务器ip或域名--%>
<%=request.getServerName()%> <br/>
<%--获取请求的服务器端口号--%>
<%=request.getServerPort()%> <br/>
<%--获取当前工程路径--%>
<%=request.getContextPath()%> <br/>
<%--获取请求的方式--%>
<%=request.getMethod()%>
<%--获取客户端的ip地址--%>
<%=request.getRemoteHost()%>
<%--获取会话的ip编号--%>
<%=session.getId()%>

1. 协议：${pageContext.request.scheme} <br/>
2. 服务器：${pageContext.request.serverName} <br/>
3. 服务器端口：${pageContext.request.serverPort} <br/>
4. 获取工程路径: ${pageContext.request.contextPath} <br/>
5. 获取请求方法:${pageContext.request.method} <br/>
6. 获取客户端ip地址 ${pageContext.request.remoteHost} <br/>
7. 获取会话的id编号 ${pageContext.session.id} <br/>

<hr>

EL表达式其它隐含对象的使用 <br/>
${param}        <br />
username =  ${param.username} <br />
password =  ${param.password} <br />

${paramValues} <br />
values = ${paramValues.username[0]} <br />
<hr>
输出请求头 ：${header} <br />
<br />
输出请求头[User-Agent]的值：${header['User-Agent']} <br />
输出请求头[Connection]的值:${header.Connection}    <br />
输出请求头[User-Agent]的值：${headerValues['User-Agent'][0]} <br />
<hr>

获取Cookie的名称: ${cookie.JSESSIONID.name} <br />
获取Cookie的值： ${cookie.JSESSIONID.value} <br />

<hr>

输出配置文件（web.xml）的值 ${initParam} <br /s>




</body>
</html>
<%--
    PageContext对象的使用
    1. 协议：
    2. 服务器：
    3. 服务器端口：
    4. 获取工程路径:
    5. 获取请求方法
    6. 获取客户端ip地址
    7. 获取会话的id编号

--%>