package _2_Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-18 8:52
 */
public class SessionServlet extends BaseServlet {

    protected void CreateOrGetsession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        // 创建和获取Session会话对象
        HttpSession session = req.getSession();
        // 判断当前session会话是否是新创建出来的
        boolean aNew = session.isNew();
        //获取session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到sessionid = " + id + "<br />");
        resp.getWriter().write("此session是否是新创建出来的: " + aNew + "<br />");
    }

    // 设置Session域中的数据
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
    }
    //获取Session域中的数据
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取出来的key1的数据是：" + key1);
    }

    protected void DefaultLive(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("默认超时时常为：" + maxInactiveInterval + "（秒）");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取session对象
        HttpSession session = req.getSession();
        //让session会话马上超时
        session.invalidate();

        resp.getWriter().write("Session已经设置为超时（无效）");
    }




}
