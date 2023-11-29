package books.dao;


import books.pojo.User;

/** 能做什么
 * @author wx
 * @create 2023-05-17 14:38
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户，反之亦然
     *
     */
    public User querUserUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果返回null，说明用户名或密码错误。反之亦然。
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 如果返回-1，说明保存失败，返回正数表示影响的值
     */
    public int saveUser(User user);


}
