package books.service;
//  编写图书模块的Service和测试
import books.pojo.Book;
import books.pojo.Page;

import java.util.List;

/**
 * @author wx
 * @create 2023-05-20 14:37
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(int pageNo, int pageSize);

    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
