package books.dao.impl;

import books.dao.OrderDao;
import books.pojo.Order;
import books.web.BaesServlet;

import java.util.List;

/**
 * @author wx
 * @create 2023-05-27 15:06
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(), order.getStatus(),order.getUserId());

    }

    @Override
    public List<Order> queryOrders() {
        return null;
    }

    @Override
    public int changeOrderStatus(String orderId, int status) {
        return 0;
    }

    @Override
    public Order queryOrderByUserId(Integer userId) {
        return null;
    }
}
