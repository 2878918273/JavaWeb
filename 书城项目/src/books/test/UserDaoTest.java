package books.test;

import books.dao.impl.UserDaoImpl;
import books.pojo.User;
import org.junit.Test;

/**
 * @author wx
 * @create 2023-05-17 15:59
 */
public class UserDaoTest {

    @Test
    public void querUserUsername(){
        UserDaoImpl udi = new UserDaoImpl();
        User admin = udi.querUserUsername("admin");
//        System.out.println(admin);
        if(admin != null){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword(){
        UserDaoImpl udi = new UserDaoImpl();
        User user = udi.queryUserByUsernameAndPassword("admin", "admin");
        if(user == null){
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("登录成功");
        }

    }
    @Test
    public void saveUser(){
        UserDaoImpl udi = new UserDaoImpl();
        int save_id = udi.saveUser(new User(0,"wx","0211","wx@qq.com"));
        System.out.println(save_id);

    }
}
