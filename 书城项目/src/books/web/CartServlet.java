package books.web;

import books.pojo.Book;
import books.pojo.Cart;
import books.pojo.CartItem;
import books.service.BookService;
import books.service.impl.BookServiceImpl;
import books.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wx
 * @create 2023-05-25 10:50
 */
public class CartServlet extends BaesServlet{

     BookService bookService = new BookServiceImpl();

    protected void getajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html;charset=UTF-8");
        //获取请求参数的商品编号id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookByIdi(id): Book得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为CartItem项
        CartItem cartItem = new CartItem(book.getId(), book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);

        //6. 返回购物车总的商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap = new HashMap<String,Object>();

        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);



    }


    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getaddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求参数的商品编号id
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookByIdi(id): Book得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为CartItem项
        CartItem cartItem = new CartItem(book.getId(), book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        System.out.println(cart);
        //重定向回原来商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getDeleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");

        if(cart != null){
            //删除 购物车商品项
            cart.deleteItem(id);
            //重定向回原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getClear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if(cart != null){
            //清空购物车
            cart.clear();
            //重新定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }


    /**
     * 更新商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUpdateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 商品编号，商品数量
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),1);
        //获取Cart购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");

        if(cart != null){
            //修改商品数量
            cart.updateCount(id,count);
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }


    }


}
