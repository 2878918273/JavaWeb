package _03_Listener;

/*
1.什么是Listener监听器？
    1.Listener监听器是Javaweb三大组件之一，JavaWeb的三大组件分别是：Servelt程序、Filter过滤器、Listener监听器。
    2.Listener它是JavaEE的规范，就是接口
    3.监听器的作用是，监听某种事物的变化，然后通过回调函数，反馈给客户（程序）去做一些想相应的处理。

2. ServletContextListener监听器
    ServletContextListener它可以监听ServletContext对象的创建和销毁。
    ServletContext对象在web工程启动的时候创建，在web工程停止的时候销毁
    监听到创建和销毁之后都会分别调用ServletContextListener监听器的方法反馈。
    两个方法分别是：
    public interface ServletContextListener extends EventListener{

            在ServletContext对象创建之后马上调用，做初始化
        public void contextInitialized(ServletContextEvent sce);

            在ServletContext对象销毁之后调用
        public void contextDestroyed(ServletContextEvent sce);
    }

    如何使用ServletContextListener监听器监听ServletContext对象。
    使用步骤如下：
        1. 编写一个类去实现ServletContextListener
        2. 实现其两个回调方法
        3. 到web.xml中去配置监听器


*/

/**
 * @author wx
 * @create 2023-05-14 9:01
 */
public class _1_View {
}
