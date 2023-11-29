<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/18
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临天帝书城</span>
<a href="pages/order/order.jsp">我的订单</a>
<a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;
<a href="index.jsp">返回</a>