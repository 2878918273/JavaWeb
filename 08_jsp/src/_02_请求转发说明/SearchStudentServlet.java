package _02_请求转发说明;

import 草稿.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wx
 * @create 2023-05-13 16:58
 */
public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        //2.发sql语句查询学生的信息
        //3.使用for循环生成查询到的数据做模拟
        List<Student> studentList = new ArrayList<Student>();
        for (int i = 1; i <= 10; i++) {
            studentList.add(new Student(100 + i, "name" + i, i + 18));
        }
        //4.保存查询到的结果（学生信息）到request域中
        req.setAttribute("sl",studentList);
        //5.请求转发到showStudent.jsp页面
        req.getRequestDispatcher("/showStudent.jsp").forward(req,resp);

    }
}
