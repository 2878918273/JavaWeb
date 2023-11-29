<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/13
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.write("out输出1<br/>");
    out.write("out输出2<br/>");
    response.getWriter().write("response1输出<br/>");
    response.getWriter().write("response2输出<br/>");

    out.write("---------------------------------------<br/>");
    out.write("12<br />");
    out.print("12<br />");
    out.write("---------------------------------------<br />");
    out.write(16);
    out.write("<br/>");
    out.print(16);
    out.write("<br/>");
    out.write("---------------------------------------<br />");

%>
</body>
</html>
<%--
jsp中的out输出和request.getWriter输出的区别

response中表示响应，我们经常用于设置返回给客户端的内容（输出）
out也是给用户做输出使用的。

当jsp页面中所有代码执行完成后会做两个操作:
1. 执行out.flush()操作，会把out缓冲区中的数据追加写入到rsponse缓冲区末尾
2. 会执行response的刷新操作。把全部数据写给客户端。

由于jsp翻译以后，底层源代码都是使用out来进行输出，所以一般情况下。我们在jsp页面中统一使用out来进行输出。
避免打乱页面输出内容的顺序

out.write() 输出字符串没有问题
out.print()输出任意数据都没有问题（都转换成为字符串后调用的write输出）
深入源码，浅出结论：在jsp页面中，可以统一使用out.print()来进行输出


--%>

