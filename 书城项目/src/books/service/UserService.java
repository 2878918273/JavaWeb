package books.service;

import books.pojo.User;

/**
 * @author wx
 * @create 2023-05-17 16:21
 */
public interface UserService {
    //根据具体业务，实现不同需求

    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，说明登录成功
     */
    public User login(User user);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);

}
