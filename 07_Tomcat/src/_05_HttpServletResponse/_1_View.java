package _05_HttpServletResponse;
/*
HttpServletResponse类

1.HttpServletResponse类的作用
    HttpServletResponse类和HttpServletRequest类一样，每次请求进来，Tomcat服务器都会创建一个Response对象传递给Servlet程序去使用。
    HttpServletRequest表示请求过来的信息，HttpServletResponse表示所有响应的信息，我们如果需要设置返回给客户端的信息，
    都可以通过HttpServletResponse对象来进行设置。

2.两个输出流的说明。
    字节流 getOutputStream();      常用于下载（传递二进制数据）
    字符流 getWrite();             常用于回传字符串（常用）
    两个流同时只能使用一个。
    使用了字节流，就不能再使用字符流，反之亦然，否者就会报错

3.如何往客户端回传数据


*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wx
 * @create 2023-05-12 9:19
 */
public class _1_View extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决响应的中文乱码
        System.out.println(resp.getCharacterEncoding()); //默认 ISO-8859-1

        //设置服务器字符集为UTF-8
//        resp.setCharacterEncoding("utf-8");
//
        //通过响应头，设置浏览器也使用UTF-8字符集
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //它会同时设置服务器和客户端都使用UTF-8字符集，还设置；响应头  （推荐）
        //（注意：此方法只有在获取流对象之前调用才有效）
        resp.setContentType("text/html;charset=UTF-8"); //中间以;相隔，格式参考响应标头中Content-Type:


        //要求：往客户端回传字符串数据
        PrintWriter writer = resp.getWriter();
        writer.write("我为天帝");

        //        resp.getOutputStream(); //同时使用了两个响应流，就报错
    }
}
