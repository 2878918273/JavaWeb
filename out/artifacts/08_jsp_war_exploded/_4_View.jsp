<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/13
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主体内容<br>
    <%--
        <%@ niclude file="" %>就是静态包含
            file属性指定你要包含的jsp页面的路径
            地址中第一个斜杠 / 表示为http://ip:port/工程路径/ 映射到代码web目录

            静态包含的特点：
                1. 静态包含不会翻译被包含的jsp页面
                2. 静态包含其实就是把被包含的jsp页面的代码拷贝到包含的位置执行
     --%>
<%--    <%@include file="_4_View_include.jsp"%>--%>

    <%--
         <jsp:include page=""></jsp:include>  这是动态包含
         page 属性是指定你要包含的jsp页面的路径
         动态包含也可以像静态包含一样，把被包含的内容执行输出到包含的位置

         动态包含的特点：
            1.动态包含会把包含的jsp页面也翻译成为java代码
            2.动态包含底层代码使用如下代码去调用被包含的jsp页面执行输出
                JspRuntimeLibrary.include(request,response,"路径/文件",out,false);
            3.动态包含，还可以传递参数
    --%>
    <jsp:include page="_4_View_include.jsp">
        <jsp:param name="username" value="yixingll" />
        <jsp:param name="password" value="abc123" />
    </jsp:include>

    <%--
        <jsp:forward page=""></jsp:forward> 是请求转发标签，它的功能就是请求转发
        page 属性设置请求转发路径
    --%>
    <jsp:forward page="_2_View.jsp"></jsp:forward>
</body>
</html>
<%--
jsp的常用标签
（a）jsp静态包含
    一个页面：
        头部信息
        主体内容
        脚叶内容            一个单独的jsp页面只维护一份，改一处，其它都统一被修改


（b）jsp动态包含
（c）jsp标签-转发
--%>