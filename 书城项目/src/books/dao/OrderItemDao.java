package books.dao;

import books.pojo.OrderItem;

/**
 * @author wx
 * @create 2023-05-27 11:01
 */
public interface OrderItemDao {
    //保存订单项
    public int saveOrderItem(OrderItem orderItem);

    //根据订单号查询订单明细
    public OrderItem queryOrderItemsByOrderId(String OrderId);


}
