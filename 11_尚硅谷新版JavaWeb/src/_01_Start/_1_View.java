package _01_Start;

/*
MVC：model(模型)、View(视图)、Controller(控制器)
视图层：用于做数据展示以及和用户交互的一个界面
控制层：能够接受客户端的请求，具体的业务功能还是需要借助模型
模型层：模型分为很多种：（数据访问模型(DAO)；业务逻辑模型(BO)；值对象模型(POJO)；数据传输对象（DTO））
        有比较简单的pojo/vo(value object),有业务模型组件，有数据访问层组件
    1）pojo/vo:值对象
    2）DAO:数据访问对象
    3）BO: 业务对象
        区分业务对象和数据访问对象：
        1）DAO中的方法都是单精度方法或者称之为细粒度方法。什么叫单精度？一个方法只考虑一个操作，比如添加，那就是insert操作
        2）BO中的方法属于业务方法，实际的业务是比较复杂的，因此业务方法的粒度是比较粗的
            注册这个功能属于业务功能，也就是说注册这个方法属于业务方法。
            那么这个业务方法中包含了多个DAO方法。也就是说注册这个业务功能需要通过多个DAO方法的组合调用，从而完成注册功能的开发
            注册：
                1.检查用户名是否已经被注册  ---DAO中的select操作
                2.向用户表新增一条新用户记录     ---DAO中的insert操作
                3.向用户积分表新增一条记录（新用户默认初始化积分100分） ---DAO中的insert操作
                4.向系统消息表新增一条记录（）
                .......




*/

/**
 * @author wx
 * @create 2023-05-30 20:26
 */
public class _1_View {
}
