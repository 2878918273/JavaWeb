package books.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author wx
 * @create 2023-05-18 20:08
 */
public abstract class BaesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");//直接获取指定name名的value值

        try {
            //获取action业务鉴别字符串，获取相应业务，方法，反射对象
            Method declaredMethod = this.getClass().getDeclaredMethod("get" + action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务，方法
            declaredMethod.invoke(this, req, resp);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
