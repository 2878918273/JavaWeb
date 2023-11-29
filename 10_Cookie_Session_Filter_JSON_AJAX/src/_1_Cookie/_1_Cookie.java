package _1_Cookie;
/*
Cookie饼干
1. 什么是Cookie
    1). Cookie翻译过来是饼干的意思
    2). Cookie是服务器通知客户端保存键值对的一种技术
    3).客户端有了Cookie后，每次请求都发送给服务器。
    4). 每个Cookie的大小不能超过4kb

2. 如何创建Cookie
                        Cookie的创建

    客户端（浏览器）                                    服务器（Tomcat）
没有Cookie                ----------------→         1.创建Cookie对象
                                                        Cookie cookie = new Cookie("key1","value1");
                                                    2.通知客户端保存Cookie
                                                        response.addCookie(cookie);
                通过响应头Set-Cookie通知客户端保存Cookie
                    ←----------------------------
                    Set-Cookie:key1=value1
收到响应后，发现有set-cookie响应头，查看Cookie
没有就创建，有就修改

3. 如何获取Cookie
    服务器获取客户端的Cookie只需要一行代码：req.getCookiekies():Cookie[]

4. Cookie值的修改
方案一：
    1）.先创建一个要修改的同名的Cookie对象
    2）.在构造器，同时赋予新的Cookie值。
    3）.调用response.addCookie(Cookie);通知客户端保存修改

方案二：
    1）.先查找到需要修改的Cookie对象
    2）.调用setValue()方法赋予新的Cookie值
    3) .调用response.addCookie()通知客户端保存修改
注：若想保存中文或其它字符，则需要使用BASE64编码

5. Cookie的生命控制
    Cookie的生命控制指的是如何管理Cookie什么时候被销毁（删除）

    setMaxAge()
        正数，表示在指定的秒数后过期
        负数，表示浏览器一关，Cookie就会被删除（默认值是-1）
        零，表示马上删除Cookie

6. Cookie有效路径Path设置
    Cookie的path属性可以有效的过滤哪些Cookie可以发送给服务器。

    CookieA path=/工程路径
    CookieB path=/工程路径/abc

    请求地址如下：
    http://ip:port/工程路径/a.html
        CookieA 发送
        CookieB 不发送
    http://ip:port/工程路径/abc/b.html
        CookieA 发送
        CookieB 发送




7. Cookie练习---免输入用户名登录

*/

import Util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * @author wx
 * @create 2023-05-16 15:12
 */
public class _1_Cookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文响应乱码的问题
        resp.setContentType("text/html;charset=UTF-8");
        createCookie(req,resp);
        getCookie(req,resp);
        updateCookie(req, resp);
        defaultLife(req, resp);
    }

    public void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie = new Cookie("path1","path2");
        //getContextPath() ===> 得到工程路径
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");

    }
    public void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //先找你要删除的cookie对象
        Cookie cookie = CookieUtils.getCookie(req.getCookies() , "key2");
        //判断返回是否为空
        if(cookie != null){
            //调用setMaxAge(0);
            cookie.setMaxAge(0); //表示马上删除，都不需要等待浏览器关闭
            //调用response.addCookie(cookie);
            resp.addCookie(cookie);
        }

    }
    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie cookie = new Cookie("defalutLife" , "defalutLife");
        cookie.setMaxAge(-1); //设置存活时间
        resp.addCookie(cookie);


    }
    public void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        //方案一：
//        //1.先创建一个要修改的同名的Cookie对象
//        //2.在构造器，同时赋予新的Cookie值。
//        Cookie cookie = new Cookie("key1","newvalue1");
//        //3.调用response.addCookie(Cookie);通知客户端保存修改
//        resp.addCookie(cookie);


        //方案二：
//        1）.先查找到需要修改的Cookie对象
        Cookie cookie = CookieUtils.getCookie(req.getCookies(),"key3");
//        2）.调用setValue()方法赋予新的Cookie值
        cookie.setValue("newValue3");
//        3) .调用response.addCookie()通知客户端保存修改
        resp.addCookie(cookie);


        resp.getWriter().write("嗨嗨嗨，修改好了");


    }
    public void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Cookie[] cookies = req.getCookies();

        for(Cookie cookie : cookies){
            //getName方法返回Cookie的key（名）
            //getValue方法返回Cookie的value（值）
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() +"] <br />");
        }

        //查找指定的Cookie （没有现成的方法，需要自己写）
        Cookie iWantCookie = CookieUtils.getCookie(cookies,"key3");

//        for(Cookie cookie2 : cookies){
//            if("key2".equals(cookie2.getName())){
//                iWantCookie = cookie2;
//                break;
//            }
//        }

        if(iWantCookie != null){
            resp.getWriter().write("嗨嗨嗨，找到了");
        }



    }
    public void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("key1","value1");
        //2. 通知客户端保存Cookie
        resp.addCookie(cookie1);

        Cookie cookie2 = new Cookie("key2","value2");
        resp.addCookie(cookie2);

        Cookie cookie3 = new Cookie("key3","value3");
        resp.addCookie(cookie3);

        resp.getWriter().write("Cookie创建成功");

    }
}
