package books.test;

import books.pojo.User;
import books.service.UserService;
import books.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author wx
 * @create 2023-05-17 16:51
 */
public class UserServiceTest {
    int i;

    UserService userService = new UserServiceImpl();

    @Test //注册
    public void registUser(){
        userService.registUser(new User(0,"username3","abc123","username3@qq.com"));
        userService.registUser(new User(0,"username4","abc123","username4@qq.com"));
    }

    @Test // 登录
    public void login(){
        User login = userService.login(new User(0, "username3", "abc123", "username@qq.com"));
        System.out.println(login);
    }


    @Test // 是否存在
    public void existsUsername(){
        boolean username3 = userService.existsUsername("username5");
        if(username3) {
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }

    }


    @Test
    public void test_1(){

        System.out.println(i);
    }

}
