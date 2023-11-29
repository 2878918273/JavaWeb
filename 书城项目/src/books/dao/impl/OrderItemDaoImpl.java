package books.dao.impl;

import books.dao.OrderItemDao;
import books.pojo.OrderItem;

/**
 * @author wx
 * @create 2023-05-27 13:49
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {


    //保存订单项
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getOrderId());
    }

    //根据订单号查询订单明细
    @Override
    public OrderItem queryOrderItemsByOrderId(String OrderId) {
        String sql = "select id,name,price,total_money,count,order_id from t_order_item where order_id = ?";
//        return queryForLsit(OrderItem.class,sql,OrderId);
        return null;
    }
}
