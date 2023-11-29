package _01_JspView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/* Jsp
1. 什么是jsp，它有什么作用?
jsp的全称是java server pages。java的服务器页面。
jsp的主要作用是代替Servlet程序回传html页面的数据
因为Servlet程序回传html页面数据是一件非常繁琐的事情。开发成本和维护成本都极高

2. jsp如何访问：
    jsp页面和html页面一样，都是存放在web目录下。访问也跟访问html页面一样

3.jsp的本质是什么
    jsp页面本质上是一个Servlet程序。
    当我们第一次访问jsp页面的时候Tomcat服务器会帮我们把jsp页面翻译成为一个java源文件。并且对它进行编译。
    并且对它进行编译成为.class字节码程序。

    跟踪源代码发现，jsp 继承了 HttpJspBaes类，HttpJspBaes类继承了HttpServlet类。
    jsp翻译出来的java类，它间接继承了HttpServlet类。也就是说，翻译出来的是一个Servlet程序




*/

/**
 * @author wx
 * @create 2023-05-12 15:58
 */
public class _1_View extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过响应的回流回传html页面数据
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("<!DOCTYPE html>\r\n");
        writer.write("<html lang=\"en\">\r\n");
        writer.write("<head>\r\n");
        writer.write("<meta charset=\"UTF-8\">\r\n");
        writer.write("<title>Title</title>\r\n");
        writer.write("</head>\r\n");
        writer.write("<body>\r\n");
        writer.write("这是html页面数据\r\n");
        writer.write("</body>\r\n");
        writer.write("</html>\r\n");


    }
}


/*
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  这是html页面数据
</body>
</html>
*/