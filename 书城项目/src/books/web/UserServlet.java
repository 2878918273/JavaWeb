package books.web;

import books.pojo.User;
import books.service.UserService;
import books.service.impl.UserServiceImpl;
import books.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author wx
 * @create 2023-05-18 18:29
 */
public class UserServlet extends BaesServlet  {

    private UserService userService = new UserServiceImpl();

    protected void getajaxExistsUsername (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        //调用userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装成为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);



    }

    protected void getlogout (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1）销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
//        2）重定向到首页或登录页面
        resp.sendRedirect(req.getContextPath());
    }

    protected void getlogin (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User login = userService.login(new User(username, password));
        System.out.println(login);
        if(login != null){
            //登录成功  跳转到成功登录页面

            //保存用户登录的信息到session域中
            req.getSession().setAttribute("user",login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else{
            //跳回登录页面
            //把错误信息和回显的表单项信息保存到request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }

    }

    protected void getregist (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


        //        1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user1 = WebUtils.copyParamToBean(new User(),req.getParameterMap());

//        2.检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
//        3. 检查用户名是否可用
            if (userService.existsUsername(username)) {


                req.setAttribute("msg", "用户名[" + username + "]已存在!");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //调用servie保存到数据库
                userService.registUser(new User(username, password, email));
                //跳转到成功注册页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);

            }
        } else {
            //把回显信息保存到Request域中
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);

            req.setAttribute("email", email);

            System.out.println("验证码错误[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}
