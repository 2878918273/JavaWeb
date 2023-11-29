<%--
  Created by IntelliJ IDEA.
  User: w'x
  Date: 2023/5/15
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080//09_EL_JSTL/UploadServlet1" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="username"> <br />
    照片:<input type="file" name="photo"> <br />
    <input type="submit" value="上传">
</form>

</body>
</html>
<%--
文件的上传和下载
    文件的上传和下载，是非常常见的功能。很多的系统或者软件中都经常使用文件的上传和下载。
    比如：QQ头像，就使用了上传
    邮箱中也有附件的上传和下载

1. 文件的上传和下载
        （1）要有一个form标签，method=post请求
        （2）form标签的encType属性值必须为multipart/form-data值
        （3）在form标签中使用input type=file添加上传的文件
        （4）编写服务器代码（Servlet）接收，处理上传的数据

2. Content-Type 表示提交的数据类型
    multipart/form-data 表示提交的数据，以多段（每一个表单项一个数据段）的形式进行拼接，然后以二进制流的形式发送给服务器

    boundary表示每段数据的分隔符
    ------WebKitFormBoundaryQTAYmmiuJN2C8qZ1是由浏览器每次都随机生成。它就是每段数据的分隔符


--%>