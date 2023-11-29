package _05_HttpServletResponse;
/*
请求重定向
    请求重定向，是指客户端给服务器发请求，然后服务器告诉客户端说，我给你新地址，你去新地址访问。
    叫请求重定向(因为之前的地址可能已经被抛弃)


        客户端（浏览器）                      ①                      服务器(Tomcat)
    http://ip:port/工程路径/response1  -------------->              Response1程序
                                                          随着时间的推移和项目的不断更新，升级，Response1这个接口
    解析Response1的结果。知道已经搬迁          ②            慢慢的被废弃了，由新的接口Response2所取代。
    再次发起新地址的请求                <--------------    有义务告诉客户端，我已搬迁 ===> 响应码 302
                                       响应状态码：302     并且告知新的地址 ===> 响应头 Location
                                   Location响应头，新地址
                                    新地址    ③                    Response2程序
                                       -------------->     Response2程序取代了Reponse1，功能更完善，安全性更高
                                              ④
收到最终的返回。解析展示在页面上         <--------------


请求重定向的特点:
1.浏览器地址栏会发生变化
2.两次请求
3.不共享Request域中的数据
4.不能访问WEB-INF下的资源
5.可以访问工程外的资源

*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-12 14:39
 */
public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我为天帝 Response1");
        //设置状态码032 ， 表示重定向(已搬迁)
//        resp.setStatus(302);
        //设置响应头，说明新的地址在哪里
//        resp.setHeader("Location", "http://localhost:8080/07_Tomcat/Response2");

        //请求重定向的第二种实现方案
        resp.sendRedirect("http://localhost:8080/07_Tomcat/Response2");



    }
}
