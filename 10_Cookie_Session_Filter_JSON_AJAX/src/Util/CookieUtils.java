package Util;

import javax.servlet.http.Cookie;

/**
 * @author wx
 * @create 2023-05-16 19:56
 */
public class CookieUtils{

   public static Cookie getCookie(Cookie[] cookies,String name){
        if(cookies == null || name == null || cookies.length == 0){
            return null;
        }

        for(Cookie cookie : cookies){
            if(name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
   }
}
