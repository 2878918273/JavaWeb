package _1_Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-18 8:14
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("name1001".equalsIgnoreCase(username) && "abc123".equalsIgnoreCase(password)) {
            //登录成功
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60); //当前一个小时有效
            resp.addCookie(cookie);
            System.out.println("登录 成功");

        } else {
            //登录失败
            System.out.println("登录失败");
        }


    }
}
