package _02_Servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/*
Interface Servlet         Servlet接口只是负责定义Servlet程序的访问规范
    ↑
    |实现接口
    |                       GenericServlet类实现了Servlet接口，做了很多空实现
Class GenericServlet       并持有一个ServletConfig类的引用。并对ServletConfig的使用做一些方法。
    ↑
    |继承
    |                       HttpServlet抽取类实现了servlet()方法,并实现了请求的分发处理
Class   HttpServlet             String method = req.getMethod();
    ↑                               GET             POST
    |继承                         doGet()         doPost()        负责抛异常，说不支持GET/POST请求
    |                                       重写
    |               我们只需要根据
Class HttpServlet   自己的业务需要    odGet()      doPost()
                    去重写doGet或
                    doPost方法即可


SerVletConfig类的三大作用   （见，重写的方法中）





*/

/**
 * @author wx
 * @create 2023-05-09 19:52
 */
public class ServletText implements Servlet {

    public ServletText() {
        System.out.println("1.--------构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.-------init初始化方法");

        //SerVletConfig类的三大作用

        //1.可以获取Servlet程序的别名servlet-name的值
        System.out.println("ServletTest程序的别名是：" + servletConfig.getServletName());
        //2.获取初始化参数init-param
        System.out.println("初始化参数user的值是" + servletConfig.getInitParameter("user"));
        System.out.println("初始化参数url的值是" + servletConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.-----service被访问了");
        //类型转换（因为它有个tMethod()方法）
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = servletRequest1.getMethod();
//        System.out.println(method);

        if("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }

    }
    /*
        做get请求的操作

     */
    public void doGet(){
        System.out.println("get请求");
    }

    public void doPost(){
        System.out.println("post请求");
    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4----destroy销毁方法");
    }
}