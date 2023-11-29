package books.pojo;

/**
 * @author wx
 * @create 2023-05-27 10:39
 */
public class OrderItem {
    private Integer id;
    private String name; //商品名
    private double price;//商品单价
    private double totalMoney; //商品总金额
    private Integer count; //商品数量
    private String orderId; // 订单编号

    public OrderItem() {
    }

    public OrderItem(int id, String name, double price, double totalMoney, Integer count, String orderId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.totalMoney = totalMoney;
        this.count = count;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", totalMoney=" + totalMoney +
                ", count=" + count +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
