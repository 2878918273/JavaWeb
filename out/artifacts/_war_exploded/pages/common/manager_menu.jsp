<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/18
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

    <%--  如果用户还没登录,显示登录和注册的菜单  --%>
    <c:if test="${empty sessionScope.user}">
        <a href="pages/user/login.jsp">登录</a> |
        <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
    </c:if>
    <%--   如果登录成功，则显示登录成功之后的用户信息     --%>
    <c:if test="${not empty sessionScope.user}">
        <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临天帝书城</span>
        <a href="pages/order/order.jsp">我的订单</a>
        <a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;
    </c:if>



    <a href="pages/cart/cart.jsp">购物车</a>
    <a href="pages/manager/manager.jsp">后台管理</a>
</div>