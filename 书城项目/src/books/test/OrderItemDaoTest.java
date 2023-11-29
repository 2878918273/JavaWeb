package books.test;

import books.dao.OrderItemDao;
import books.dao.impl.OrderItemDaoImpl;
import books.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author wx
 * @create 2023-05-27 15:42
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
//        orderItemDao.saveOrderItem(new OrderItem(null,"仙逆",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));

    }

    @Test
    public void queryOrderItemsByOrderId() {
    }
}