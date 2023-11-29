package _1_介绍;

/*
仙王临九天github
分层的目的是为了解耦。解耦就是为了降低代码的耦合度。方便项目后期的维护升级。

    客户端（浏览器）                    JavaEE三层结构                                          数据库
                               Web层/视图展现层     Servicec业务层   Dao持久层
*/

/*
1. 先创建书城需要的数据库和表
2. 编写数据库对应的JavaBean对象。
3. 编写工具类JdbcUtils
4. 编写BaseDao
5. 编写UserDao和测试
6. 编写UserService和测试
 */

/*
项目阶段二：用户注册和登录的实现。
需求1：用户注册
    需求如下：
        1）访问注册页面
        2）填写注册信息，提交给服务器
        3）服务器应该保存用户
        4）当用户已经存在--提示用户注册失败，用户名已存在
        5）当用户不存在---注册成功

需求2：用户登录
    需求如下：
    1）访问登录页面
    2）填写用户名密码后提交
    3）服务器判断用户是否存在
    4）如果登录失败 ---> 返回用户名或者密码错误信息

*/


/*
第三阶段：
    页面jsp动态化
    抽取页面中相同的内容
    BaseServlet的提取 （在实际的项目开发中，一个模块，一般只使用一个Servlet程序）
    数据的封装和抽取BeanUtils的使用（BeanUtils工具类，它可以一次性的把所有请求的参数注入到JavaBean中）

第五阶段-图书模块
    MVC:Model模型，View视图，Controller控制器
    1.4编写图书模块的Service和测试service

    1.5 编写图书模块的web层，和页面联调测试。
        补充: 首页      manager.jsp页面   ------------>     BookServlet程序
                                                        public void list(){
                                                            1.查询全部图书
                                                            2.保存到Request域中
                                                            3.请求转发到page/manager/manager.jsp页面
                                                        }
                                                                    |
                                                                    |
                                                                    |
                                                                    ↓
                                                        /page/manager/manager.jsp页面
                                                        展示所有图书信息
                                                        1.从Request域中获取全部图书信息
                                                        2.使用JSTL标签库遍历输出
                                                        如果访问jsp无法直接得到数据，那么可以让程序先访问Servlet程序，再转发

        补充：
           前台：
            前台是给普通用户使用,一般不需要权限检查,就可以访问的资源，
            功能都属于前台功能。就比如：淘宝（或某东网站）不登陆就可以访问首页（包含商品浏览）
            前台的地址是：/client/bookServlet
           后台：
            后台是给管理员使用的。一般需要权限检查，才可以访问到的资源，或页面，或功能。
            后台的地址是：/manager/bookServlet

        表单重复提交：
            当用户提交完请求，浏览器会记录下最后一次请求的全部信息。当用户按下功能键F5，就会发起浏览器记录的最后一次请求

          在点击修改图书数据时遇到的问题：book_edit.jsp页面，即要做添加操作。又要做修改操作。而到底是添加，
        还是修改是由一个隐藏域来决定的。如何动态修改隐藏域<input type="hidden" name="action" value="add">
        让它的值可实现添加，又可以实现修改操作？

        解决方案一: 可以在发起请求时附带上当前要操作的值，并注入到隐藏域中。
        解决方案二：可以通过判断当前请求参数中是否包含有id参数。如果有说明是修改操作。如果没有说明是添加操作。
                    ${empty param.id?"add":"update"}
        解决方案二：可以通过判断当前请求参数中是否包含有修改的图书信息对象，因为修改操作会经过BookServlet中getBook方法，
                    此时请求域中会存放有要修改的对象，而添加操作则是直接进入到book_edit.jsp中。如果有说明是修改操作。
                    如果没有说明是添加操作。

    图书分页的分析：
        由分页的视图分析出分页的对象模型Page类
        pageNo          当前页码
        pageTotal       总页码
        pageTotalCount  总记录数
        pageSize        每页显示数量
        items           当前页数据
        --分析-------------------------------------------------------------
        pageNo 当前页码是由客户端进行传递

        pageSize 每页显示数量由两种因素决定。
            一：客户端进行传递。
            二：由页面布局决定

        pageTotalCount 总记录数可以由sql语录求得
            sql语句是：select count(*) from 表名

        pageTotal 总页码可以由总记录数/每一页得到。
            注：总记录数%每页数量>0，则总页码+1

        item是当前页数据，也是可以由sql语句求得。
        sql语句是：select * from 表名 limit begin ,pageSize;
        begin可以由公式求得：（pageNo - 1）* pageSize
        假设，当前是第1页，每页4条记录，则begin = (1 - 1) * 4 得：0
        假设，当前是第2页，每页4条记录，则begin = (2 - 1) * 4 得：4
        假设，当前是第3页，每页4条记录，则begin = (3 - 1) * 4 得：8

    6)分页模块中，页码1，2，【3】，4，5的显示，要显示5个页码，并且页码可以点击跳转。
        需求：显示5个连续的页码，而且当前页码在中间。除了当前页码之外，每个页码都可以点击跳到指定页


项目第六阶段
3.1登录---显示用户名
3.2 登出---注销用户
    1）销毁Session中用户登录的信息（或者销毁Session）
    2）重定向到首页或登录页面

3.3 表单重复提交之--------验证码
表单重复提交有三种常见情况：
    一：提交完表单。服务器使用请求来进行页面跳转。这个时候。用户按下功能键F5，就回发起最后一次的请求。造成表单重复提交问题。
        解决方法：使用重定向来进行跳转
    二：用户正常提交服务器，但是由于网络延迟等原因，迟迟未收到服务器的响应。这个时候，用户以为提交失败，就会多点几次提交操作，
        也会造成表单重复提交。
    三：用户正常提交服务器。服务器也没有延迟，但是提交完成后，用户回退浏览器，重新提交。也会造成表单重复提交

书城项目的第六、第七阶段
今日任务:
1. 项目第六阶段：购物车
1.1 购物车模块分析
    由购物车的界面分析出购物车的模型
        购物车的对象Cart
        totalCount      总商品数量
        totalPrice      总商品金额
        items           购物车商品

        购物车商品项CartItem
        id          商品编号
        name        商品名称
        count       商品数量
        price       商品单价
        totalPrice  商品总价

    市面上购物车的实现技术版本有：
    1.Session版本（把购物车信息保存到Session域中）
    2.数据库版本（把购物车信息，保存到数据库）
    3.redis+数据库+Cookie（使用Cookie+Redis缓存，和数据库）

    购物车的功能：
                        CartServlet程序                       Cart购物车
    加入购物车           addItem()添加商品项              addItem(CartItem)

    删除商品项           deleteItem()删除商品项           deleteItem(id)删除商品项

    清空购物车           clear()清空购物车                clear()清口购物车

    修改商品数量          updateCount()修改商品数量         updateCount(id,count)  修改商品数量

    添加购物车后重定向页面跳转问题：
        在HTTP协议中有一个请求头，叫Referer，它可以把请求发起时，浏览器地址栏中的地址发送给服务器。

由订单界面，分析出订单模型
订单模块的数据类型：Order订单，OrderItem订单项

Order订单：
        orderId：订单号（唯一）
        create：下单时间
        price： 总金额
        status：状态(0未发货，1已发货，2已签收)
        userId：用户编号

OrderItem订单项：
       id：  主键编号：
       name：商品名称
       count: 数量
       price：单价
       totalPrice：总价
       orderId  ：订单号

列出订单该有的功能        orderServlet程序             OrderService程序                OrderDao程序
生成订单：               createOrder()

查询所有订单（管理员）：  showAllOrder()

发货（管理员）：         sendOrder()

查看订单发货详情：       showOrderDetail()

查看我的订单：           showMyOrder()

签收订单：               receiverOrder()

---------------------------------------------------------------------------------
视频：订单模块步骤
1. 分析订单模块所要创建的JavaBean或表，还有关联的Servlet，Service，Dao
2. 创建数据库表t_order,t_order_item
   创建类Order ，OrderItem
3. 编写订单模块的Dao程序和测试

书城的第八阶段：
1. 使用Filter过滤器拦截/pages/manager/所有内容，实现权限检查
2. 使用Filter和ThreadLocal组合管理事物

    回顾jdbc的数据库事物管理
    Connection conn = JdbcUtils.getConnection();

    try{
        conn.setAutoCommit(false); //设置手动管理事物
        执行一系列的jdbc操作
        conn.commit();  手动提交事务
    }catch(Exception e){
        conn.rollback(); //回滚事务
    }finally{
        JdbcUtils.close(conn);
    }

要确保所有操作要么成功，要么失败，就必须要使用数据库事务。
要确保所有的操作都在一个事务内，就必须要确保所有的操作都使用在同一个Connection连接对象。
如何确保所有的操作都使用同一个Connection对象？
    我们可以使用Threadlocal对象，来确保所有的操作都使用同一个Connection对象。
    ThreadLocal要确保所有操作都使用同一个Connection连接对象。
    那么操作的前提条件是所有操纵都在同一线程中完成

3.2 使用Filter过滤器统一给所有的Service丰富都加上try——catch。来进行实现的管理。

3.3 将所有异常都统一交给Tomcat，让Tomcat展示友好的错误信息页面。
    在web.xml中我们可以通过错误页面配置来进行管理


书城项目第九阶段
1. 使用AJAX验证用户名是否可用
2. 使用AJAX修改把商品添加到购物车
    CartServlet程序
    public void ajaxAddItem(){
        1. 获取商品编号
        2. 调用bookService.queryBookById()：Book;
        3. 把book对象转换成为CartItem
        4. 获取Session中的购物车对象Cart
        5. 调用cart.addItem();添加商品项
        6. 返回购物车总的商品数量和最后一个添加商品名称
    }












*/


/**
 * @author wx
 * @create 2023-05-17 10:39
 */
public class _1_流程 {
}
