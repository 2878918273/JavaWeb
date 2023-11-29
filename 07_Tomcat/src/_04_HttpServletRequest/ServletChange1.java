package _04_HttpServletRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* 请求的转发
什么是请求的转发？
请求转发是指，服务器收到请求，从一次资源跳转到另一个资源的操作叫请求转发

请求转发的特点：
    1.浏览器地址栏没有变化
    2.他们是一次请求
    3.他们共享Request域中的数据
    4.可以转发到WEB-INF目录下
    5.是否可以访问工程以外的资源

base标签的作用：

*/


/**
 * @author wx
 * @create 2023-05-10 20:55
 */
public class ServletChange1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        //获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在Servlet1（柜台1）中查看参数（材料）Username = "+ username);

        //给材料 盖一个章，并传递到Servlet（柜台2）去查看
        req.setAttribute("key1","柜台1的章");

        //问路：Servlet2(柜台2)怎么走
        /*

        请求转发必须要以斜杠打头，/斜杆表示地址为：http://ip:port/工程名/,映射到IDEA代码的web目录

        */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/ServletChange2");

        //走向Serlet2(柜台2)
        requestDispatcher.forward(req,resp);



    }
}
