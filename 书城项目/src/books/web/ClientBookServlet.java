package books.web;

import books.pojo.Book;
import books.pojo.Page;
import books.service.BookService;
import books.service.impl.BookServiceImpl;
import books.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wx
 * @create 2023-05-23 21:04
 */
public class ClientBookServlet extends BaesServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2. 调用BookService.page(pageNo,pageSize):Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/bookServlet?action=page");
        //3. 保存Page对象到Request域中
        req.setAttribute("page",page);
        req.setAttribute("key1","value1");

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }


    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getpageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        //2. 调用BookService.page(pageNo,pageSize):Page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");

        //如果有最小价格参数,追加到分页条的地址栏中
        if(req.getParameter("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        //如果有最大价格参数,追加到分页条的地址栏中
        if(req.getParameter("max") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }

        page.setUrl(sb.toString());
        //3. 保存Page对象到Request域中
        req.setAttribute("page",page);
        req.setAttribute("key1","value1");

        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

}
