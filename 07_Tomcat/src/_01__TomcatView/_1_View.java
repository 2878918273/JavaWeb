package _01__TomcatView;


/*
Javaweb的概念
    1.什么是JavaWeb
        Javaweb是指Java语言开发出来可以在万维网上访问浏览的程序
    2.什么是请求，什么是响应，
        请求是指客户端给服务器发送数据，叫请求Request
        响应是指服务器给客户端回传数据，叫响应Response
        关系：两者是成对出现的，有请求就有响应

2. Web资源的分类
web资源按实现的技术和呈现的效果的不同，又分为静态资源和动态资源两种

静态资源： html、css、js、txt、mp4视频，jpg图片
动态资源： jsp页面、Servlet程序

 */



/*
    客户端（浏览器）                                请求发给服务器                    服务器（Tomcat）
http://localhost:8080/baidu/_1_.html        -------------------------------->       /baidu工程
http:   表示协议                                                                    _1_.htlm
localhost   是ip地址                                                             服务器收到请求之后，读取你要访问的资源文件，
:8080   是端口号                                                                 然后回传给客户端要的页面的内容
/baidu  是工程路径                               回传 _1_.html页面
/_1_.html   哪个文件                      <--------------------------------


*/

import org.apache.commons.dbutils.QueryRunner;

import javax.management.Query;

/**
 * @author wx
 * @create 2023-05-09 18:53
 */
public class _1_View {
    public static void main(String[] args) {
        QueryRunner runner = new QueryRunner();
    }

}
