package books.test;

import books.dao.OrderDao;
import books.dao.impl.OrderDaoImpl;
import books.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author wx
 * @create 2023-05-27 15:23
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();

        orderDao.saveOrder(new Order("12345678901",new Date(),new BigDecimal(100),0,16));
    }

    @Test
    public void queryOrders() {
    }

    @Test
    public void changeOrderStatus() {
    }

    @Test
    public void queryOrderByUserId() {
    }
}