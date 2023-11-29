package books.dao;

import books.pojo.Order;

import java.util.List;

/**
 * @author wx
 * @create 2023-05-27 10:49
 */
public interface OrderDao {

    //保存订单
    public int saveOrder(Order order);

    //查询全部订单
    public List<Order> queryOrders();

    //修改订单状态
    public int changeOrderStatus(String orderId,int status);

    //根据用户编号查询订单信息
    public Order queryOrderByUserId(Integer userId);




}
