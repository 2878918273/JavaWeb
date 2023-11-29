package _3_Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-19 14:39
 */
public class AdminFilter implements Filter {
    public AdminFilter(){
        System.out.println("1.Filter构造器方法AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2. Filter的init(FilterConfig )初始化");

//        1）获取Filter名称filter-name的内容
        System.out.println("filter-name的值是：" + filterConfig.getFilterName()); //AdminFilter 是wbe.xml中配置的文件名
//        2）获取在Filter中配置的ini-param初始化参数
        System.out.println("ini-param中的参数有：" + filterConfig.getInitParameter("name"));
        System.out.println("ini-param中的参数有：" + filterConfig.getInitParameter("age"));
//        3）获取ServletContext对象
        System.out.println("ServletContext对象：" + filterConfig.getServletContext());
    }

    /*
    doFilter方法，专门用于拦截请求。可以做权限检查
    */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤方法");
        HttpServletRequest httpservletRequest1 = (HttpServletRequest) servletRequest;
        HttpSession session = httpservletRequest1.getSession();

        Object username = session.getAttribute("username");
        //如果等于null，说明还没有登录
        if(username == null){
            System.out.println("嗨嗨嗨，你还不能进");
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else{
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }



    }

    @Override
    public void destroy() {
        System.out.println("4. Filter的destroy()销毁方法");
    }
}
