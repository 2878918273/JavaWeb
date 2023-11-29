package books.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


/**
 * 把Map中的值注入到对应的JavaBean属性中
 * @author wx
 * @create 2023-05-18 20:36
 */
public class WebUtils {
    public static <T> T copyParamToBean( T bean,Map map){  //把req换成Map，适用返回更好一些，耦合度更低，使用更加灵活

        try {
            //把所有请求的参数都注入到user对象中
            BeanUtils.populate(bean,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符转换成为int类型的数据
     * @param strInt
     * @param defultValue
     * @return
     */
    public static int parseInt(String strInt,int defultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defultValue;

    }


}
