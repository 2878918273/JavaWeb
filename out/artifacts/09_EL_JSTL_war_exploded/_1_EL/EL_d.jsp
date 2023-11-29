<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/14
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--${ 1 == 2 ? 1:2}--%>

<%
    pageContext.setAttribute("key1","pageContext1");
    request.setAttribute("key2","request2");
    session.setAttribute("key3","session3");
    application.setAttribute("key4","application4");
%>
<%--选选择性输出--%>
    ${pageScope.key1}

</body>
</html>
<%--
三元运算
    表达式1?表达式2:表达式3
    如果表达式1的值为真，返回表达式2的值，如果表达式1的值为假，返回表达式3的值。

"."点运算 和 [] 中括号运算符
    .运算，可以输出Bean对象中某个属性的值
    []中括号运算，可以输出有序集合中某个元素的值，并且[]中括号运算，还可以输出map集合中key里含有特殊字符的值。

    Map<Stirng,Object> map1 = new HashMap<String,Object>();
    map1.put("a.a.a","value1");
    map1.put("b+b+b","value2");
    map1.put("c-c-c","value3");

    取出
    ${map1["a.a.a"]}

--%>
<%--
EL表达式的11个隐含对象
    EL表达式中11个隐含对象，是EL表达式中自己定义的，可以直接使用。
        变量                      类型                      作用
     pageContext            PageContextImpl             它可以获取jsp中的九大内置对象

     pageScope              Map<String,Object>          它可以获取pageContext域中的数据
     requestScope           Map<String,Object>          它可以获取Request域中的数据
     sessionScope           Map<String,Object>          它可以获取Session域中的数据
     applicationScope       Map<String,Object>          它可以获取ServletContext域中的数据

     param                  Map<String,String>          它可以获取请求参数值
     paramValues            Map<String,String[]>        可以获取请求参数的多个值

    header                  Map<String,String>          它可以获取请求头的信息
    headerValues            Map<String,String[]>        可以获取请求头的信息的多个值

    cookie                  Map<String,Cookie>          可以获取当前请求的Cookie信息
    initParam               Map<String,String>          它可以获取在web.xml中配置的<context-param>上下文参数



--%>