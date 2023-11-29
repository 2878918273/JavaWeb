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
import java.util.List;

/**
 * @author wx
 * @create 2023-05-20 15:10
 */
public class BookServlet extends BaesServlet{

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

        page.setUrl("manager/bookServlet?action=page");
        //3. 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4. 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);


    }

    protected void getadd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo +=1;
        //1.获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(new Book(), req.getParameterMap());
        //2.调用BookServie.addBook()保存图书
        bookService.addBook(book);
        //3.跳到图书列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);


    }
    protected void getdelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取请求的参数id，图书编号
        int id  = WebUtils.parseInt(req.getParameter("id"),0);
        //2. 调用bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
        //3. 重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }


    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2. 调用bookService.queryBookByid查询图书
        Book book = bookService.queryBookById(id);
        //3. 保存图书到Request域中
        req.setAttribute("book",book);
        //4. 请求转发到,pages/manaegr/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    protected void getupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(new Book(), req.getParameterMap());
        //2.调用BookService.updateBook( book ); 修改图书
        bookService.updateBook(book);
        //3. 重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + req.getParameter("pageNo"));

    }


    protected void getlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过bookservice查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到Request域中
        req.setAttribute("books",books);
        //3.请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }


}
