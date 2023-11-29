package _3_Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-19 16:51
 */
public class Filter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("嗨嗨嗨，是我，2号");
        System.out.println("Filter2线程" + Thread.currentThread().getName());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter2线程" + Thread.currentThread().getName());
        System.out.println("走了，2号");

    }

    @Override
    public void destroy() {

    }
}