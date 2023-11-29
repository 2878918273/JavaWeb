package books.test;

import books.pojo.Book;
import books.pojo.Page;
import books.service.BookService;
import books.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wx
 * @create 2023-05-20 14:52
 */
public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"完美世界",3000,"辰东",3001,3002,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(14);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(5,"圣墟",4000,"辰东",4001,4002,"static/img/default2.jpg"));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(5);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for(Book book :books){
            System.out.println(book);
        }
    }

    @Test
    public void pages() {
        Page<Book> items = bookService.page(1, Page.PAGE_SIZE);
        System.out.println(items.getItems());
    }


}