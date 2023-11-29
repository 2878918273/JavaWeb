package _01_Start;

/*
Thymeleaf -视图模板技术
    在html页面上加载java内存中的数据，这个过程我们称之为渲染（render）
    thymeleaf是用来帮我们做视图渲染的一个技术

1）添加thymeleaf的jar包
2）新建一个Servlet类ViewBaseServlet类（类名自定义）
3）在web.xml中添加配置
    -配置前缀 view-prefix
    -配置后缀 view-suffix
4）使得我们的Servlet继承ViewBaseServlet

5）根据逻辑视图名称得到物理视图名称
    此时视图名称是 index
        那么thymeleaf会将这个逻辑视图名称对应到物理视图上去
        逻辑视图名称 :  index
        物理视图名称： view-prefix + 逻辑视图名称 + view-suffix
        所以真实的视图名称是： /     index    .html
        super.processTemplate("index",request,response);
6）在html页面上使用thymeleaf的标签
    th:if   ,   th:unless   ,   th:each     ,   th:text
-------------------------------------------------------------------
事务：
try{
    autoCommit(false)
    放行():
    commit()；
}catch（Exception e）{
    rollback();
}

当前难点：需要保证操作使用的都是同一个Connection,这样才可以保证三个操作处于一个事务之中


*/

/**
 * @author wx
 * @create 2023-05-31 10:18
 */
public class _3_Thymeleaf {
}
