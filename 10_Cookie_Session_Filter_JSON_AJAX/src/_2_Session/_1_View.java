package _2_Session;
/*
Session会话
1）什么是Session会话？
    1.Session就是一个接口（HttpSession）
    2.Session就是会话。它是用来维护一个客户端和服务器之间关联的一种技术
    3.每个客户端都有自己的一个Session会话
    4.Session会话中，我们经常用来保存用户登录之后的信息

2）如何创建Session和获取（id号，是否为新）
    如何创建和获取Session。（它们的APL是一样的）
    request.getSession()
        第一次调用是：创建Session会话
        之后调用都是：获取前面创建好的Session会话对象。

    isNew():判断是不是刚创建出来的（新的）
        true 表示刚创建
        false 表示获取之前创建

    每个会话都有一个身份证号，也就是ID值。而且这个ID是唯一的。
    getId() 得到 Seesion的会话id值。

3）Session域数据的存取
    req.getSession().setAttribute("key1","value1");
    Object key1 = req.getSession().getAttribute("key1");

4）Session生命周期控制  （Session的超时时长指的是，客户端两次请求的最大间隔时长）
    值为正数的时候，设定Session的超时时长。
    负数表示永不超时（极少使用）

    public void setMaxInactiveInterval(int interval) 设置Session的超过时间（以秒为单位），超过指定时长，Session就会被销毁
    public int getMaxInactiveInterval() 获取Session的超时时间

    Session默认的超时时长为1800秒（30分钟）

    因为在Tomcat服务器的配置文件web.xml中有一下默认配置，它就表示配置了当前Tomcat服务器下所有的Session超时配置默认时长为：30分钟。
    <session-config>
        <session-timeout>30</session-timeout>
    </session-config>

    若需要修改，只需要修改web工程下的web.xml配置文件中配置相同的代码，只需修改数值

    使用setMaxInactiveInterval(int interval)来对指定session的时长进行单独设置

5）浏览器和Session之间关联的技术内幕



*/

/**
 * @author wx
 * @create 2023-05-18 8:32
 */
public class _1_View {

}
