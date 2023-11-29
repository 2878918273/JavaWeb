<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--  静态包含 base标签 css 样式，JQuery文件  --%>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            //给删除绑定单击事件
            $("a.deleteItem").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");
            });

            //清空购物车
            $("a.clearItem").click(function () {
                return confirm("确定要清口购物车？");
            });

            //更新商品数量    给输入框绑定onchange内容发生改变事件（当内容不变时不操作，当内容改变时才操作）
            $("input.updateCount").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var count = this.value;
                var id = $(this).attr("bookId");
                if (
                    confirm("你确定要将【" + name + "】商品数量修改为:" + count + "吗？")
                ) {
                    // 发起请求。给服务器保存修改
                    location.href = "http://localhost:8080/book/cartServlet?action=UpdateCount&count=" + count + "&id=" + id;
                } else {
                    this.value = this.defaultValue;
                }
            });

        });
    </script>

</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <div>
        <%--   静态包含，登录成功之后的菜单     --%>
        <%@ include file="/pages/common/login_success_menu.jsp" %>
    </div>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <%--    如果购物车为空    --%>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="http://localhost:8080/book/index.jsp">穷逼，快去买东西</a></td>
            </tr>
        </c:if>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
                    <input class="updateCount" type="text" style="width:80px"
                        <%--我们可以通过自定义属性记录下我们想要的信息 --%>
                           bookId="${entry.value.id}"
                           value="${entry.value.count}">
                </td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a class="deleteItem" href="cartServlet?action=DeleteItem&id=${entry.value.id}">删除</a></td>
            </tr>
        </c:forEach>


    </table>

    <%--  如果购物车非空才输出页面的内容  --%>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="clearItem" href="cartServlet?action=Clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/order/order.jsp">去结账</a></span>
        </div>
    </c:if>


</div>

<%--静态包含页脚内容--%>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>