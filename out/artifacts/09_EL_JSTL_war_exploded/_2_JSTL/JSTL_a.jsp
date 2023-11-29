<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/14
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- core核心库的使用
    1. <s:set />
        作用：set标签可以往域中保存数据

        域对象.serAttribute(ke,value);
        scope 属性设置保存到哪个域
            page表示PageContext域（默认值）
            request表示Requst域
            session表示Session域
            apllcation表示ServletContext域
        var属性设置key
        value属性设置值
 --%>
保存之前：${requestScope.abc} <br/>
<c:set scope="request" var="javaweb" value="abc123"/>
保存之后：${requestScope.javaweb}<br/>

<hr>
<%--
2.<c:if />
    if标签用来做if判断。
    test属性表示判断的条件（使用EL表达式输出）
--%>
<c:if test="${16 == 16}">
    <h3>若为true就输出</h3>
</c:if>

<hr>
<%--
3. <c:choose><c:when><c:otherwise>标签
作用:多路判断.跟switch...case...default非常接近

    choose标签开始选择判断
    when标签表示每一种判断情况
        test属性表示当前判断情况的值
    otherwise标签表示剩下的情况

    <c:choose><c:when><c:otherwise>标签使用时需要注意的点:
        1.标签里不能添加html注释,要使用jsp注释
        2. when标签的父标签一定要是choose标签 (若上一级标签不是choose标签就会报错)
--%>

<%--
4. <c:forEach />
作用:遍历输出使用
    begin 设置开始的索引
    end  设置结束的索引
    var  表示循环的变量(也是当前正在遍历到的数据)
    for(int i = 1 ; i <= 10 ; i++){}

--%>
<%--1. 遍历1到10,输出--%>
<c:forEach begin="1" end="10" var="i">
    第${i}行 <br/>
</c:forEach>

<hr>
<%--
    2. 遍历Object数组
--%>
<%
    request.setAttribute("arr", new String[]{"a", "b", "c", "d"});
%>

<c:forEach items="${requestScope.arr}" var="item">
    ${item} <br>
</c:forEach>


<%--
    3. 遍历List集合...list中存放Person类,有属性:编号,用户名,密码,年龄,电话信息

    items 表示遍历的集合
    var   表示遍历到的数据
    begin 表示遍历的开始索引值
    end   表示结束的索引值
    step  属性表示遍历的步长值
    varStatus 表示当前遍历到的数据的状态
--%>

<%-- 补充
<c:forEach item="集合" var="当前遍历到的数据" varStatus="表示遍历到的数据的状态" begin="开始的索引值" end="结束的索引值" step="表示遍历的步长值" >
</c:forEach>

varStatus 表示当前遍历到的数据的状态
通过源码分析,varStatus直接实现了
public interface LooTagStatus{
        public Object getCurrent();     获取当前遍历到的数据
        public int getIndex();          获取遍历的索引
        public int getCount();          遍历的个数
        public boolean isFirst();       表示当前遍历的数据是否是第一条
        public boolean isLast();        表示当前遍历的数据是否是最后一条
        public Integer getBegin();      获取begin属性值
        public Integer getEnd();        获取end属性值
        public Integer getStep();       获取step属性值
}

--%>


<%--
    4.遍历Map集合

--%>
<hr>
<%
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");

//    for(Map.Entry<String,Object> entry : map.entrySet()){}
    request.setAttribute("map", map);

%>

<c:forEach items="${requestScope.map}" var="entry">
    ${entry}、
    ${entry.key}、
    ${entry.value}
    <br/>

</c:forEach>


</body>
</html>
<%--
JSTL标签库
JSTL标签库全称是指JSP Standerd Tag Library JSP标准标签库。是一个不断完善的开放源代码的JSP标签库。
EL表达式主要是为了替换jsp中的表达式脚本，而标签库则是为了替换代码脚本。这样使得整个jsp页面变得更加简洁


--%>