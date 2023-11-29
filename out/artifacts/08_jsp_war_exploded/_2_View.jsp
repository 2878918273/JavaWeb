<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/13
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 这是html注释 -->

<%
    // 单行java注释
    /* 多行java注释 */
%>

<%-- 这是jsp注释 --%>

<h1>_2_View.jsp页面</h1>

<%
    pageContext.setAttribute("key1","page1");
    request.setAttribute("key2","request2");
    session.setAttribute("key3","session3");
    application.setAttribute("key4","application4");
%>

pageContext是否有值：<%=pageContext.getAttribute("key1")%> <br>
request是否有值：<%=request.getAttribute("key2")%> <br>
session是否有值:<%=session.getAttribute("key3")%>   <br>
application是否有值：<%=application.getAttribute("key4")%>

<%
//    request.getRequestDispatcher("/_2_View_Test.jsp").forward(request,response);
%>


</body>
</html>
<%--

jsp中的三种注释
（1）html注释
    <!-- 这是html注释 -->
    html注释会被翻译到java源代码中。在_jspService方法里，以out.writer输出到客户端。

（2）jsp注释
    // 单行java注释
    /* 多行java注释 */
        java注释会被翻译到java源代码中。

（3）java注释
     这是jsp注释
jsp注释可以注掉jsp页面中的所有代码。


--%>

<%--
jsp的九大内置对象
jsp中的内置对象，是指Tomcat在翻译jsp页面成为Servlet源代码后，内部提供的九大对象，叫内置对象。
    request         请求对象
    response        响应对象
    pageContext     jsp的上下文对象
    session         会话对象
    application     ServletContext对象
    config          ServletConfig对象
    out             jsp输出流对象
    page            指向当前jsp对象
    exception       异常对象

    其中 有 jsp四大域对象
    四个域对象分别是：
        pageContext     (PageContextlmpl类)              当前jsp页面范围有效
        request         (HttpServletRequest类)           一次会话请求有效
        session         (HttpSession类)                  一次会话范围内有效（打开浏览器访问服务器，直到关闭浏览器）
        application     (ServletContext类)               整个web工程范围内有效（只要web工程不停止，数据都在）

    域对象可以像Map一样存取数据的对象。四个域对象功能一样。不同的是他们对数据的存取范围。

    虽然四个域对象都可以存取数据。在使用上它们是有优先顺序的。
    四个域在使用的时候，优先顺序分别是，它们从小到大的范围的顺序
    pageContext =====>  request ======> session =====> application

--%>