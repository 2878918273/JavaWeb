package books.dao.impl;

import books.dao.UserDao;
import books.pojo.User;

/**
 * @author wx
 * @create 2023-05-17 14:57
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User querUserUsername(String username) {
        String sql =  "select id,username,password,email from t_user where username = ?";
        return queryForOne(User.class,sql,username);

    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql =  "select id,username,password,email from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);

    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
