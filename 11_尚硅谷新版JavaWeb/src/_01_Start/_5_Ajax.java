package _01_Start;

/*
1. 回顾：
    Ajax：异步的JavaSript and XML
    目的 ： 用来发送异步的请求，然后当服务器给我响应的时候再进行回调操作
    好处： 提高用户体验；局部刷新；降低服务器负担，减轻浏览器压力、减轻网络带宽压力
    开发步骤：
        1）创建XMLHttpRequest
        2）调用open进行设置：“GET”，URL，true
        3）绑定状态改变时执行的回调函数 - onreadystatechange
        4）发送请求 - send()
        5）编写回调函数，在回调函数中，我们只对XMLHttpRequest的readystate为4的时候感兴趣
                                    我们只对XMLHttpRequest的status为200的时候感兴趣

    0 - （未初始化）还没有调用send()方法
    1 - （载入）已调用send（）方法，正在发送请求
    2 - （载入完成）send()方法执行完成，已经接收到全部响应内容
    3 - （交互）正在解析响应内容
    4 - （完成）响应内容解析完成，可以在客户端调用了

*/

/**
 * @author wx
 * @create 2023-05-31 16:54
 */
public class _5_Ajax {
}
