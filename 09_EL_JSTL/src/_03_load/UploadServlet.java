package _03_load;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/*
commons-fileupload.jar 需要依赖commons-io-jar包，所以两个包我们都要引入。
第一步，就是需要导入这两个jar包：

commons-fileupload.jar和commons-io-jar包中，我们常用的类有哪些？

ServletFileUpload类 用于解析上传的数据
FileItem类，表示每一个表达项

boolean ServletFileUpload.isMultipartContent(HttpServletRequest request);
判断当前上传的数据格式是否是多段的格式
public  List<File> parseRequest(HttpServletRequest reuqest)
解析上传的数据
boolean FileItem.isFormField()
    判断当前这个表单项，是否是普通的表单项。还是上传的文件类型。
    true表示普通类型的表单项
    false表示上传的文件类型
String FileItem.getFieldName()
    获取表单项的name属性值
String FileItem.getString()
    获取表单项的值
String FileItem.getName()
    获取上传的文件名
void FileItem.write(file);
    将上传的文件写到参数file所指向的硬盘位置。

*/

/**
 * @author wx
 * @create 2023-05-15 19:51
 */
public class UploadServlet extends HttpServlet {
    /**
     * 用来处理用户上传的数据
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //1.先判断上传的数据是否为多段数据（只有是多段的数据，才是文件上传的）
        if (ServletFileUpload.isMultipartContent(req)) {
//            创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
//            创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
//
            try {
//              解析上传的数据，得到每一个表单项FileItem
                List<FileItem> list = fileUpload.parseRequest(req);
//              循环判断，每一个表单项,是普通类型，还是上传的文件
                for(FileItem fileItem : list){
                    if(fileItem.isFormField()){
//                      普通表单项
                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        System.out.println("表单项的value属性值" + fileItem.getString("UTF-8"));
                    }else{
//                      上传的文件:D:\java\workspace_idea1\JavaWeb\09_EL_JSTL\Photo
                        System.out.println("表达项的name属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());

                        fileItem.write(new File("D:\\java\\workspace_idea1\\JavaWeb\\09_EL_JSTL\\File\\Photo\\" + fileItem.getName()));

                    }

                }



            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
