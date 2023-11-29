package _04_HttpServletRequest;

/*
HttpServletRequest类
    HttpServletRequest类有什么作用。
    每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的Http协议信息解析好封装到Request对象中的。
    然后传递到service方法(doGet和doPost)中给我们使用。我们可以通过HttpServletRequest对象，获取到所有请求的信息。

    常用方法
    1.getRequestURI()           获取请求的资源路径
    2.getRequestURL()           获取请求的统一资源定位符（绝对路径）
    3.getRemoteHost()           获取客户端的ip地址
    4.getHeader()               获取请求头
    5.getParameter()            获取请求的参数
    6.getParameterValues()      获取请求的参数（多个值的时候使用）
    7.getMethod()               获取请求的方式（GTE或POST）
    8.getAttribute(key)         获取域数据
    9.setAttribute(key,vlaue)   设置域数据
    10.getRequestDispatcher()   获取请求转发对象

*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-10 16:39
 */
public class _1_View extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.getRequestURI()           获取请求的资源路径
        System.out.println("URI = " + req.getRequestURI());

//        2.getRequestURL()           获取请求的统一资源定位符（绝对路径）
        System.out.println("URL = " + req.getRequestURL());

//        3.getRemoteHost()           获取客户端的ip地址
        System.out.println("客户端 IP地址 = " +req.getRemoteHost() );

//        4.getHeader()               获取请求头
        //请求头有很多个，输入参数指定请求头
        System.out.println("请求头 = " + req.getHeader("User-Agent"));
//        7.getMethod()               获取请求的方式（GTE或POST）
        System.out.println(req.getMethod());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}