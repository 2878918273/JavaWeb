package _04_HttpServletRequest;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-10 20:56
 */
public class ServletChange2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在Servlet2（柜台2）中查看参数（材料）Username = "+ username);

        // 查看柜台1是否有盖章

        Object key1 =req.getAttribute("key1");
        System.out.println("柜台1是否有章 : " + key1);

        //处理自己的业务
        System.out.println("Servlet2 处理自己的业务");


    }
}
