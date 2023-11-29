package _3_Filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-19 15:59
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if("root1".equalsIgnoreCase(username) && "abc123".equalsIgnoreCase(password)){
            req.getSession().setAttribute("username",username);
            System.out.println("嗨嗨嗨，我进来了");
        }else{
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
