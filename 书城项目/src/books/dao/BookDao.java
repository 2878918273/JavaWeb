package books.dao;

import books.pojo.Book;
import java.util.List;

/**
 * @author wx
 * @create 2023-05-19 9:23
 */
public interface BookDao {

    //添加
    public int addBook(Book book);
    //删除
    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryForPageItems(int begin, int pageSize);

    public Integer queryForPageTotalCountByPrice(int min, int max);

    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
