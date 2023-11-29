package books.test;

import books.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author wx
 * @create 2023-05-17 13:46
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 50; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }

    }
}
