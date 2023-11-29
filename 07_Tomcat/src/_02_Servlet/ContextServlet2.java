package _02_Servlet; /**
 * @author wx
 * @create 2023-05-10 13:46
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ContextServlet2", value = "/ContextServlet2")
public class ContextServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        System.out.println("保存之前：Context1获取key1的值是：" + context.getAttribute("key1"));

        context.setAttribute("key1","value1");

        System.out.println("context中key1的值是" + context.getAttribute("key1"));
        System.out.println("context中key1的值是" + context.getAttribute("key1"));
        System.out.println("context中key1的值是" + context.getAttribute("key1"));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
