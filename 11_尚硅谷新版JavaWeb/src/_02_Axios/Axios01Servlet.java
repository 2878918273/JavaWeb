package _02_Axios;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-06-01 10:18
 */

@WebServlet("/axios01.do")
public class Axios01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        System.out.println("uname = " + uname);
        System.out.println("pwd= " + pwd);

    }
}
