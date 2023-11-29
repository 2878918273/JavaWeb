package _02_Servlet; /**
 * @author wx
 * @create 2023-05-10 10:49
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*
ServletContext类
    1.什么是ServletContext
        ServletContext是一个接口，它表示上下文对象
        一个web工程，只有一个ServletContext对象实例
        ServletContext对象是一个域对象 （域对象是服务器在内存上创建的存储空间，用于在不同动态资源（servlet）之间传递与共享数据。）
        ServletContext是在web工程部署启动的时候创建。在web工程停止的时候销毁

                存数据             取数据                 删除数据
    Map         put()               get()                 remove()
    域对象      setAttribute()      getAttribute()       removeAttribute();

    2.ServletContext类的四个作用
        1.获取web.xml中配置的上下文参数   context-param
        2.获取当前的工程路径，格式：/工程路径
        3.获取工程部署后在服务器硬盘上的绝对路径
        4.像Map一样存取数据

*/

@WebServlet(name = "ContextServlet", value = "/ContextServlet")
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println("context2中key1的值是" + context.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();

        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println("Username = " + username + ",Password = " + password);
        //2.获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径：" + context.getContextPath());
        //3.获取工程部署后在服务器硬盘上的绝对路径

        /*
            / 斜杠被服务器解析地址为：http://ip:port/工程名/  映射到IDEA代码的web目录
        */

        System.out.println("当前工程绝对路径"+context.getRealPath("/"));
        //D:\java\workspace_idea1\JavaWeb\out\artifacts\07_Tomcat_war_exploded2\

    }
}
