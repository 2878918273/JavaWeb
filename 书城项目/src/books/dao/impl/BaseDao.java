package books.dao.impl;

import books.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wx
 * @create 2023-05-17 14:05
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update方法来执行:Insert\Update\Delete语句
     *
     * @return 若返回-1，说明执行失败；若返回正数，表示其影响的行数
     */
    public int update(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询返回一个JavaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        BeanHandler<T> beanHandler = new BeanHandler<T>(type);
        try {
            return queryRunner.query(conn, sql, beanHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;

    }

    /**
     * 查询返回多个JavaBean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForLsit(Class<T> type, String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        BeanListHandler<T> listHandler = new BeanListHandler<>(type);
        try {
            return queryRunner.query(conn, sql, listHandler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;

    }

    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = JdbcUtils.getConnection();
        ScalarHandler scalarHandler = new ScalarHandler();
        try {
            return queryRunner.query(conn,sql,scalarHandler,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

}
