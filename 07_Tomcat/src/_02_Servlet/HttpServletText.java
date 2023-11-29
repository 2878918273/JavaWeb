package _02_Servlet;

/*
通过继承HttpServlet实现Servlet程序
一般在实际项目开发中，都是使用继承HttpServlet类的方式去实现Servlet程序
    1.编写一个类去继承HttpServlet类
    2.根据业务需要重写doGet或doPost方法
    3.到web.xml中的配置Servlet程序的访问地址
*/


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-10 8:47
 */
public class HttpServletText extends HttpServlet {

    /**
     * doGet() 在get请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get:我为天帝");
    }

    /**
     * doPost() 在post请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post:当镇杀世间一切敌");
    }
}
