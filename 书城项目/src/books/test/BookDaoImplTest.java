package books.test;

import books.dao.BookDao;
import books.dao.impl.BookDaoImpl;
import books.pojo.Book;
import books.pojo.Page;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wx
 * @create 2023-05-20 14:09
 */
public class BookDaoImplTest {
     private BookDao bookDao = new BookDaoImpl();


    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"仙逆",1000,"耳根",1001,1002,null));

    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(10);

    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(20,"遮天",2000,"辰东",2001,2002,null));
    }

    @Test
    public void queryBookById() {
        Book bookId = bookDao.queryBookById(10);
        System.out.println(bookId);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for(Book b : books){
            System.out.println(b);
        }

    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }
    @Test
    public void queryForPageItems() {
        List<Book> items = bookDao.queryForPageItems(2, Page.PAGE_SIZE);
        for(Book book:items){
            System.out.println(book);
        }

    }

    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }


    @Test
    public void queryForPageItemsByPrice() {
        List<Book> items = bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,100);
        for(Book book:items){
            System.out.println(book);
        }

    }


}