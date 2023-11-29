package _03_load;
/*
    客户端（浏览器）                                       服务器（Tomcat）
                       发请求、告诉服务器            1.获取要下载的文件名
                   ---------------------------->    2. 读取要下载的文件内容
                        我要下载什么文件             3. 把下载的文件内容回传给客户端
                                                    4. 在回传前，通过响应头告诉客户端返回的数据类型
                                                    5. 还要告诉客户端收到的数据是用于下载使用（还是使用响应头）

*/

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author wx
 * @create 2023-05-15 21:20
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取要下载的文件名
        String filename = "QQ图片1.jpg";

//        2. 读取要下载的文件内容(通过servletContext对象可以读取)
        ServletContext servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("D:\\java\\workspace_idea1\\JavaWeb\\09_EL_JSTL\\web\\File\\" + filename);
        System.out.println("下载的文件类型：" + mimeType);
//        4. 在回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);

//        5. 还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        // Content-Dispositon响应头，表示收到的数据怎么处理
        // attachment表示附件，表示下载使用
        // filename=表示指定下载的文件名
        // url编码是把汉字转换成为%xxx%xxx的格式

        //使用User-Agent请求头判断，动态切换不同方案解决所有浏览器附件中文乱码的问题
        if(req.getHeader("User-Agent").contains("Firefox")){
            //如果是火狐浏览器使用Base64编码
            resp.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?" + new BASE64Encoder().encode("QQ图片1.jpg".getBytes("UTF-8")) + "?=");
        }else{
            //如果不是火狐，是IE或谷歌，使用URL编码操作
            resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
        }

        InputStream resourceAsStream = servletContext.getResourceAsStream("/File/" + filename);

        //获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();

//        3.把下载的文件内容回传给客户端
        //读取输入流中的全部数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);


    }

}
