package books.service.impl;

import books.dao.UserDao;
import books.dao.impl.UserDaoImpl;
import books.pojo.User;
import books.service.UserService;

/**
 * @author wx
 * @create 2023-05-17 16:35
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDao.querUserUsername(username);
        if(user == null){
            //如果为null,说明没查到，
            return false;
        }
        return true;
    }
}
