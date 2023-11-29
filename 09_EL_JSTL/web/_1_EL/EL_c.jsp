<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/14
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    关系运算 --%>
    ${16 == 16} 或 ${ 16 eq 16} <br />
    ${16 != 16} 或 ${ 16 ne 16} <br />
    ${16 < 16}  或 ${16 lt 16}  <br />
    ${16 > 16}  或 ${16 gt 16}  <br />
    ${16 <= 16}  或 ${16 le 16}  <br />
    ${16 >= 16}  或 ${16 ge 16}  <br />
    <hr>
<%-- 逻辑运算 --%>
    ${16 == 16 && 18 > 16 } 或 ${ 16 == 16 and 18 > 16} <br>
    ${16 == 16 || 18 > 16 } 或 ${ 16 == 16 or 18 >16}   <br>
    ${!true} 或 ${not true} <br>
<%-- 算数运算 --%>
    ${16 + 16} <br>
    ${16 - 16} <br>
    ${16 * 16} <br>
    ${18 / 16} 或 ${18 div 16} <br>
    ${16 % 16} 或 ${16 mod 16}<br> 取模

<%--EL表达式 empty运算--%>
    <%
        //1. 值为null的时候，为空
        request.setAttribute("emptyNull",null);
        //2.值为空串的时候，为空
        request.setAttribute("emptyStr","");
        //3.值是Object类型数组，长度为零的时候
        request.setAttribute("emptySum",new int[]{});
        //4.list集合，map数组，元素个数为0的时候
        request.setAttribute("emptylist",new ArrayList());
        request.setAttribute("emptymap",new HashMap());
    %>
    <hr>
    ${empty emptyNull}<br />
    ${empty tyemptyStr}<br />
    ${empty emptySum}<br />
    ${empty emptylist}<br />
    ${empty emptymap}<br />




</body>
</html>
