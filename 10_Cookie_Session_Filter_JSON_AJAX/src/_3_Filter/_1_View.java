package _3_Filter;
/*
1. 什么是Filter过滤器
    1）Filter过滤器它是Javaweb的三大组件之一。三大组件分别是：Servlet程序、Listener监听器、Filter过滤器
    2）Filter过滤器它是JavaEE的规范。也就是接口
    3）Filter过滤器它的作用是：拦截请求是，过滤响应

    拦截请求常见的应用场景有：
        1） 权限检查
        2） 日记操作
        3） 事物管理

2.Filter的初体验
要求：在你的web工程下，有一个admin目录。这个admin目录下的所有资源（html页面、jpg图片、jsp文件、等等）都必须是用户登录之后才允许访问的

思考：用户登录之后都会把用户登录的信息保存到Session域中。所以要检查用户是否登录，可以判断Session中是否包含有用户登录的信息即可

Filter过滤器的使用步骤：
    1.编写一个类去实现Filter接口
    2.实现过滤方法doFilter()
    3.到web.xml中去配置Filter的拦截路径


3.Filter的生命周期
    Filter的生命周期包含几个方法
        1.构造器方法
        2.init初始化方法
            第1，2步，在web工程启动的时候执行（Filter已经创建）
        3.doFilter方法
            第3步，每次拦截到请求，就会执行
        4.destroy销毁
            第4步。停止web工程的时候，就会执行（停止web工程，也会销毁Filter过滤器）

4.FilterConfig类
    FilterConfig类见名知义它是Filter过滤器的配置文件类。
    Tomcat每次创建的时候，也会同时创建一个FilterConfig类，这里包含了Filter配置文件的配置信息。

    FilterConfig类的作用是获取Filter过滤器的配置内容
        1）获取Filter名称filter-name的内容
        2）获取在Filter中配置的ini-param初始化参数
        3）获取ServletContext对象



5.FilterChain过滤器链
    Filter  过滤器
    Chain   链，链条
    FilterChain 过滤器链（多个过滤器如何一起工作）

    FilterChain.doFilter()方法的作用
        1.执行下一个Filter过滤器（如果有Filter）
        2.执行目标资源 （没有Filter）
    在多个Filter过滤器执行的时候，它们执行的优先顺序是由它们在web.xml中从上到下配置位置的顺序决定

    多个Filter过滤器的执行的特点：
        1.所有的filter和目标资源默认都执行在同一个线程中
        2.多个Filter共同执行的时候，它们都使用同一个Request对象。

6.Filter的拦截路径
    1.精确匹配
    <url-pattern>/target.jsp</url-pattern>

    2.目录匹配
    <url-pattern>/admin/*</url-pattern>

    3.后缀名匹配
    <url-pattern>*.html</url-pattern>
    以上的配置路径，表示请求地址必须以.html结尾才会拦截到

    Filter过滤器只关心请求的地址是否匹配，不关心请求的资源是否存在！！
 */



/**
 * @author wx
 * @create 2023-05-19 14:21
 */
public class _1_View {
}
