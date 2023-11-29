package _5_AJAX;

import _4_JSON.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-24 20:34
 */
public class AjaxServlet extends BaesServlet{

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("嗨嗨嗨，是我，你爹");

        Person person = new Person(1001,"我为天帝");

        //转换成json格式的字符串
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);

    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("嗨嗨嗨，jQuery方法被调用");

        Person person = new Person(1001,"我为天帝");

        //转换成json格式的字符串
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }

    protected void jQeuryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("嗨嗨嗨，jQuery_Get方法被调用");

        Person person = new Person(1001,"我为天帝");

        //转换成json格式的字符串
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }
    protected void jQeuryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("嗨嗨嗨，jQuery_Post方法被调用");

        Person person = new Person(1001,"我为天帝");

        //转换成json格式的字符串
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }

    protected void jQeuryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("嗨嗨嗨，jQuery_GetJSON方法被调用");

        Person person = new Person(1001,"我为天帝");

        //转换成json格式的字符串
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }


    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("嗨嗨嗨，jQuery_Serialize方法被调用");

        System.out.println("用户名：" + req.getParameter("username"));
        System.out.println("密码：" + req.getParameter("password"));

        Person person = new Person(1001,req.getParameter("username"));

        //转换成json格式的字符串
        Gson gson = new Gson();
        String personToJsonString = gson.toJson(person);
        resp.getWriter().write(personToJsonString);
    }
}
